/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2025-05-18 11:47:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import model.User;
import model.Post;
import java.util.List;
import java.time.format.DateTimeFormatter;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("model.Post");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.time.format.DateTimeFormatter");
    _jspx_imports_classes.add("model.User");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

User loginUser = (User) session.getAttribute("loginUser");
User profileUser = (User) request.getAttribute("profileUser");
List<Post> userPosts = (List<Post>) request.getAttribute("userPosts");
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

if (profileUser == null) {
	response.sendRedirect("timeline");
	return;
}

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>プロフィール</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("<style>\n");
      out.write(".menu {\n");
      out.write("	position: absolute;\n");
      out.write("	top: 20px;\n");
      out.write("	left: 20px;\n");
      out.write("	padding: 10px;\n");
      out.write("	background-color: #f7f7f7;\n");
      out.write("	border-radius: 8px;\n");
      out.write("	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".menu-link {\n");
      out.write("	display: block;\n");
      out.write("	margin-bottom: 10px;\n");
      out.write("	color: #333;\n");
      out.write("	text-decoration: none;\n");
      out.write("	font-weight: bold;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".menu-link:hover {\n");
      out.write("	text-decoration: underline;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("	");
      out.write("\n");
      out.write("	<div class=\"menu\">\n");
      out.write("		");

		if (loginUser != null && loginUser.getId() == profileUser.getId()) {
		
      out.write("\n");
      out.write("		<a href=\"profile_edit.jsp\" class=\"menu-link\">プロフィール編集</a>\n");
      out.write("		");

		}
		
      out.write("\n");
      out.write("		<a href=\"timeline\" class=\"menu-link\">タイムライン</a>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("	<div class=\"container\">\n");
      out.write("		<h1 class=\"welcome\">");
      out.print(profileUser.getName());
      out.write("さんのプロフィール\n");
      out.write("		</h1>\n");
      out.write("\n");
      out.write("		<p>\n");
      out.write("			<strong>自己紹介:</strong>\n");
      out.write("			");
      out.print(profileUser.getBio() != null && !profileUser.getBio().isEmpty()
		? profileUser.getBio()
		: "まだ自己紹介がありません");
      out.write("\n");
      out.write("		</p>\n");
      out.write("\n");
      out.write("		<hr>\n");
      out.write("		<h2>投稿一覧</h2>\n");
      out.write("\n");
      out.write("		<div class=\"post-list\">\n");
      out.write("			");

			if (userPosts != null && !userPosts.isEmpty()) {
				for (Post post : userPosts) {
			
      out.write("\n");
      out.write("			<div class=\"post-item\">\n");
      out.write("				<p class=\"post-user\">\n");
      out.write("					<a href=\"profile?user_id=");
      out.print(post.getUserId());
      out.write("\"\n");
      out.write("						class=\"post-user-link\"> ");
      out.print(post.getUserName());
      out.write("\n");
      out.write("					</a>\n");
      out.write("				</p>\n");
      out.write("				<p class=\"post-content\">");
      out.print(post.getContent());
      out.write("</p>\n");
      out.write("				<p class=\"post-date\">\n");
      out.write("					投稿日:\n");
      out.write("					");
      out.print(dtf.format(post.getCreatedAt()));
      out.write("\n");
      out.write("				</p>\n");
      out.write("				<p class=\"post-likes\">\n");
      out.write("					いいね\n");
      out.write("					");
      out.print(post.getLikeCount());
      out.write("\n");
      out.write("					");

					if (post.isLikedByCurrentUser()) {
					
      out.write("\n");
      out.write("					<span class=\"liked-star\">★いいね済み</span>\n");
      out.write("					");

					}
					
      out.write("\n");
      out.write("				</p>\n");
      out.write("			</div>\n");
      out.write("			");

			}
			} else {
			
      out.write("\n");
      out.write("			<p>まだ投稿がありません。</p>\n");
      out.write("			");

			}
			
      out.write("\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
