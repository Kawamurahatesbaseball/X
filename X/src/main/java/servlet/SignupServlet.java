package servlet;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import util.EscapeUtil;
import util.HashUtil;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // パスワード一致確認
        if (!password.equals(confirmPassword)) {
            response.getWriter().println("パスワードが一致しません。<a href='signup.jsp'>戻る</a>");
            return;
        }

        // パスワードの複雑さをチェック（大文字・小文字・数字を含み5文字以上）
        if (!isValidPassword(password)) {
            response.getWriter().println("パスワードは大文字・小文字・数字を含む5文字以上である必要があります。<a href='signup.jsp'>戻る</a>");
            return;
        }

        // ユーザー名を手動でエスケープ（XSS対策）
        String escapedName = EscapeUtil.escapeHtml(name);

        // パスワードをハッシュ化して登録処理へ
        String hashedPassword = HashUtil.hashPassword(password);
        User user = new User(escapedName, hashedPassword);
        boolean result = UserDAO.insert(user);

        if (result) {
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().println("登録に失敗しました。<a href='signup.jsp'>戻る</a>");
        }
    }

    // パスワードのバリデーション（大文字・小文字・数字を含み5文字以上）
    private boolean isValidPassword(String password) {
        return password != null &&
               password.length() >= 5 &&
               password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }
}
