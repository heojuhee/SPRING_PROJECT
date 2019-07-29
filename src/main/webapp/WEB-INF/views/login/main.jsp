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

<c:if test = "${msg=='성공ㅋ'}">
<h2>${sessionScope.userName }</h2>(${sessionScope.userId})님 환영합니다. </h2>
</c:if>
<br>
<A href = "${path}/project/login/logout">로그아웃</A>
<!-- login/login -> id/password -> 로그인 버튼 클릭 -->
</body>
</html>