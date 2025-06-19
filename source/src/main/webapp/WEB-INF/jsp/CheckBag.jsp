<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>防災バックリスト</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bagfood.css">
</head>
<body>

<header>
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
		<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>
<!-- 変更内容をポストする -->
<form action="CheckBag" method="post">

<div class="bag-title">
	<h1>防災バッグリスト</h1>
	<button type = "submit">登録</button>
</div>

<h2>必須の備え</h2>

<section>
	<div class="grid-container">
	
	<!-- 必須項目の入力 -->
	 <c:forEach var = "bag" begin="0" end="3" items="${checkBag}" >
		<div class="grid-item">
			<div class="first-item">
			<!-- データベースに入っている値がtrueだったらチェックを入れる -->
				<input type="checkbox" name = "cheakBag" value = "true" ${bag.bagCheck ? "checked": "" }>
			<!-- データベースに入っている名前を取り出す -->
				<input type=text name="bagname" value="${bag.bagName}">
			</div>
			
			<!-- データベースに入ってる個数と一致してる値を初期設定にする -->
			<div class="second-item">
			<img src="${pageContext.request.contextPath}/img/number.png">
			<select >
				<c:forEach var = "e" begin="1" end="20">
					<option ${e == bag.bagStock ? "selected" : "" }> ${e} 個</option>>
				</c:forEach>
			</select>
			</div>
			
			<!-- データベースに入ってるリンクの情報を取得 -->
			<div class="third-item">
				<img src="${pageContext.request.contextPath}/img/Link.png">
				<textarea  name="link">${bag.bagLink}</textarea>
			</div>
		</div>
	</c:forEach>
	</div>
</section>



<h2>自由項目</h2>	

<section>
	<div class="grid-container">
	<!-- 必須項目の入力 　begin-->
	 <c:forEach var = "bag" begin="4" end="8" items="${checkBag}" >
		<div class="grid-item">
			<div class="first-item">
			<!-- データベースに入っている値がtrueだったらチェックを入れる -->
				<input type="checkbox" name = "cheakBag" value = "true" ${bag.bagCheck ? "checked": "" }>
			<!-- データベースに入っている名前を取り出す -->
				<input type=text name="bagname" value="${bag.bagName}">
			</div>
			
			<!-- データベースに入ってる個数と一致してる値を初期設定にする -->
			<div class="second-item">
			<img src="${pageContext.request.contextPath}/img/number.png">
			<select >
				<c:forEach var = "e" begin="1" end="20">
					<option ${e == bag.bagStock ? "selected" : "" }> ${e} 個</option>>
				</c:forEach>
			</select>
			</div>
			
			<!-- データベースに入ってるリンクの情報を取得 -->
			<div class="third-item">
				<img src="${pageContext.request.contextPath}/img/Link.png">
				<textarea  name="link">${bag.bagLink}</textarea>
			</div>
		</div>
	</c:forEach>	
	</div>
</section>
</form>>


<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>
</body>
</html>