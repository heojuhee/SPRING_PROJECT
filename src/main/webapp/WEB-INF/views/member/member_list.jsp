<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>회원목록</h2>
	<hr>
	<table border="1" width="700px">
		<tr>
			<th>아이디</th>
			<th>이메일</th>
			<th>가입날짜</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.userId}</td>
				<td><a href = "${path}/project/member/view?userId=${row.userId}">${row.userName}</td>
				<td>${row.userEmail}</td>
				<td>${row.userRegdate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>