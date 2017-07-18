<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resources/css/category.css" rel="stylesheet">
</head>
<body>
	<h1>Hello First Spring Task (Category CRUD)</h1>

	<br>

	<h3>Input Category Name</h3>

	<br>

	<form method="post" action="/category">
		<input type="text" name="name"> <input type="submit"
			value="ADD">
	</form>

	<c:if test="${categories != null}">
		<div class="cate_wrapper">
			<h2>Categories</h2>
			<c:forEach items="${categories}" var="cate">
				<div data-id="${cate.id}" class="flex-row">
					<div id="name">
						<c:out value="${cate.name}" />
					</div>
					<input type="text" class="edit" value="" name="edit">
					<button class="update">Update</button>
					<button class="delete">Delete</button>
				</div>
			</c:forEach>
		</div>
	</c:if>
</body>
<script src="/resources/lib/jquery.min.js"></script>
<script src="/resources/js/category.js"></script>
</html>