<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>ライフハック申請</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/lifehackrequest.css">
</head>
<body>

<header>
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
		<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>

<div class="stripe-container"></div>

	<form action="LifeHackRequest" method="post" enctype="multipart/form-data">
	<h2>【申請】ライフハック</h2>
		<div class="lifehack-title">
			<label for="lifehacktitle" class="label-lifehack">ライフハックタイトル</label><br> 
			<input type="text" id="title" name="title" class="" value=""><br>
		</div>
		<div class="lifehack-explanation">
			<label for="lifehackexplanation">ライフハック説明文</label><br> 
			<textarea id="explanation" name="explanation" class="" rows="10" placeholder="説明を入力してください"></textarea><br>
		</div>
		<div>
      		<input type="file" name="lifehackimg">
    	</div>
		<div class="lifehackrequest-button">
			<input type="submit" id="submit" name="submit" value="申請" class="lifehckrequest-button">
		</div>
	</form>

<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>
</body>
</html>