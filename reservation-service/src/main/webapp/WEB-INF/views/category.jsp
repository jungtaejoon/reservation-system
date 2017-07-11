<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>
</head>
<body>
<form method="post" action="/add">
	카테고리 추가 : <input type="text" name="name"><br>
	<input type="submit" value="확인">
</form>
<ul>
	<c:forEach items="${categoryList}" var="category">
   		<li class="category" id="${category.id}">
            	<input class="categoryName" type="text" name="name" value="${category.name}">
            	<button class="update">수정</button>
            	<button class="delete">삭제</button>
        </li>
    </c:forEach>
</ul>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).on("click", ".delete", function(event){
	var selectedCategory = $(event.target).closest('.category');
	var categoryId = selectedCategory.attr('id');
	deleteCategoryRequest(categoryId);
});
$(document).on("click", ".update", function(event){
	var selectedCategory = $(event.target).closest('.category');
	var categoryId = selectedCategory.attr('id');
	var categoryName = $(event.target).siblings('.categoryName').val();
	updateCategoryRequest(categoryId, categoryName);
})

function deleteCategoryRequest(categoryId){
	$.ajax({
		url:'/api/delete/'+categoryId,
		method:"delete",
		processData:true,
		contentType : "application/json; charset=UTF-8",
		success: deleteList(categoryId)
	})
}

function updateCategoryRequest(categoryId, categoryName){
	$.ajax({
		url:'/api/update/'+categoryId,
		method:"post",
		processData:true,
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify({
			name:categoryName
		}),
		success: updateList(categoryId, categoryName)
	})
}

function deleteList(categoryId){
	$('.category#'+categoryId).remove();	
}

function updateList(categoryId, categoryName){
	$('.category#'+categoryId+'>input').val(categoryName);
}
</script>
</body>
</html>