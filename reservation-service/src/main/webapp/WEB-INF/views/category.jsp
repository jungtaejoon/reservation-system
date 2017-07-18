<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Page</title>
<link href="/resources/css/category.css" rel="stylesheet">
</head>
<body>
<div class="header-nav">
	<h2>카테고리 관리</h2>
</div>
<div class="Category-table-wrap" align="center">
	<form id="addCategory-form" method="post" action="/category/addNewCategory">
		<input type="hidden" id="cateId" name="cateId" value="">
		<input type="text" id="newCategory" name="newCategory">
		<input type="submit" class="btn" id="btnSubmit" value="추가">
		<input type="submit" class="btn" id="btnUpdate" value="수정" formaction="/category/setCategory">
	</form>
	<br>
	<table>
<c:forEach var="cateList" items="${category}">
		<tr>
			<td>${cateList.name}</td>
			<td><input type="button" value="수정" class="btnCate" onclick="updateCategory('${cateList.id}', '${cateList.name}')"></td>
			<td><input type="button" value="삭제" class="btnCate" onclick="deleteCategory(${cateList.id})"></td>
		</tr>
</c:forEach>
	</table>
</div>
<script src="/resources/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="/resources/js/category.js"></script>
</body>
</html>