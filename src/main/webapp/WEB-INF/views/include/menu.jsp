<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="path" value = "${pageContex.request.contexPath}" />
<a href = "${path}/project/member/list">회원목록 보기</a>
<a href = "${path}/project/member/write">회원등록하기</a>
<a href = "${path}/project/member/list">게시판</a>
<c:choose>
<c:when test = "${sessionScope.userId==null }">
 <a href = "${path}/project/login/login"> 로그인 </a>
 </c:when>
 <c:otherwise>
 ${sessionScope.userName}님이 로그인 중입니다.
 <a href = "${path}/project/login/loginout" >로그아웃</a>
 </c:otherwise>
</c:choose>
</body>
</html>