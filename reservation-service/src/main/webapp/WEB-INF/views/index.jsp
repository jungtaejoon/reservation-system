<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.delete {
	cursor: pointer;
}

.delete:hover {
	color: white;
}
</style>
</head>
<body>
	Hello First Spring Task
	<br> Category CRUD
	<br>

	<form method="post" action="/category">
		추가할 카테고리 이름 : <input type="text" name="name"><br> <input
			type="submit" value="확인">
	</form>

	<c:if test="${categories != null}">
		<ul class="cate_wrapper">
			<c:forEach items="${categories}" var="cate">
				<li data-id="${cate.id}"><c:out value="${cate.name}" /> <a
					class="delete">Delete</a></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script>
	(function(window) {
		'use strict';

		var Category = {
			init : function() {
				this.bindEvents()
			},
			bindEvents : function() {
				$(".cate_wrapper").on("click", ".delete", this.deleteCategory);
			},
			deleteCategory : function(event) {
				var $cateList = $(event.target).closest("li");
				var id = $cateList.data("id");
				var url = '/category/' + id;
				var result = $.ajax({
					contentType : 'application/json; charset=UTF-8',
					method : 'DELETE',
					url : url,
					dataType : 'json',
				});

				result.done(function(res) {
					if (res)
						$cateList.remove();
				});

				result.fail(function(err) {
					console.log(err);
				});

			},
		};

		Category.init();

	})(window);
</script>
</html>