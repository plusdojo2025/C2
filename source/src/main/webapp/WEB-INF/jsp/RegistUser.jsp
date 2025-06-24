<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/img/MamoSona.png">
<title>MamoとSona | ユーザー登録</title>
<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/registfamilyuser.css">
</head>
<body>
<h1>【ユーザーの追加】</h1>
<h2>家族IDに新しいユーザーを登録</h2>
	<form action="RegistUserServlet" method="post">
		<div class="form">
			<label for="familyId">家族ID（登録済みの家族IDを入力してください）</label><br> 
			<input type="text" id="familyId" name="familyId" value="" class="idform" style="margin-bottom: 50px;" required><br> 
			<label for="name">氏名</label><br>
			<input type="text" id="name" name="name" value="" class="nameform" style="margin-bottom: 50px;" required><br>
			<label for="mail">メールアドレス</label><br>
			<input type="text" id="mail" name="mail" value="" class="mailform" style="margin-bottom: 50px;" required><br>
			<label for="password">パスワード</label><br>
			<input type="password" id="password" name="password" value="" class="passwordform" style="margin-bottom: 20px;" required><br>
		</div>
		<div class="buttonimage">
			<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona1">
				<div class="submit">
				<input type="submit" id="register" name="register" value="登録する">
				</div>
			<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona2">
		</div>
	</form>
	
<script>
document.getElementById("register").addEventListener("click", function(event) {
    var familyId = document.getElementById("familyId").value.trim();
    var name = document.getElementById("name").value.trim();
    var mail = document.getElementById("mail").value.trim();
    var password = document.getElementById("password").value.trim();

    if (familyId === "" || name === "" || mail === "" || password === "") {
        window.alert("全ての項目を入力してください。");
        event.preventDefault();  // フォームの送信を止める
    }
});
</script>
</body>
</html>