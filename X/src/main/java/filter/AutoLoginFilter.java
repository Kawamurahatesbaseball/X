package filter;

import java.io.IOException;

import dao.AuthTokenDAO;
import dao.UserDAO;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebFilter("/*")
public class AutoLoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loginUser") == null) {
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("auth_token".equals(cookie.getName())) {
						String token = cookie.getValue();
						Integer userId = AuthTokenDAO.findUserIdByToken(token);
						if (userId != null) {
							User user = UserDAO.findById(userId);
							if (user != null) {
								req.getSession(true).setAttribute("loginUser", user);
							}
						}
					}
				}
			}
		}

		chain.doFilter(request, response);
	}
}
