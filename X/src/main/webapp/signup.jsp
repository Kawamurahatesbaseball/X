<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet" href="style.css">
<style>
.signup-container {
	max-width: 400px;
	margin: 60px auto;
	padding: 30px;
	background-color: #fff;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.signup-title {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

.signup-form .form-group {
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
	background-color: #28a745;
	color: #fff;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	font-weight: bold;
}

.form-button:hover {
	background-color: #218838;
}

.login-link {
	text-align: center;
	margin-top: 20px;
}

.login-link a {
	color: #007bff;
	text-decoration: none;
}

.login-link a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="signup-container">
		<h2 class="signup-title">新規登録</h2>
		<form action="signup" method="post" class="signup-form">
			<div class="form-group">
				<label for="name">ユーザー名：</label> <input type="text" id="name"
					name="name" required class="form-input">
			</div>
			<div class="form-group">
				<label for="password">パスワード：</label> <input type="password"
					id="password" name="password" required class="form-input">
			</div>
			<div class="form-group">
				<label for="confirm_password">パスワード（再入力）：</label> <input
					type="password" id="confirm_password" name="confirm_password"
					required class="form-input">
			</div>
			<div class="form-group">
				<button type="submit" class="form-button">登録する</button>
			</div>
		</form>
		<p class="login-link">
			すでに登録済みですか？ <a href="login.jsp">ログイン</a>
		</p>
	</div>
</body>
</html>
