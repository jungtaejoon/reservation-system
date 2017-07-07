<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
	.category-list{
		margin: 25px auto; 
		width : 600px;
	}
	.input-box{
		margin:auto; 
		width : 600px;
	}
	#modify{
		display: none;
	}
	
	
</style>
</head>
<body>

<div class ="input-box">
	<form action="/" method="post">
		Name : <input type ="text" name = "name" >
		
		<input type="submit" value="전송" id = "submit" >
		<a href ="#" id = "modify" > 수정하기</a>
	</form>
</div>

<div class = "category-list">
	<table>
		<c:forEach items="${list}" var="list">
			<tr data-id = '${list.id}' >
				<td>
					 ${list.id}
				</td>
				<td class = "name">
				 	${list.name}
				</td>
				<td>
					<a class ="update"  href="#" >update</a>
				</td>
				<td>
					<a class ="remove"  href="#" >remove</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

$(function() {

	// remove 클릭시 삭제
	var removefunc = function(){
		var $tr = $(this).parents("tr");
		var id = $tr.data("id"); 
		// data-value
		$.ajax({
			  method: "DELETE",
			  contentType: "application/json; charset=utf-8",
			  url: "/"+id
		}).done(function( msg ) {
		    $tr.remove();
		}); 
	};
	
	// 클릭시 해당 name이 input에 들어가도록
	var updateReady = function(){
		// click 된  tr을 통해 data-id 를 가져오고, name의 값을 input에 넣는다
		var $tr = $(this).parents("tr");
		var id = $tr.data("id"); 
		var text = $tr.find(".name").text().trim();
		$("#modify").css("display","block");
		$("#submit").css("display","none");
		$("input[name=name]").val(text);
		$("input[name=name]").data("id",id);
	
	};
	
	
	var updateSend = function(){
		var name = $("input[name=name]").val();
		var id = $("input[name=name]").data("id");
		var category = new Object();
		category.id = id;
		category.name = name;
		
		$.ajax({
			  method: "PUT",
			  url: "/"+id,
			  contentType: "application/json; charset=utf-8",
	          dataType: "json",
			  data : JSON.stringify(category)
		}).done(function( msg ) {
		    alert("수정되었습니다.");
		    location.reload();
		}); 
	};
	
	$(document).on("click",".remove", removefunc);
	$(document).on("click",".update", updateReady);
	$("#modify").on("click",updateSend);
});
</script>
</body>
</html>