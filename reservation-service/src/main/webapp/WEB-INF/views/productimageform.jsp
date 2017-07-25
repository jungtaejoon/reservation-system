<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>

<html>
<head>
    <title>이미지 등록</title>
</head>
<body>
	<div id="container" data-product-id="${productId }">
		<h1>상품ID : ${productId }</h1>
		<table id="product_image_list">
			<tr><th>이미지 타입</th><th>이미지 ID</th><th>삭제</th></tr>
	  	    <c-rt:forEach var="image" items="${images}">
		        <TR>
		          <TD><c:out value="${image.type}" /></TD>
		          <TD><c:out value="${image.id}" /></TD>
		          <TD><button data-image-id="${image.id}" class="img_del_btn">삭제</button></TD>
		        </TR>
		    </c-rt:forEach>
		</table>
	</div>
	<div>
		<form id="image_input" method="post" enctype="multipart/form-data">
			메인 이미지 :    <input type="file" name="mainImage"><br>
			서브 이미지 :    <input type="file" name="subImages"><br>
			서브 이미지 :    <input type="file" name="subImages"><br>
		    <button type="submit">등록</button><button id="sub_img_form_add">서브 이미지 추가</button>
		</form>
	</div>
    <script type="text/javascript" src="/node_modules/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="/node_modules/handlebars/dist/handlebars.min.js"></script>
	<script id="product_img_tr_template" type="text/x-handlebars-template">
		{{#images}}
		<tr>
			<TD>{{type}}</TD>
		    <TD>{{id}}</TD>
		    <TD><button data-image-id="{{id}}" class="img-del-btn">삭제</button></TD>
		</tr>
		{{/images}}
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#image_input').submit(function(event) { 
				event.preventDefault();
				var productId = $('#container').data('product-id');
				var source = $('#product_img_tr_template').html();
				var template = Handlebars.compile(source);
				var form = $('#image_input')[0];
				var formData = new FormData(form);
			    $.ajax({
					url: '/products/' + productId + '/images',
					processData: false,
					contentType: false,
					data: formData,
					method: 'post',
					success: function(response){
						console.log(response);
					    alert("업로드 성공!!");
					},
				    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
				    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    	}
			    });
				$('#image_input')[0].reset();
			});
		});
	</script>
</body>
</html>