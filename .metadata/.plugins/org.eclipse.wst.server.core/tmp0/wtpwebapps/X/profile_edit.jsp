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
<style>
.edit-form {
	background-color: #fff;
	padding: 20px;
	border-radius: 12px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	max-width: 600px;
	margin: 0 auto;
}

.edit-form label {
	font-weight: bold;
}

.edit-form textarea {
	width: 100%;
	resize: vertical;
	margin-top: 8px;
	margin-bottom: 16px;
	padding: 10px;
	border-radius: 8px;
	border: 1px solid #ccc;
}

.back-link {
	display: inline-block;
	margin-top: 15px;
	color: #007bff;
	text-decoration: none;
}

.back-link:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="welcome">プロフィール編集</h1>

		<form action="profile_edit" method="post" class="edit-form">
			<label for="bio">自己紹介：</label><br>
			<textarea id="bio" name="bio" rows="5" maxlength="500"><%=loginUser.getBio() != null ? loginUser.getBio() : ""%></textarea>
			<button type="submit" class="post-button">更新</button>
		</form>

		<a href="profile" class="back-link">← プロフィールに戻る</a>
	</div>
</body>
</html>
