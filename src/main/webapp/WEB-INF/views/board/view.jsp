<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	//목록보기
	$(function() {
		$("#btnList").click(function() {
			location.href = "${path}/project/board/list?curPage=${curPage}&searchOption=${searchOption}&keyword=${keyword}";
		});
		
		//수정하기
		$("#btnUpdate").click(function() {
			var title = $("#click").val();
			var content = $("#content").val();
			var writer = $("#writer").val();
			if (title == "") {
				alert("제목입려갛세요.");
				document.form1.title.focus();
				return;
			}
			document.form1.action = "${path}/project/board/update?bno=${dto.bno}";
			document.form1.submit();
		});
		
		//삭제하기
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까")) {
				document.form1.action = "${path}/project/board/delete?bno=${dto.bno}";
				document.form1.submit();
			}
		});
		
		//함수 호출 둘중에 하나만 listReply(), listReply2()
		listReply2(); 
		//listReply2() 변경
		
		$("#btnReply").click(function() {
			var replytext = $("#replytext").val();
			var bno = "${dto.bno}";
			var param = "replytext=" + replytext + "&bno=" + bno;
			
			$.ajax({
				type: "post",
				url: "${path}/project/reply/insert", //경로맞추기(project)
				data: param,
				success: function(){
					alert("댓글 등록되었음");
					listReply2(); //listReply2() 중에 하나
				}
			});
		});
	});
	
	/* //Controller 이용할 경우 호출하는 함수 ==> replyList.jsp 뷰가 필요
	function listReply(){
		$.ajax({
			type : "get",
			url : "${path}/project/reply/list?bno=${dto.bno}",
			success : function (result){
				$("#listReply").html(result);
			}
		});
	}
	*/
	
	//RestController 이용할 경우 호출하는 함수 -> 결과파일을 Json으로 작성
	function listReply2(){
		$.ajax({
			type: "get",
			url: "${path}/project/reply/listjson?bno=${dto.bno}",
			success : function(result) {
				console.log(result);
				var output = "<table>";
				for(var i in result){
					output += "<tr>";
					output += "<td>" + result[i].userName;
					output += "(" + changeDate(result[i].regdate)+")<br>";
					output += result[i].replytext + "</td>";
					output += "</tr>";
				}
				output += "</table>";
				$("#listReply").html(output);	
			}
		});
	}
		
	//날짜 형식 표현 함수
	function changeDate(date) {
		var date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth() +1;
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		var strDate =  year +"-" + month + "-" + day + " " + hour +":" + minute +  ":" + second;
		return strDate;
	}

</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>게시글 상세 보기</h2>
	<hr>
	<form name="form1" method="post">
		작성날짜 :
		<fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd a HH:mm:ss" />
		조회수 : ${dto.viewcnt} <br> 제목 : <input type="text" name="title"
			id="title" size="80" value="${dto.title}"><br> 내용 :
		<textarea name="context" id="context" rows="5" cols="100">${dto.context}</textarea>
		<br> 작성자 : <input type="text" name="writer" id="writer" size="80"
			value="${dto.writer }"><br>
		<c:if test="${sessionScope.userId==dto.writer}">
			<input type="button" value="수정" id="btnUpdate">
			<input type="button" value="삭제" id="btnDelete">
		</c:if>
		<input type="button" value="목록보기" id="btnList">
	</form>
	<!-- 댓글 작성0.0000. -->
	<div>
		<c:if test="${sessionScope.userId != null }">
			<textarea name="replytext" id="replytext" rows="5" cols="80"
				placeholder="댓글 작성해주세요"></textarea>
			<br>
			<button type="button" id="btnReply">댓글작성</button>
		</c:if>
	</div>
	<!-- 댓글 출력  -->
	<div id="listReply"></div>
</body>
</html>
