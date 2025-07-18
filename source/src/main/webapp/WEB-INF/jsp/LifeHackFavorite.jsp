<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/img/MamoSona.png">
<title>MamoとSona | お気に入りライフハック</title>
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

<div class="stripe-container"></div>

<h2>お気に入りライフハック</h2>
<div class="button">
<a href="${pageContext.request.contextPath}/LifeHackRequest" class="lifehack-request-button">ライフハックを申請</a>
<a href="${pageContext.request.contextPath}/LifeHackListServlet" class="favorite-button">ライフハックリスト</a>
</div>

<main>
    <div class="card-list">
    	
    <c:forEach var="hack" items="${favoriteList}">
    
   		 <%-- activeClassを初期化 --%>
		<c:set var="activeClass" value="" />
		<!-- 全ての記事でアクティブ状態にする -->
		<c:set var="activeClass" value="active" />
		
    
		<div class="card">
			<div class="title">${hack.lifehack.title}</div>
			<img src="${hack.lifehack.photo}" alt="画像">	
			<div class="desc">${hack.lifehack.textline}</div>
			<a href="${pageContext.request.contextPath}/detail?id=${hack.lifehack.lifehackNumber}" class="detail"></a>
		
					<!-- お気に入りのハート表示 -->
			<form action="${pageContext.request.contextPath}/LifeHackFavoriteServlet" method="post">
    		<input type="hidden" name="lifehackfavoriteNumber" value="${hack.lifehackfavoriteNumber}"/>
    		
    		<button type="submit" class="favorite-mark ${activeClass}" id = "favorite">♥</button>
  		   </form>
		</div>
		
	</c:forEach>

    </div>


  </main>
  </div>
<footer>
  <h3 class="footertitle">&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>

<script>

document.getElementById("favorite").addEventListener("click", function(e) {
	const confirmed = confirm("お気に入りを解除しますか？");
	if (!confirmed) {
		alert("キャンセルされました");
		e.preventDefault(); // キャンセル時、submitを止める
	}
});
</script>
</body>
</html>