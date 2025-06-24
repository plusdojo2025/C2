<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
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
	
<!-- 入力データと登録データが異なる場合、alert を出す（Servlet側のエラーを引用）-->
<c:if test="${pageContext.request.method == 'POST' and not empty error}">
  <script>
    window.onload = function() {
      alert("${fn:escapeXml(error)}");
    };
  </script>
</c:if>

<!-- 未入力でログインボタンを押した場合の処理 -->
<script>
document.getElementById("submit").addEventListener("click", function(event) {
    var mailaddress = document.getElementById("mailaddress").value.trim();
    var password = document.getElementById("pw").value.trim();

    if (mailaddress === "" || password === "") {
        window.alert("全ての項目を入力してください。");
        event.preventDefault();  // フォームの送信を止める
    }
});
</script>
</body>
</html>