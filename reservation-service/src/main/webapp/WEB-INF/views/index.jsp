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
			name : <input type="text" name="name"><br>
			<input type="submit" value="확인">
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
						<form method="post" action="/category/modify">
							 <input type="hidden" name="id" value="${categoryVO.id}" >
							 수정 : <input type="text" name="name"><br>
							<button value="수정" class="modify"> </button>
						</form>
					</td>
					<td>
						<button value="삭제" class="destory"> </button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<!-- 	<div id = 'modifyReply'>
		<div class = 'modify-title'>
			<div>
				<input type='text' id='replytext'>
			</div>				
			<div>
				<button type="button" id="modifyBtn"> MODIFY </button>
				<button type="button" id="cancleBtn"> CANCLE </button>
			</div>
		</div>
	</div> -->
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"> </script>
</body>
</html>

<script>

function remove_category_view(view, id) {
	view.remove();
}

function remove_category(view, id, callback) { 
	$.ajax({
		type:'delete',
		url:'/categories/' + id,
		dataType:'text', 
		success:function() {
			callback(view, id);
		}
	});
}

 $(document).on("click", ".destory", function(event){
	var view = $(event.target).closest('.category');
	var id = view.attr('id');
	remove_category(view, id, remove_category_view);
});
 </script>