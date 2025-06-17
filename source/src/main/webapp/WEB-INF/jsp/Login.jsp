<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>ログイン</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginlifehack.css">
</head>
<body>
	<a href="${pageContext.request.contextPath}/home">ログイン後ホームへ飛ぶ</a>
	<div class="login-frame">
		<div class="login-box">
			<div class="left">
				<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona">
			</div>
			<div class="right">
				<h2>ログイン</h2>
				<form action="login" method="post">
					<div class="form-group">
						<label for="mailaddress">メールアドレス</label><br> 
						<input type="text" id="mailaddress" name="mailaddress" class="underline" value=""><br> 
						<label for="pw">パスワード</label><br>
						<input type="password" id="pw" name="pw" class="underline" value="">
					</div>
					<div>
						<input type="submit" id="submit" name="submit" value="ログイン" class="login-button">
					</div>
				</form>
				<div class="link-box">
					<a href="${pageContext.request.contextPath}/RegistFamilyServlet">新しく家族IDを取得する</a><br>
					<a href="${pageContext.request.contextPath}/RegistUserServlet">家族IDに新しくユーザーを登録する</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>