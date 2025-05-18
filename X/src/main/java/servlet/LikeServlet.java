package servlet;

import java.io.IOException;

import dao.LikeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		int postId = Integer.parseInt(request.getParameter("post_id"));
		boolean hasLiked = LikeDAO.hasLiked(loginUser.getId(), postId);

		if (hasLiked) {
			LikeDAO.removeLike(loginUser.getId(), postId);
		} else {
			LikeDAO.addLike(loginUser.getId(), postId);
		}

		response.sendRedirect("timeline"); // タイムラインに戻る
	}
}
