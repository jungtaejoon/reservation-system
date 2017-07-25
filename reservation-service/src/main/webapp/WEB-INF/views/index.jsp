<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>카테고리 목록보기/등록/수정/삭제</title>
</head>
<body>
	<h1>카테고리</h1>
	<hr/>
	<form method="post" action="/category">
		<div>
			<label for="name">카테고리명 : </label>
			<input type="text" id="name" name="name"/>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
	
	<hr/>
	<h3>카테고리목록</h3>
	<table id="ctable">
		<c:forEach items="${list}" var="i">
			<tr>
				<td>
					<input type="hidden" name="id" value="${i.id}"/>
					<input type="text" name="name" value="${i.name}" />
					<input class="removebtn" type="button" value="삭제" />
					<input class="modifybtn" type="button" value="수정" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script src="/resources/js/node_modules/jquery/dist/jquery.min.js"></script>
<script src="resources/js/app.js"></script>
</html>