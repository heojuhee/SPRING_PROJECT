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
	<h2>게시글 목록</h2>
	<table border="1" width="600px">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
				<td>${row.bno}</td>
				<td><a href= "${path}/project/board/view?bno=${row.bno}">${row.title}</a>
				<td>${row.writer}</td>
				<td><fmt:formatDate value="${row.regdate}" pattern = "yyyy-mm-dd"/></td>
				<td>${row.viewcnt}</td>
			</tr>
		</c:forEach>
	</table>
	<form>
		<input type="button" value="글쓰기 " id="btnWriter">
	</form>
</body>
</html>