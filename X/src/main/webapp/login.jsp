<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="model.User"%>
<%@ page import="model.Post"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="style.css">
<style>
.login-container {
	max-width: 400px;
	margin: 60px auto;
	padding: 30px;
	background-color: #fff;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.login-title {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

.login-form .form-group {
	margin-bottom: 15px;
}

.form-input {
	width: 100%;
	padding: 10px;
	border-radius: 8px;
	border: 1px solid #ccc;
}

.form-button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	font-weight: bold;
}

.form-button:hover {
	background-color: #0056b3;
}

.signup-link {
	text-align: center;
	margin-top: 20px;
}

.signup-link a {
	color: #007bff;
	text-decoration: none;
}

.signup-link a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2 class="login-title">ログイン</h2>
		<form action="login" method="post" class="login-form">
			<div class="form-group">
				<label for="name">ユーザー名：</label> <input type="text" id="name"
					name="name" required class="form-input">
			</div>
			<div class="form-group">
				<label for="password">パスワード：</label> <input type="password"
					id="password" name="password" required class="form-input">
			</div>
			<div class="form-group">
				<button type="submit" class="form-button">ログイン</button>
			</div>
		</form>
		<p class="signup-link">
			まだ登録していませんか？ <a href="signup.jsp">新規登録</a>
		</p>
	</div>
</body>
</html>
