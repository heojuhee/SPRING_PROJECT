<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
<script src= "http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까 ?")){
			document.form1.action = "${path}/project/member/delete";
			document.form1.submit();
		}
	});
	
	$("#btnUpdate").click(function(){
		if(confirm("수정하시겠습니까 ?")){
			document.form1.action = "${path}/project/member/update";
			document.form1.submit();
		}
	});
})



</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>

<h2> 회원상세보기</h2>
<hr>
<form name = "form1" method = "post" action = "#">
아이디 : <input type = "text" name = "userId" value = "${dto.userId }" readonly > <br>
비밀번호 : <input type = "password" name = "userPw" value = "" ><br>
이름 : <input type = "text" name="userName" value = "${dto.userName }" ><br>
이메일 : <input type = "text" name = "userEmail" value ="${dto.userEmail }" ><br>

<input type = "button" value = "수정" id = "btnUpdate">
<input type = "button" value = "삭제 " id = "btnDelete">
</form>
<div style = "color : salmon;font-size:34px;">
${message}
</div>
<!-- 테스트 하는 과정 -->
<!-- 1) member/write ==> 입력 => 등록 > 리스트 뜨는지 확인 -->
</body>
</html>