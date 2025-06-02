<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="model.User"%>

<%
User loginUser = (User) session.getAttribute("loginUser");
if (loginUser == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール編集</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<h1 class="welcome">プロフィール編集</h1>

		<form action="profile_edit" method="post" class="post-form">
			<label for="bio">自己紹介：</label><br>
			<textarea id="bio" name="bio" class="post-textarea" rows="5"
				maxlength="500"><%=loginUser.getBio() != null ? loginUser.getBio() : ""%></textarea>

			<button type="submit" class="post-button">更新</button>
		</form>

		<p>
			<a href="profile" class="menu-link">プロフィールに戻る</a>
		</p>
	</div>
</body>
</html>
