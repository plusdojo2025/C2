<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/img/MamoSona.png">
<title>MamoとSona | 保存食管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bagfood.css">
</head>
<body>
<header>
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
			<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>

<div class="stripe-container"></div>

<div class="bag-title">
	<h1 style=" margin-left: 30px;">保存食管理</h1>
	<button  id="add-prefood">追加</button>
</div>

<p style="margin-left:60px;">＊保存食は１つずつ更新してください。</p>

<!-- エラーメッセージの表示 -->
<c:if test="${not empty error}">
  <p style="color: red; 
            font-weight: bold; 
            text-align: center; 
            margin: 20px 0;">
    ${error}
  </p>
</c:if>


<div id="space-prefood" class="grid-container">
 <c:forEach var="item" items="${prefoodList}">
  <form action="${pageContext.request.contextPath}/StockPreFoodRegistServlet" method="post">
   <input type="hidden" name="prefoodNumber" value="${item.prefoodNumber}" />
   <input type="hidden" name="userNumber" value="${sessionScope.userNumber}">
    <div class="grid-item">
      <div class="first-item">
        <input type="checkbox" name="checked" value="true" <c:if test="${item.checked}">checked</c:if>>
        <input type="text" name="prefoodName" value="${item.prefoodName}" required>
        <button type="submit" class="delete-row" name="action" value="delete" style="width:50px; height:30px; font-size:15px; color:#026bb8; background-color:#ffffff;">削除</button>
      </div>
      <div class="second-item">
        <img src="${pageContext.request.contextPath}/img/number.png">
        <select name="prefoodQuantity">
        	<c:forEach var="i" begin="1" end="20">
    		<option value="${i}" <c:if test="${i == item.prefoodQuantity}">selected</c:if>>${i} 個</option>
  			</c:forEach>
        </select>
      </div>
      <div class="third-item">
        <img src="${pageContext.request.contextPath}/img/calender.png">
        <input type="date" name="prefoodDate" value="${item.prefoodDate}">
      </div>
      <div class="fourth-item">
        <button type="submit" name="action" value="update" style="width:50px; height:30px; font-size:15px; color:#f58077; background-color:#ffffff;margin-top:10px;">更新</button>
      </div>
    </div>
   </form>
  </c:forEach>
</div>
    
<template id="template-prefood">
	 <form action="${pageContext.request.contextPath}/StockPreFoodRegistServlet" method="post">
	 	<input type="hidden" name="userNumber" value="${sessionScope.userNumber}">
	 	<input type="hidden" name="prefoodNumber" value="0"/>
			<div class="grid-item">
				<div class="first-item">
					<input type="checkbox" name="checked" value="true">
					<input type=text name="prefoodName" value="" required>
					<button type="submit" class="delete-row" name="action" value="delete" style="display:none; width:50px; height:30px; font-size:15px; color:#026bb8; background-color:#ffffff;">削除</button>
				</div>
				<div class="second-item">
					<img src="${pageContext.request.contextPath}/img/number.png">
					<select name="prefoodQuantity" required>
  						<c:forEach var="i" begin="1" end="20">
    					<option value="${i}">${i} 個</option>
  						</c:forEach>
					</select>
				</div>
				<div class="third-item">
					<img src="${pageContext.request.contextPath}/img/calender.png">
					<input type="date" name="prefoodDate" required></input>
				</div>
				<div class="fourth-item">
					<button type="submit" name="action" value="insert" style="width:50px; height:30px; font-size:15px; color:#f58077; background-color:#ffffff;margin-top:10px;">登録</button>
				</div>
		</div>
	</form>
</template>
<footer>
	<h3>&copy; 2025 WAKUSEI OMOIDE</h3>
</footer>

<script>
document.getElementById("add-prefood").addEventListener("click", function() {
  let template = document.getElementById("template-prefood");
  let clone = template.content.cloneNode(true);
  document.getElementById("space-prefood").appendChild(clone);
});

//動的に追加された削除ボタンにも対応
document.getElementById("space-prefood").addEventListener("click", function(e) {
  if (e.target.classList.contains("delete-row")) {
    const confirmed = confirm("この保存食を本当に削除しますか？");
    if (!confirmed) {
      e.preventDefault(); // キャンセル時、submitを止める
    }
  }
});
</script>

</body>
</html>