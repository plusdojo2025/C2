<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>防災バックリスト</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bagfood.css">
</head>
<body>
	<div class=header>
	</div>
	<h2>防災バック</h2>
	<div class=bag-list>
<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="">
	<input type="hidden" name="number" value="${e.number}">
	</form>
</c:forEach>
	</div>
	
<a href="${pageContext.request.contextPath}/home">ホームへ戻る</a>
	
	
</body>
</html>