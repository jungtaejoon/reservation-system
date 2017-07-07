<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <script type="text/javascript" src="//code.jquery.com/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table id="category-list">
			<tr><th>카테고리명</th><th>삭제</th></tr>		
		</table>
	
	</div>
	<div>
		<form id="category-form" action="/categories" method="post">
			카테고리 이름 : <input type="text" name="name" id="name"><br>
			<button type="submit">저장</button>
		</form>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$('#category-form').submit(function() { 
			event.preventDefault()
			var category = new Object();
			category.name = $('#name').val();
			console.log(category);
			jsonStr = JSON.stringify(category);
			$.ajax({
			    method : 'post',
			    data : jsonStr,
			    contentType : 'application/json; charset=utf-8',
			    dataType : 'json',
			    url : '/categories',
			    success : function(response) {
			      console.log(response);
			    },
			    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
			    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    	},
			})
		});

		

	});


</script>
</body>
</html>
