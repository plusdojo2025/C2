<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/img/MamoSona.png">
<title>MamoとSona | 家族ID登録</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/registfamilyuser.css">
</head>
<body>
	<h1>【新規登録】</h1>
	<h2>家族IDを新しく作成</h2>
	<form action="RegistFamilyServlet" id="formid" method="post" autocomplete="off">
	
		<div class="form" style="margin-top: 40px;">
			<label for="familyId" >家族ID</label><br>
			 <input type="text" id="familyId" name="familyId" value="${requestScope.familyId}" class="idform"><br>
			 <span id="familyIderror" style="color:red;"></span>
			 <!-- エラーメッセージ -->
				<c:if test="${not empty error}">
    			<span style="color:red; display: inline-block; margin-top: 5px;">${error}</span>
				</c:if>
		</div>
		<div class="submit">
			<input type="submit" id="register" name="register" value="登録する" style = "margin-top: 35px" >
		</div>
		<div class="buttonimage">
			<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona1"> 
			<img src="img/MamoSona.png" alt="MamoSona" class="MamoSona2">
		</div>
	</form>
	
	<script>
	// id=registerがsubmitされたとき
		document.getElementById("formid").addEventListener("submit",
				function(e) {
					const familyIdInput = document.getElementById("familyId");
					const errorspan = document.getElementById("familyIderror");

					if (familyIdInput.value.trim()==="") {
						errorspan.textContent = "家族IDを入力してください。";
						e.preventDefault(); // 送信をキャンセル
					} else {
						errorspan.textContent = ""; // 正常時はエラーを消す
					}
				});
	</script> 
</body>
</html>