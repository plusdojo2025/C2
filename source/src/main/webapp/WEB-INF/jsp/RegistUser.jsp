<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/registfamilyuser.css">
</head>
<body>
<h1>【ユーザーの追加】</h1>
<h2>家族IDに新しいユーザーを登録</h2>
	<form action="RegistUserServlet" method="post">
		<div class="form">
			<label for="familyId">家族ID（登録済みの家族IDを入力してください）</label><br> 
			<input type="text" id="familyId" name="familyId" value="" class="idform"><br> 
			<label for="name">氏名</label><br>
			<input type="text" id="name" name="name" value="" class="nameform"><br>
			<label for="mail">メールアドレス</label><br>
			<input type="text" id="mail" name="mail" value="" class="mailform"><br>
			<label for="password">パスワード</label><br>
			<input type="password" id="password" name="password" value="" class="passwordform"><br>
		</div>
		<div class="submit">
			<input type="submit" id="register" name="register" value="登録する">
		</div>
		<div class="buttonimage">
			<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona1">
			
			<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona2">
		</div>
	</form>
	
</body>
</html>