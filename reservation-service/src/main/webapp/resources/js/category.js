function deleteList(res, categoryId) {
	$('#' + categoryId).remove();
}

function updateList(categoryId, categoryName) {
	$('#' + categoryId + '>input').val(categoryName);
}

function deleteCategoryRequest(categoryId) {
	$.ajax({
		url : '/api/category/' + categoryId,
		method : "delete",
		processData : true,
		contentType : "application/json; charset=UTF-8",
		success : deleteList.bind(this, categoryId)
	})
}

function updateCategoryRequest(res, categoryId, categoryName) {
	$.ajax({
		url : '/api/category/' + categoryId,
		method : "post",
		processData : true,
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify({
			name : categoryName
		}),
		success : updateList.bind(this, categoryId, categoryName)
	})
}

$(document).on("click", ".delete", function(event) {
	var selectedCategory = $(event.target).closest('.category');
	var categoryId = selectedCategory.attr('id');
	deleteCategoryRequest(categoryId);
});

$(document).on("click", ".update", function(event) {
	var selectedCategory = $(event.target).closest('.category');
	var categoryId = selectedCategory.attr('id');
	var categoryName = $(event.target).siblings('.categoryName').val();
	updateCategoryRequest(categoryId, categoryName);
});
