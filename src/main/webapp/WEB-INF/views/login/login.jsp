<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"></script>
<script>
$(function() {
	$("#btnLogin").click(function(){
		var userId = $("#userId").val();
		var userPw = $("#userPw").val();
		if(userId = ""){
			alert("아이디입력하세요")
			$("#userId").focuse();
			return;
		}
		
		if(userPw = ""){
			alert("비밀번호를 입력하세요")
			$("#userPw").focuse();
			return;
		}
		document.form1.action = "${path}/project/login/loginCheck";
		document.form1.submit();
	});
})



</script>



</head>
<body>
<h3>로그인</h3>
<hr>
<form name = "form1" method = "post">
아이디 : <input type = "text" name = "userId" id = "userId"><br>
비밀번호 : <input type = "password" name = "userPw" id = "userPw"><br>
<input type = "button" value = "로그인" id = "btnLogin">
<input type = "reset" value = "로그인 취소">
</form>
<c:if test = "${msg=='실패ㅋ' }">
<div> 아이디와 비밀번호가 일치하지 않습니다.</div>
</c:if>
<c:if test = "${msg=='logout' }">
<div>로그아웃되었습니다.</div>
</c:if>
</body>
</html>