<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/img/MamoSona.png">
<title>MamoとSona | 防災バックリスト</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bagfood.css">
</head>
<body>

<header >
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
		<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>
<!-- 変更内容をポストする -->
<form action="${pageContext.request.contextPath}/CheckBagServlet" method="post">

<div class="bag-title">
	<h1>防災バッグリスト</h1>
	<button type = "submit" id = "regist">登録</button>
</div>

<h2>必須の備え</h2>

<section>
	<div class="grid-container">
	
	<!-- 必須項目の入力 -->
	 <c:forEach var = "bag" begin="0" end="13" items="${checkBag}" >
		<div class="grid-item">
			<div class="first-item">
			<!-- bagNimberをリクエストスコープで渡す -->
			<input type="hidden" name="bagNumber[]" value="${bag.bagNumber}">
			<!-- データベースに入っている値がtrueだったらチェックを入れる -->
				<input type="checkbox" name = "checkBag[]" value = "${bag.bagNumber}" ${bag.bagCheck ? "checked": "" }>
			<!-- データベースに入っている名前を取り出す -->
				<input type=text name="bagname[]" value="${bag.bagName}" readonly>
			</div>
			
			<!-- データベースに入ってる個数と一致してる値を初期設定にする -->
			<div class="second-item">
			<img src="${pageContext.request.contextPath}/img/number.png">
			<select name = "bagStock[]">
				<c:forEach var = "e" begin="1" end="20">
					<option value="${e}" ${e == bag.bagStock ? "selected" : "" }> ${e}個 </option>
				</c:forEach>
			</select>
			</div>
			
			<!-- データベースに入ってるリンクの情報を取得 -->
			<div class="third-item">
				<img src="${pageContext.request.contextPath}/img/Link.png">
				<textarea  name="link[]" readonly>${bag.bagLink}</textarea>
			</div>
		</div>
	</c:forEach>
	</div>
	<p>引用元：首相官邸ホームページ</p>
</section>



<h2>自由項目</h2>	

<section>
	<div class="grid-container">
	<!-- 必須項目の入力 　begin-->
	 <c:forEach var = "bag" begin="14" end="21" items="${checkBag}" >
		<div class="grid-item">
			<div class="first-item">
			<!-- bagNimberをリクエストスコープで渡す -->
			<input type="hidden" name="bagNumber[]" value="${bag.bagNumber}">
			<!-- データベースに入っている値がtrueだったらチェックを入れる -->
				<input type="checkbox" name = "checkBag[]" value = "${bag.bagNumber}" ${bag.bagCheck ? "checked": "" }>
			<!-- データベースに入っている名前を取り出す -->
				<input type="text" name="bagname[]" value="${bag.bagName}">
			</div>
			
			<!-- データベースに入ってる個数と一致してる値を初期設定にする -->
			<div class="second-item">
			<img src="${pageContext.request.contextPath}/img/number.png">
			<select name = "bagStock[]">
				<c:forEach var = "e" begin="1" end="20">
					<option value="${e}" ${e == bag.bagStock ? "selected" : "" }> ${e}個</option>
				</c:forEach>
			</select>
			</div>
			
			<!-- データベースに入ってるリンクの情報を取得 -->
			<div class="third-item">
				<img src="${pageContext.request.contextPath}/img/Link.png">
				<textarea  name="link[]">${bag.bagLink}</textarea>
			</div>
		</div>
	</c:forEach>
		
	</div>
</section>
</form>

<footer>
  <h3 class="footertitle">&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>


<script>
'use strict';
document.getElementById("regist").addEventListener("click", function(e) {
	const confirmed = confirm("この内容で登録しますか？");
	if (!confirmed) {
		alert("キャンセルされました");
		e.preventDefault(); // キャンセル時、submitを止める
	}
});
</script>
</body>
</html>