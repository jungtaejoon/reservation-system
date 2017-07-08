<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Category</title>
</head>

<body>

	<h1>Categories</h1>

	<div id = 'addReply'>
		<form method="post" action="/category/create">
			<div>
				<label for="name">NAME : </label>
				<input type="text" name="name"><br>
			</div>
			<div>
				<input type="submit" value="확인">
			</div>
		</form>
	</div>

	<div id = 'listReply'>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>MODIFY</th>
				<th>REMOVE</th>
			</tr>
	
			<c:forEach items="${categories}" var="categoryVO">
				<tr class="category" id="${categoryVO.id}">
					<td>${categoryVO.id}</td>
					<td>${categoryVO.name}</td>
					<td>
						<form action="/category/modify" method="post" >
							<div>
								<input type="hidden" name="id" value="${categoryVO.id}">
							</div>
							<div>
								<input type="text" name="name" placeholder="NEW NAME"><br>
							</div>
							<div class="button">
								<button value="수정" name="newName"class="modify">MODIFY</button>
							</div>
						</form>
					</td>
					<td>
						<div class="button">
							<button value="삭제" class="destory"> REMOVE </button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="resources/js/category.js"></script>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"> </script>
</body>
</html>

<script>
$(function(){
	$(document).on("click", ".destory", function(event){
		var view = $(event.target).closest('.category');
		var id = view.attr('id');
		remove_category(view, id, remove_category_view);
	});
});
 </script>