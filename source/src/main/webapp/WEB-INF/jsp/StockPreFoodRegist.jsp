<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<div class="bag-title">
	<h1 style=" margin-left: 30px;">保存食管理</h1>
	<button  id="add-prefood">追加</button>
</div>

<div id="space-prefood" class="grid-container">
</div>
    
<template id="template-prefood">
			<div class="grid-item">
				<div class="first-item">
					<input type="checkbox">
					<input type=text name="bagname" value="${e.name}">
					<button type="button" style="width:50px; height:30px; font-size:15px; color:#026bb8; background-color:#ffffff;">削除</button>
				</div>
				<div class="second-item">
					<img src="${pageContext.request.contextPath}/img/number.png">
					<select >
					<option>1 個</option>
					<option>2 個</option>
					<option>3 個</option>
					<option>4 個</option>
					<option>6 個</option>
					<option>7 個</option>
					<option>8 個</option>
					<option>9 個</option>
					<option>10 個</option>
					<option>11 個</option>
					<option>12 個</option>
					<option>13 個</option>
					<option>14 個</option>
					<option>15 個</option>
					<option>16 個</option>
					<option>17 個</option>
					<option>18 個</option>
					<option>19 個</option>
					<option>20 個</option>
					</select>
				</div>
				<div class="third-item">
					<img src="${pageContext.request.contextPath}/img/calender.png">
					<input type="date" name="term"></input>
				</div>
				<div class="fourth-item">
					<button type="button" style="width:50px; height:30px; font-size:15px; color:#f58077; background-color:#ffffff;margin-top:10px;">更新</button>
				</div>
		</div>
</template>

<script>
document.getElementById("add-prefood").addEventListener("click", function() {
  let template = document.getElementById("template-prefood");
  let clone = template.content.cloneNode(true);
  document.getElementById("space-prefood").appendChild(clone);
});
</script>
</body>
</html>