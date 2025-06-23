<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ライフハックリスト</title>
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

<div class="lifehack-article">
 
 <c:forEach var="e" items="${lifeList}" > 
	
	<div class="article-1">
	 
	<div class="title-1">${e.title}</div>
	<form action="${pageContext.request.contextPath}/LifeHackListServlet" method="post">
    		<input type="hidden" name="lifehackNumber" value="${e.lifehackNumber}"/>
    		<c:set var="activeClass" value="${article.favorite ? 'active' : ''}" />
    		<button type="submit" class="favorite-mark ${activeClass}">♡</button>
    </form>
	<img src="${e.photo}" alt="水ろ過" class="picture-1">
	<p class="text-1"> ${e.textline}</p><br>
	</div>
 
 </c:forEach>
 </div>    	


<%-- <div class="lifehack-article">
	<div class="article-1">
		<div class="title-1">「午後の窓辺、雨音とコーヒーと」</div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-1">

		<p class="text-1">
		静かな午後、窓の外に広がるグレーの空を見上げながら、私はゆっくりとコーヒーを口に運んだ。
		雨粒がガラスにリズムを刻むたび、心のざわめきが少しずつほどけていく。
		やらなきゃいけないことは山ほどあるけれど、今だけは、時間の流れからそっと抜け出したかった。
		</p><br>
	</div>
	
	<div class="article-2">
		<div class="title-2">「午後の窓辺、雨音とコーヒーと」</div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-2">

		<p class="text-2">
		静かな午後、窓の外に広がるグレーの空を見上げながら、私はゆっくりとコーヒーを口に運んだ。
		雨粒がガラスにリズムを刻むたび、心のざわめきが少しずつほどけていく。
		やらなきゃいけないことは山ほどあるけれど、今だけは、時間の流れからそっと抜け出したかった。
		</p><br>
	</div>
	
	<div class="article-3">
		<div class="title-3">「午後の窓辺、雨音とコーヒーと」</div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-3">

		<p class="text-3">
		静かな午後、窓の外に広がるグレーの空を見上げながら、私はゆっくりとコーヒーを口に運んだ。
		雨粒がガラスにリズムを刻むたび、心のざわめきが少しずつほどけていく。
		やらなきゃいけないことは山ほどあるけれど、今だけは、時間の流れからそっと抜け出したかった。
		</p><br>
	</div>
</div> --%>

</div>
<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>
</body>
</html>