package servlet;

import java.io.IOException;
import java.util.List;

import dao.PostDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Post;
import model.User;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		// user_idパラメータを取得。なければ自分のプロフィールを表示
		String userIdParam = request.getParameter("user_id");
		int profileUserId;
		try {
			profileUserId = (userIdParam != null) ? Integer.parseInt(userIdParam) : loginUser.getId();
		} catch (NumberFormatException e) {
			profileUserId = loginUser.getId();
		}

		// プロフィールユーザーの投稿を取得（いいね判定のためログインユーザーIDも渡す）
		List<Post> userPosts = PostDAO.findByUserId(profileUserId, loginUser.getId());
		request.setAttribute("userPosts", userPosts);

		// プロフィールユーザー情報を取得
		User profileUser = UserDAO.findById(profileUserId);
		if (profileUser == null) {
			// 存在しないユーザーの場合は自分のプロフィールに戻す
			response.sendRedirect("profile");
			return;
		}
		request.setAttribute("profileUser", profileUser);

		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}
}
