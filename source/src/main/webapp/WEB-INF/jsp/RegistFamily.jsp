<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家族ID登録</title>
<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/registfamilyuser.css">
</head>
<body>
<h1>【新規登録】</h1>
<h2>家族IDを新しく作成</h2>
	<form action="RegistFamilyServlet" method="post">
		<div class="form">
			<label for="familyId">家族ID</label><br> 
			<input type="text" id="familyId" name="familyId" value="${familyId}" class="idform"><br> 
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