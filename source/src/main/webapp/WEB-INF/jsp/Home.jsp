<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/homemap.css">
<title>Insert title here</title>
</head>
<body>

<header class= "page-header">
	<div class= "logo-header">
	<h1>ここにロゴの写真</h1>
	</div>
</header>


<section>

	<div class="function-menu">
		
			<img src="${pageContext.request.contextPath}/img/stockbag.png">
	
		
		
			<img src="${pageContext.request.contextPath}/img/stockbag.png">
		
	
			<img src="${pageContext.request.contextPath}/img/stockbag.png">
	
		
	
			<img src="${pageContext.request.contextPath}/img/stockbag.png">

	</div>
</section>
















<form action="HomeServlet" method="post">
	<div>
		<input type="submit" id="logout" name="logout" value="ログアウト">
	</div>
</form>
</body>
</html>