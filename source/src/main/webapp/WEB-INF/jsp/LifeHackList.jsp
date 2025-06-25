<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--玉川追加--><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/img/MamoSona.png">
<title>MamoとSona | ライフハックリスト</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lifehacklist.css">
</head>
<body>
<div class="wrapper">
<header>
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
		<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>
	
<div class="stripe-container"></div>
	
<h2>ライフハック</h2>
<div class="button">
<a href="${pageContext.request.contextPath}/LifeHackRequest" class="request-button">ライフハックを申請</a>
<a href="${pageContext.request.contextPath}/LifeHackFavoriteServlet" class="favorite-button">お気に入りライフハック</a>
</div>

<div class="search-box">
 <form action="${pageContext.request.contextPath}/LifeHackListServlet" method="get" class="search-form">
 <input type="text" name="keyword" class="search-input" placeholder="キーワードを入力" >
 <button type="submit" class="search-button">
 <img src="img/search.png" alt="検索" class="search-icon">
 </button> 
 </form>
</div>

<c:if test="${not empty noResultMessage}">
  <p class="no-result">${noResultMessage}</p>
</c:if>



<div class="lifehack-article">
 
 <c:forEach var="e" items="${lifeList}" > 
 
 <!--玉川追加-->
<%-- activeClassを初期化 --%>
<c:set var="activeClass" value="" />

<%-- ♡ついてる記事だけactiveにする --%>
<c:if test="${fn:contains(favoriteNumbers, e.lifehackNumber)}">
  <c:set var="activeClass" value="active" />
</c:if>
 <!--玉川追加-->
<div class="article-1">
  <div class="title-1">${e.title}</div>
  <img src="${e.photo}" alt="水ろ過" class="picture-1">
  <p class="text-1">${e.textline}</p><br>
  
  <form action="${pageContext.request.contextPath}/LifeHackListServlet" method="post">
    <input type="hidden" name="lifehackNumber" value="${e.lifehackNumber}"/>
    <button type="submit" class="favorite-mark ${activeClass} " >♥</button>
  </form> 
</div>

 </c:forEach>
 </div>    	
</div>

<footer>
  <h3 class="footertitle">&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>
</body>
</html>