package servlet;

import java.io.IOException;

import dao.PostDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/delete")
public class DeletePostServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("loginUser");

		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		try {
			int postId = Integer.parseInt(request.getParameter("post_id"));
			boolean success = PostDAO.delete(postId, user.getId());

			if (!success) {
				request.setAttribute("error", "投稿の削除に失敗しました。");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("error", "不正なリクエストです。");
		}

		response.sendRedirect("timeline");
	}
}
