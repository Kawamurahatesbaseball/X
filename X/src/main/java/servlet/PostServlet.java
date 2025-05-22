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

@WebServlet("/post")
public class PostServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String content = request.getParameter("content");
		String parentPostIdStr = request.getParameter("parent_post_id"); // ← 追加

		if (content == null || content.trim().isEmpty()) {
			response.sendRedirect("timeline.jsp");
			return;
		}

		// parent_post_id の処理
		Integer parentPostId = null;
		if (parentPostIdStr != null && !parentPostIdStr.isEmpty()) {
			try {
				parentPostId = Integer.parseInt(parentPostIdStr);
			} catch (NumberFormatException e) {
				e.printStackTrace(); // 不正な値が来た場合は無視（nullのまま）
			}
		}

		// 投稿の保存
		boolean success = PostDAO.insert(loginUser.getId(), content, parentPostId);

		if (!success) {
			request.setAttribute("errorMessage", "投稿に失敗しました。");
		}

		response.sendRedirect("timeline");
	}
}
