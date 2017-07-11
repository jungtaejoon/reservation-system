<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, kr.or.connect.reservation.domain.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약</title>
<link rel="stylesheet" href="resources/css/index.css">
</head>
<body>
	<label>카테고리</label>
	<table>
		
		<tr>
			<td class="category_td">전체</td>
		
<%
		
			List<Category> categories = (List<Category>) request.getAttribute("categories");
	
			for(Category category : categories) {
%>
			<td class="category_td">
				<%=category.getName() %>
			</td>

<%
		}
		
%>
		</tr>
	</table>
	
	<button type="button" id="goToAdmin" onclick="location.href='/admin'">관리자 페이지로</button>

</body>
</html>