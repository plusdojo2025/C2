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
                <option value="NO_POWER" ${s.status == 'NO_POWER' ? 'selected' : ''}>🪫電池切れ</option>
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
              <option value="NO_POWER" ${s.status == 'NO_POWER' ? 'selected' : ''}>🪫電池切れ</option>
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
			<img src="${pageContext.request.contextPath}/img/mapwether.png" style="max-width: 500px; margin-top:100px;">
			
		</div>
		<div>
			<blockquote class="twitter-tweet">
			<p lang="ja" dir="ltr">【16日頃から熱中症に注意】太平洋高気圧の張り出しが強まり、全国的に暖かい空気に覆われる見込みです。16日頃から真夏日が続き、梅雨の晴れ間で今年一番の暑さや猛暑日となる所もあるでしょう。急に真夏の暑さとなるため熱中症や健康管理に十分注意してください。
			<a href="https://t.co/Rm1kbViXwy">https://t.co/Rm1kbViXwy</a> 
			<a href="https://t.co/mnURygzTXJ">pic.twitter.com/mnURygzTXJ</a></p>&mdash; 気象庁防災情報 (@JMA_bousai) 
			<a href="https://twitter.com/JMA_bousai/status/1933053109670195615?ref_src=twsrc%5Etfw">June 12, 2025</a></blockquote> 
			<p>出典：気象庁防災情報（@JMA_bousai）／X（旧Twitter）</p>
			<script  src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
		</div>
	</div>

</section>
<h3>機能一覧</h3>
<section class="function-container">
	<div class="function-menu">		
		<a href="${pageContext.request.contextPath}/CheckBagServlet"><img src="${pageContext.request.contextPath}/img/stockbag.png"></a>	
		<a href="${pageContext.request.contextPath}/StockPreFoodRegistServlet"><img src="${pageContext.request.contextPath}/img/prefood.png"></a>
		<a href="${pageContext.request.contextPath}/LifeHackListServlet"><img src="${pageContext.request.contextPath}/img/lifehack.png"></a>
		<a href="${pageContext.request.contextPath}/SearchMapServlet"><img src="${pageContext.request.contextPath}/img/hazardmap.png"></a>
	</div>
</section>

    
<h3>過去の災害情報</h3>
        <div class="new">
            <table class="news-table">
            <tr>
                <th class="news-date">2024年01月01日</th>
                <td class="news-content"><a href=https://www.data.jma.go.jp/kanazawa/shosai/notojishinportal.html>🌍「能登半島地震：元日に震度7、津波と孤立集落が深刻化」</a></td>
            </tr>

            <tr>
                <th class="news-date">2020年07月04日~08日</th>
                <td class="news-content"><a href=https://www.data.jma.go.jp/stats/data/bosai/report/2020/20200811/20200811.html>🌧「7月豪雨：球磨川氾濫、熊本を中心に甚大な浸水」</a></td>
            </tr>
            <tr>
                <th class="news-date">2016年04月14日・16日</th>
                <td class="news-content"><a href=https://www.data.jma.go.jp/eqev/data/2016_04_14_kumamoto/index.html>🏚「熊本地震：震度7が2度襲う、断層型地震の連続被害」</a></td>
            </tr>
            <tr>
                <th class="news-date">2011年03月11日</th>
                <td class="news-content"><a href=https://www.data.jma.go.jp/eqev/data/2011_03_11_tohoku/index.html>🌊「東日本大震災：未曾有の地震と津波、原発事故も発生」</a></td>
            </tr>
            <tr>
                <th class="news-date">2004年10月23日</th>
                <td class="news-content"><a href=https://www.data.jma.go.jp/niigata/menu/2024project/chuetsu_main.html>🌀「新潟県中越地震：震度7の直下型地震が山間部を襲う」</a></td>
            </tr>
 
            </table>
        </div> 
    
<footer>
  <h3 class="footertitle">&copy; 2025 WAKUSEI OMOIDE</h3>
  <form action="/C2/LogoutServlet" method="get" class="logoutform" id="logout">
  <!-- ★class追加 前田★ -->
    <button type="submit" class="styled-logout-btn">ログアウト</button>
  </form>
</footer>

<script>
  document.addEventListener("DOMContentLoaded", () => {
    const selects = document.querySelectorAll(".status-select");

    selects.forEach((select) => {
      const wrapper = select.closest(".grid-item");

      if (select.value === "SOS") {
        wrapper.style.backgroundColor = "#e37168";
      } else {
        wrapper.style.backgroundColor = "#fdc435";
      }

      select.addEventListener("change", function () {
        if (select.value === "SOS") {
          wrapper.style.backgroundColor = "#e37168";
        } else {
          wrapper.style.backgroundColor = "#fdc435";
        }
      });
    });
  });
  
  document.getElementById('logout').onsubmit=function(){
	  return window.confirm('ログアウトしてもよろしいですか？');
	};
</script>
</body>
</html>