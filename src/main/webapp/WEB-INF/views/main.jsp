<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
메인 페이지 입니다.

${msg}
<br>
<a href="${path}/project/member/write">회원가입 </a><br>
<a href="${path}/project/login/login">로그인 </a><br>
<a href="${path}/project/board/list ">게시판 </a><br>
</body>
</html>