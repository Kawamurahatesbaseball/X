package servlet;

import java.io.IOException;
import java.util.List;

import dao.PostDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Post;
import model.User;

@WebServlet("/timeline")
public class TimelineServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		//		List<Post> posts = PostDAO.findAll();
		//		request.setAttribute("posts", posts);

		List<Post> posts = PostDAO.findAll(loginUser.getId());
		request.setAttribute("posts", posts);

		request.getRequestDispatcher("timeline.jsp").forward(request, response);
	}
}
