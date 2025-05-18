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
import util.EscapeUtil;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("loginUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String content = EscapeUtil.escapeHtml(request.getParameter("content"));

        if (content == null || content.isBlank()) {
            request.setAttribute("error", "投稿内容が空です。");
            request.getRequestDispatcher("post.jsp").forward(request, response);
            return;
        }

        boolean success = PostDAO.insert(user.getId(), content);

        if (success) {
            response.sendRedirect("timeline");
        } else {
            request.setAttribute("error", "投稿に失敗しました。");
            request.getRequestDispatcher("post.jsp").forward(request, response);
        }
    }
}
