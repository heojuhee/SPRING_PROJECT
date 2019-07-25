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
<h2> 게시글 작성 </h2>
<hr>
<form name = "form1" method = "post" action = "${path}/project/board/insert">
제목 : <input type = "text" name = "title" id = "title" size = "80" placeholder = "제목입력하세요"> <br>
내용 : <textarea name = "content" id = "content" rows = "5" cols = "100" placeholder = "내용을 입력하세요"></textarea><br>
이름 : <input type = "text" name = "writer" id = "writer" placeholder = "이름입력" ><br>
<input type ="submit" value = "확인">
<input type ="reset" value = "취소">
</form>

</body>
</html>