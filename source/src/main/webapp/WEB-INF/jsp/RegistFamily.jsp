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
	<form action="RegistFamilyServlet" id="formid" method="post">
		<div class="form" style="margin-top: 40px;">
			<label for="familyId" >家族ID</label><br>
			 <input type="text" id="familyId" name="familyId" value="${familyId}" class="idform" required><br>
			<span id="familyIderror" style="color: red;"></span>
		</div>
		<div class="submit">
			<input type="submit" id="register" name="register" value="登録する" style="margin-top: 50px;">
		</div>
		<div class="buttonimage">
			<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona1"> <img
				src="img/MamoSona.png" alt="MamoSona" class="MamoSona2">
		</div>
	</form>
	<!--  <script>
	// id=registerがsubmitされたとき
		document.getElementById("formid").addEventListener("submit",
				function(e) {
					const username = document.getElementById("familyId");
					const errorspan = document.getElementById("familyIderror");

					if (familyId === "") {
						errorspan.textContent = "家族IDを入力してください。";
						e.preventDefault(); // 送信をキャンセル
					} else {
						errorspan.textContent = ""; // 正常時はエラーを消す
					}
				});
		</script>
		--> 
</body>
</html>