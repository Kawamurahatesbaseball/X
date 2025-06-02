package servlet;

import java.io.IOException;

import com.google.gson.JsonObject;

import dao.FollowDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		HttpSession session = request.getSession(false);
		User loginUser = (User) (session != null ? session.getAttribute("loginUser") : null);
		if (loginUser == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		String followeeIdParam = request.getParameter("followee_id");
		if (followeeIdParam == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "followee_idがありません");
			return;
		}

		int followeeId;
		try {
			followeeId = Integer.parseInt(followeeIdParam);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "followee_idが不正です");
			return;
		}

		// 自分自身をフォローできないように制御
		if (loginUser.getId() == followeeId) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "自分自身はフォローできません");
			return;
		}

		boolean isFollowing = FollowDAO.isFollowing(loginUser.getId(), followeeId);
		boolean success;

		if (isFollowing) {
			success = FollowDAO.unfollow(loginUser.getId(), followeeId);
		} else {
			success = FollowDAO.follow(loginUser.getId(), followeeId);
		}

		if (!success) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "DB処理に失敗しました");
			return;
		}

		// 成功レスポンスを返す
		JsonObject json = new JsonObject();
		json.addProperty("isFollowing", !isFollowing);
		json.addProperty("followerCount", FollowDAO.countFollowing(followeeId));

		response.getWriter().print(json.toString());
	}
}
