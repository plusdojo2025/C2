<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お気に入りライフハック</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lifehackfavorite.css">
</head>
<body class="lifehackfavorite">
<div class="wrapper">
<header >
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
		<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>

<h2>お気に入りライフハック</h2>
<div class="lifehack-request-button">
<a href="${pageContext.request.contextPath}/LifeHackRequest" class="lifehack-request-button">ライフハックを申請</a>
</div>

<main>
    <div class="card-list">
      <c:forEach var="hack" items="${favoriteList}">
        <div class="card">
          <img src="${pageContext.request.contextPath}/img/${hack.image}" alt="画像">
          <div class="title">${hack.title}</div>
          <div class="desc">${hack.explanation}</div>
          <a href="${pageContext.request.contextPath}/detail?id=${hack.id}" class="detail"></a>
        </div>
      </c:forEach>
    </div>

<!-- デザイン確認用    
    <div class="card-list">
	<div class="card">
		<div class="title"></div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-1">
		<p class="detail"></p><br>		
	</div>	
</div>
--> 
  </main>
  </div>
<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>
</body>
</html>