<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 관리자 페이지</title>
<link href="/resources/css/style.css" rel="stylesheet">
<style>
	input[readonly] {
		background-color: #f7f5f5;
	}
	
</style>
</head>
<body>
	<header><h1>카테고리 관리자 페이지</h1></header>
	<section>
		<h2>카테고리 등록하기</h2>
		<form action="/api/category" method="POST">
			<input type="text" name="name" />
			<button class="create" type="submit">등록</button>
		</form>
		<div id="cataegory-wrapper">
			<h2 class="categorylist">카테고리 리스트  <button class="edit">편집하기</button></h2>
			<ul class="categorylist">
				<c:forEach var="categories" items="${categories }"
					varStatus="listCount">
					<li data-id=${categories.id } data-name=${categories.name }>
						<input class="categoryName" type="text" name="name" value="${categories.name }" readonly/>
						<button class="update send">수정</button>
						<button class="delete send">삭제</button>
					</li>
				</c:forEach>
			</ul>
		</div>
	</section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
	(function(){
		'use strict';
		
		var $categorylist = $('section ul');
		var $deleteBtn = $('section > ul .delete');
		$categorylist.on('click', 'button.send', controlCategory);
		
		// 수정 버튼이면 updateCategory, 삭제 버튼이면 deleteCategory
		function controlCategory(evt) {
			if (evt.target && evt.target.matches("button.delete")) {
				deleteCategory(evt.target);
			}
			console.log(this);
			
			if (evt.target && evt.target.matches("button.update")) {
				updateCategory(evt.target);
			}
		}
		
		// 카테고리 수정
		function updateCategory(el) {
			var $listNode = el.parentNode;	// <li>
			var $input = $listNode.querySelector("input"); 	// <input>
 			var categoryId = $listNode.getAttribute("data-id");
 			var postdata = "{id:"+categoryId
			+",name:"+$input.value;
			console.log(postdata);
			$.ajax({
				url: '/api/category/' + categoryId,
				type: 'PUT',
				contentType: 'application/json; charset=UTF-8',
				data: JSON.stringify({
					name: $input.value
				})
			}).done(function(){
				$listNode.setAttribute("data-name",$input.value);
			}).fail(function(){
				console.log("failed");
			});
 		}
		
		// 카테고리 하나 삭제
		function deleteCategory(el) {
			var $listNode = el.parentNode;
			var categoryId = $listNode.getAttribute("data-id");
			
			$.ajax({
				url: '/api/category/' + categoryId,
				type: 'DELETE'
			}).done(function(){
				$listNode.remove();
			}).fail(function(){
				console.log("failed");
			})
		}
		
		// 편집하기 버튼에 readonly 설정/해제
		var $btnEdit = $("h2.categorylist > button.edit");
		$btnEdit.on("click", letEditable);
		
 		function letEditable(evt){
			var inputs = $categorylist.find(".categoryName");
			inputs.each(switchReadOnly);
		}
			
		function switchReadOnly(index){
			if(this.readOnly){
				this.readOnly = false;
			} else {
				this.readOnly = true;
			}
		}
	})();
	</script>
</body>
</html>