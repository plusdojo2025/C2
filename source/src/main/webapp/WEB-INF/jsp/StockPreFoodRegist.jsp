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

<div class="grid-container">
		<div class="grid-item">
			<div class="first-item">
				<input type="checkbox">
				<input type=text name="bagname" value="${e.name}">
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
				<img src="${pageContext.request.contextPath}/img/Link.png">
				<textarea  name="link"></textarea>
			</div>
	</div>
</div>
</body>
</html>