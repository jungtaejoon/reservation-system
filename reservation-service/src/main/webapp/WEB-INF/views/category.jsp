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

카테고리 추가 : <input class="categoryName" type="text" name="name"><br>
<button class="add">확인</button>
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
<script src="/resources/js/category.js?ver1"></script>
</body>
</html>
