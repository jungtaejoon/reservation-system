<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, kr.or.connect.reservation.domain.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약 관리자 페이지 입니다</title>
<link rel="stylesheet" href="resources/css/admin.css">

</head>
<body>
	<h4>카테고리 목록 편집</h4>
	<form id="insertForm" action="/admin" method="post">
		<input type="text" name="categoryName">
		<button type="submit" id="insertBtn">등록</button>
	</form>
	
	
	<table>
		
		
<%
			List<Category> categories = (List<Category>) request.getAttribute("categories");
	
			for(Category category : categories) {
%>
			<tr><td class="category_td" data_id="<%=category.getId() %>">
				<label class="category_label"><%=category.getName() %></label> 
				<input class="category_edit invisible" name="edit" type="text" value="<%=category.getName() %>">
				<button class="updateBtn invisible" >완료</button>
				<button class="editBtn">수정</button>	
				<button class="deleteBtn">삭제</button>
			</td></tr>
<%
		}
		
%>
		
	</table>
	<button id="goToMain" onclick="location.href='/'">메인으로</button>
	
<script src="resources/scripts/lib/jquery.min.js"></script>
<script src="resources/scripts/admin.js"></script>

</body>
</html>