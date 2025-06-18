<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ライフハックリスト</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginlifehack.css">
</head>
<body class="lifehacklist">
<header class="header">
	<div class= "logo-header">
	<a href="${pageContext.request.contextPath}/home"><img id="logo-img"src="${pageContext.request.contextPath}/img/logo.png"></a>
	</div>
</header>

<section>
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe.png">
	<img src="${pageContext.request.contextPath}/img/stripe2.png">
	
</section>

<h2>ライフハック</h2>

<div class="button">
<a href="${pageContext.request.contextPath}/LifeHackRequestServlet" class="request-button">ライフハックを申請</a>
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
<%-- <div class="search-result">
 <c:choose>
  <c:when test="${not empty articleList}">
   <c:forEach var="article" items="${articleList}">
   	<div class="article-card">
       <h4>${article.title}</h4>
    	<img src="${article.imagePath}" alt="画像" width="220">
    	<p>${article.description}</p>  	
 
    	<form action="LifeHackFavoriteServlet" method="post">
    		<input type="hidden" name="articleId" value="${article.id}"/>
    		<c:set var="activeClass" value="${article.favorite ? 'active' : ''}" />
    		<button type="submit" class="favorite-mark ${activeClass}">♡</button>
    	</form>
    </div>
    </c:forEach>
  </c:when>
  <c:otherwise>
  	<p>該当なし</p>
  </c:otherwise>
 </c:choose>
 </div> --%>
 
 <!-- lifeListに入っているデータベースを表示
 　　　　　初期表示では、Tbl_lifehacklistに入っている全てのデータがlifeListに入っている
 　　　　　検索結果に応じてlifeListが変化
  -->
 <div class="lifehack-article">
 
 <c:forEach var="e" items="${lifeList}" > 
	 
 
 </c:forEach>
 
 </div>
  
 <!-- デザイン確認用
<div class="lifehack-article">
	<div class="article-1">
		<div class="title-1"></div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-1">

		<p class="text-1">
		</p><br>
		
	</div>
	<div class="article-2">
	<div class="title-2"></div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-2">
		<p class="text-2">
		</p><br>
		
	</div>
	<div class="article-3">
		<div class="title-3"></div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-3">
		<p class="text-3">
		</p><br>
	</div>	
</div> -->
 
<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>
</body>
</html>