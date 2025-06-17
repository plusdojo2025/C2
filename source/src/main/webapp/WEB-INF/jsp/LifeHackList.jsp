<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- 
<div class="search-result">
 <c:choose>
  <c:when test="${not empty article}">
   <c:forEach var="article" item=${article}>
    	<h4>${a}</h4>
    	<img src="${a.a}" alt="画像" width="220">
    	<p>${a}</p>
  -->   	
 <!-- 
    	<form action="LifeHackFavoriteServlet" method="post">
    		<input type="hidden" name="a" value="${a.a}"
    		<button type="submit" class="favorite-mark <c:if test='${a.a}'>active</c:if>">
    		♡
    		</button>
    	</form>
    </div>
    </c:forEach>
  </c:when>
  <c:otherwise>
  	<p>該当なし</p>
  </c:otherwise>
 </c:choose>
 </div>
 -->
<div class="lifehack-article">
	<div class="article-1">
		<div class="title-1">【水】汚い水を綺麗に！</div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-1">

		<p class="text-1">災害時には、清潔な飲み水を確保することが重要です。しかし、すぐに浄水設備を利用できない場合、身近な材料を使った簡易的なろ過方法が役立ちます。以下に、安全な水を手に入れるためのいくつかの方法を紹介します。
- 布を使ったろ過
最も簡単なろ過方法のひとつは、布を使うことです。ガーゼやタオル、キッチンペーパーなどを使い、水をゆっくりと通すことで泥や大きな不純物を除去できます。ただし、この方法だけでは細菌や微生物は除去できないため、煮沸消毒と併用することをおすすめします。
		</p><br>
		<img src="img/favorite_icon.png" class="favorite-mark">
	</div>
	<div class="article-2">
	<div class="title-2">【水】汚い水を綺麗に！</div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-2">
		<p class="text-2">災害時には、清潔な飲み水を確保することが重要です。しかし、すぐに浄水設備を利用できない場合、身近な材料を使った簡易的なろ過方法が役立ちます。以下に、安全な水を手に入れるためのいくつかの方法を紹介します。
- 布を使ったろ過
最も簡単なろ過方法のひとつは、布を使うことです。ガーゼやタオル、キッチンペーパーなどを使い、水をゆっくりと通すことで泥や大きな不純物を除去できます。ただし、この方法だけでは細菌や微生物は除去できないため、煮沸消毒と併用することをおすすめします。
		</p><br>
		<img src="img/favorite_icon.png" class="favorite-mark">
	</div>
	<div class="article-3">
		<div class="title-3">【水】汚い水を綺麗に！</div><br>
		<img src="img/lifehack_1.jpg" alt="水ろ過" class="picture-3">
		<p class="text-3">災害時には、清潔な飲み水を確保することが重要です。しかし、すぐに浄水設備を利用できない場合、身近な材料を使った簡易的なろ過方法が役立ちます。以下に、安全な水を手に入れるためのいくつかの方法を紹介します。
- 布を使ったろ過
最も簡単なろ過方法のひとつは、布を使うことです。ガーゼやタオル、キッチンペーパーなどを使い、水をゆっくりと通すことで泥や大きな不純物を除去できます。ただし、この方法だけでは細菌や微生物は除去できないため、煮沸消毒と併用することをおすすめします。
		</p><br>
	</div>
	
</div>
<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>
</body>
</html>