<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
<script src ="https://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"></script>
<script>
	//목록보기
	$(function() {
		$("#btnList").click(function(){
			location.href = "${path}/project/board/list";
		});
	//수정하기
	$("#btnUpdate").click(function(){
		var title=$("#click").val();
		var content=$("#content").val();
		var writer=$("#writer").val();
		if(title==""){
			alert("제목입려갛세요.");
				document.form1.title.focus();
			return;
		}
		document.form1.action="${path}/project/board/update?bno=${dto.bno}";
		document.form1.submit();
	});
	//삭제하기
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까")){
		document.form1.action="${path}/project/board/delete?bno=${dto.bno}";
		document.form1.submit();
		}
	});
	})
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<h2>게시글 상세 보기</h2>
<hr>
<form name = "form1" method = "post">
작성날짜 : <fmt:formatDate value = "${dto.regdate}" pattern = "yyyy-MM-dd a HH:mm:ss" />
조회수 : ${dto.viewcnt} <br>
제목 : <input type = "text" name = "title" id = "title" size = "80" value = "${dto.title}" ><br>
내용 : <textarea name = "context" id = "context" rows="5" cols = "100">${dto.context}</textarea><br>
작성자 : <input type = "text" name = "writer" id = "writer" size = "80" value = "${dto.writer }" ><br>
<input type = "button" value = "수정" id = "btnUpdate" >
<input type = "button" value = "삭제" id = "btnDelete" >
<input type = "button" value = "목록보기" id = "btnList"> 



</form>

</body>
</html>