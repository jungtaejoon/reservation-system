<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table id="category-list">
			<tr><th>카테고리명</th><th>삭제</th></tr>
	  	    <c-rt:forEach var="category" items="${categories}">
		        <TR>
		          <TD><c:out value="${category.name}" /></TD>
		          <TD><button data-categoryid="${category.id}" class="cat-del-btn">삭제</button></TD>
		        </TR>
		    </c-rt:forEach>

		</table>
	
	</div>
	<br>
	<div>
		<form id="category-form" action="/categories" method="post">
			카테고리 이름 : <input type="text" name="name" id="name">
			<button type="submit">저장</button>
		</form>
	</div>
<script type="text/javascript" src="resources/js/plugin/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/plugin/handlebars-v4.0.10.js"></script>
<script id="category_tr_template" type="text/x-handlebars-template">
	<tr>
		<td>{{name}}</td>
		<td><button data-categoryid="{{id}}" class="cat-del-btn">삭제</button></td>
	</tr>
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#category-form').submit(function(event) { 
			event.preventDefault();
			var source = $('#category_tr_template').html();
			var template = Handlebars.compile(source);
			var categoryJSON = '{ "name" : "' + $('#name').val() + '" }';
			$.ajax({
			    method : 'post',
			    data : categoryJSON,
			    contentType : 'application/json; charset=utf-8',
			    dataType : 'json',
			    url : '/categories',
			    success : function(response) {
			    	$('#category-list').append(template(response));
			    },
			    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
			    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    	}
			});
			$('#category-form')[0].reset();
		});
		
		$(document).on('click', '.cat-del-btn', function(){
			var id = $(this).data('categoryid');
			var btn = $(this);
			$.ajax({
			    method : 'delete',
			    url : '/categories/' + id,
			    success : function(response) {
			      if(response == 1) {
			    	  btn.parents('tr').remove();
			      }
			    },
			    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
			    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    	}
			})
		});
	});
</script>
</body>
</html>
