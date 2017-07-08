<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<form action="/api/insert" method="post">
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
						<button class="update">수정</button>
						<button class="delete">삭제</button>
					</li>
				</c:forEach>
			</ul>
		</div>
	</section>

	<script>
	(function(){
		'use strict';
		
		var xhr = new XMLHttpRequest();
		
		var $categorylist = document.querySelector("section ul");
		var $deleteBtn = document.querySelector("section > ul .delete");
		$categorylist.addEventListener("click", controlCategory);
		
		// 수정 버튼이면 updateCategory, 삭제 버튼이면 deleteCategory
		function controlCategory(evt) {
			if (evt.target && evt.target.matches("button.delete")) {
				deleteCategory(evt.target);
			}
			
			if (evt.target && evt.target.matches("button.update")) {
				updateCategory(evt.target);
			}
		}
		
		// 카테고리 수정
		function updateCategory(el) {
			var $listNode = el.parentNode;	// <li>
			var $input = $listNode.querySelector("input"); 	// <input>
 			var categoryId = $listNode.getAttribute("data-id");
			xhr.open('POST', '/api/update', true);
			var postdata = "id="+categoryId
				+"&name="+$input.value;
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.onreadystatechange = function(res) {
				if (xhr.readyState == 4) {
					if (xhr.status == 200)
						// 요청 성공하면 데이터도 갱신한다.
						$parentNode.setAttribute("data-name",$input.value);
					else
						console.log("failed");
				}
			};
			xhr.send(postdata);
		}
		
		// 카테고리 하나 삭제
		function deleteCategory(el) {
			var $listNode = el.parentNode;
			var categoryId = $listNode.getAttribute("data-id");
			xhr.open('POST', '/api/delete', true);
			var postdata = "id="+categoryId;
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.onreadystatechange = function(aEvt) {
				if (xhr.readyState == 4) {
					if (xhr.status == 200)
						// 삭제 성공하면 list를 지운다.
						$listNode.remove();
					else
						console.log("failed");
				}
			};
			xhr.send(postdata);
		}
		
		// 편집하기 버튼에 readonly 설정/해제
		var $btnEdit = document.querySelector("h2.categorylist > button.edit");
		$btnEdit.addEventListener("click", letEditable);
		
 		function letEditable(evt){
			var inputs = $categorylist.querySelectorAll(".categoryName");
			inputs.forEach(switchReadOnly);
		}
			
		function switchReadOnly(element, index, array){
			if(element.readOnly){
				element.readOnly = false;
			} else {
				element.readOnly = true;
			}
		}
	})();
	</script>
</body>
</html>