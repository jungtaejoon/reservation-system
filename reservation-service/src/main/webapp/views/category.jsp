<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/app.css">
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
					ID
				</td>
				<td>
					${list.id}
				</td>
				<td>
					Name
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
<script src="resources/js/category.js"></script>
</body>
</html>