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

<header >
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
		<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>

<div class="stripe-container"></div>

<section>
	<div class="grid-container">
		<div class="grid-item">
			<input type=text name="name" value="${e.name}">
			<input type=text name="name" value="${e.name}">
		</div>
		<div class="grid-item">
			<input type=text name="name" value="${e.name}">
			<input type=text name="name" value="${e.name}">
		</div>
		<div class="grid-item">
			<input type=text name="name" value="${e.name}">
			<input type=text name="name" value="${e.name}">
		</div>
		<div class="grid-item">
			<input type=text name="name" value="${e.name}">
			<input type=text name="name" value="${e.name}">
		</div>
	</div>
</section>

<section>
	<div class="alert-container">
		<div>
			<p>現在は</p>
			<img src="${pageContext.request.contextPath}/img/Japan.png">
			
		</div>
		<div>
			<blockquote class="twitter-tweet"><p lang="ja" dir="ltr">【16日頃から熱中症に注意】太平洋高気圧の張り出しが強まり、全国的に暖かい空気に覆われる見込みです。16日頃から真夏日が続き、梅雨の晴れ間で今年一番の暑さや猛暑日となる所もあるでしょう。急に真夏の暑さとなるため熱中症や健康管理に十分注意してください。<a href="https://t.co/Rm1kbViXwy">https://t.co/Rm1kbViXwy</a> <a href="https://t.co/mnURygzTXJ">pic.twitter.com/mnURygzTXJ</a></p>&mdash; 気象庁防災情報 (@JMA_bousai) <a href="https://twitter.com/JMA_bousai/status/1933053109670195615?ref_src=twsrc%5Etfw">June 12, 2025</a></blockquote> 
			<script  src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
		</div>
	</div>

</section>

<section class="function-container">
	<h4>機能一覧</h4>
	<div class="function-menu">		
		<a href="${pageContext.request.contextPath}/CheckBagServlet"><img src="${pageContext.request.contextPath}/img/stockbag.png"></a>	
		<a href="${pageContext.request.contextPath}/StockPreFoodRegistServlet"><img src="${pageContext.request.contextPath}/img/prefood.png"></a>
		<a href="${pageContext.request.contextPath}/LifeHackListServlet"><img src="${pageContext.request.contextPath}/img/lifehack.png"></a>
		<a href="${pageContext.request.contextPath}/SearchMapServlet"><img src="${pageContext.request.contextPath}/img/hazardmap.png"></a>
	</div>
</section>


<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>

</body>
</html>