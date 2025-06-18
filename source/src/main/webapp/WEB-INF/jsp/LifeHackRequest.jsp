<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ライフハック申請</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginlifehack.css">
</head>
<body>
	<form>
		<div class="lifehack-title">
			<label for="lifehacktitle">ライフハックタイトル</label><br> 
			<input type="text" id="title" name="title" class="" value=""><br>
		</div>
		<div class="lifehack-explanation">
			<label for="lifehackexplanation">ライフハック説明文</label><br> 
			<input type="text" id="explanation" name="explanation" class="" value=""><br>
		</div>
		<div>
      		<input type="file" name="lifehackimg">
    	</div>
		<div class="request-button">
			<input type="submit" id="submit" name="submit" value="申請" class="login-button">
		</div>
	</form>
</body>
</html>