<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/homemap.css">
<link rel="icon" href="${pageContext.request.contextPath}/img/MamoSona.png">
<title>MamoとSona | ホーム画面</title>
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
  <h3>安否確認</h3>
  <div class="grid-container">
    <c:forEach var="s" items="${safestampList}">
      <div class="grid-item" id="check-box">

        <input type="text" name="name" value="${s.name}" readonly>

        <c:choose>
          <c:when test="${s.userNumber eq userNumber}">
            <form action="home" method="post">
              <select class="status-select" name="status">
                <option value="OK" ${s.status == 'OK' ? 'selected' : ''}>😊無事</option>
                <option value="SOS" ${s.status == 'SOS' ? 'selected' : ''}>🚨SOS</option>
                <option value="WAIT" ${s.status == 'WAIT' ? 'selected' : ''}>🪫電池切れ</option>
              </select>
              <div style="text-align: center; margin-top: 30px;">
                <button type="submit">✅ 更新する</button>
              </div>
            </form>
          </c:when>

          <c:otherwise>
            <select class="status-select" disabled>
              <option value="OK" ${s.status == 'OK' ? 'selected' : ''}>😊無事</option>
              <option value="SOS" ${s.status == 'SOS' ? 'selected' : ''}>🚨SOS</option>
              <option value="WAIT" ${s.status == '' ? 'selected' : ''}>🪫電池切れ</option>
            </select>
          </c:otherwise>
        </c:choose>

      </div>
    </c:forEach>
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

	<script>
  document.addEventListener("DOMContentLoaded", () => {
    const selects = document.querySelectorAll(".status-select");

    selects.forEach((select) => {
      const wrapper = select.closest(".grid-item");

      // ✅ 初期状態の背景色を設定
      if (select.value === "SOS") {
        wrapper.style.backgroundColor = "#e37168";
      } else {
        wrapper.style.backgroundColor = "#fdc435";
      }

      // ✅ 変更時にも対応
      select.addEventListener("change", function () {
        if (select.value === "SOS") {
          wrapper.style.backgroundColor = "#e37168";
        } else {
          wrapper.style.backgroundColor = "#fdc435";
        }
      });
    });
  });
</script>




</body>
</html>