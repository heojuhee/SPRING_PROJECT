<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>

<h2> 회원등록 폼</h2>
<hr>
<form name = "form1" method = "post" action = "${path}/member/insert">
아이디 : <input type = "text" name = "userId" value = "" > <br>
비밀번호 : <input type = "password" name = "userPw" value = "" ><br>
이름 : <input type = "text" name="userName" value = "" ><br>
이메일 : <input type = "text" name = "userEmail" value ="" ><br>
<input type = "submit" value = "등록" >
<input type = "reset" value = "초기화" >
</form>

<!-- 테스트 하는 과정 -->
<!-- 1) member/write ==> 입력 => 등록 > 리스트 뜨는지 확인 -->
</body>
</html>