<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Category</title>
</head>

<body>

	<h1>Categories</h1>

	<div id = 'addCategory'>
			<div>
				<label for="name">NAME : </label>
				<input type="text" class="name"><br>
			</div>
			<div>
				<button value="등록" class="register">REGISTER</button>
			</div>
	</div>

	<div>
		<ul id="categoryList">
		</ul>
	</div>
	<script src="resources/js/category.js"></script>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"> </script>
</body>
</html>

<script>
$(function(){
	/* <li class ='old-name'>${categoryVO.name}</td> */
	/* list 부분 */
	category.get();
	$(document).on("click", ".destory", category.remove);
	$(document).on("click", ".modify", category.modify);
	
	$(document).on("click", ".register", category.register);

});
 </script>