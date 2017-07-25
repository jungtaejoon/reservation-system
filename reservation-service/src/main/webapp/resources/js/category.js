var li_template =
	"<li class='category'>"+
		"<input class='categoryName' type='text' name='name'>"+
		"<button class='update'>수정</button>"+
		"<button class='delete'>삭제</button>"+
	"</li>";
var clickEventListener = (function(){
	var selectedCategory;
	var categoryId;
	var categoryName;

	return {
		deleteCategoryRequest : function(event){
			selectedCategory = $(event.target).closest('.category');
			categoryId = selectedCategory.attr('id');

			$.ajax({
				url : '/api/category/' + categoryId,
				method : "delete",
				processData : true,
				contentType : "application/json; charset=UTF-8"
			}).done(function(){
				$('#' + categoryId).remove();
			});
		},
		updateCategoryRequest : function(event){
			selectedCategory = $(event.target).closest('.category');
			categoryId = selectedCategory.attr('id');
			categoryName = $(event.target).siblings('.categoryName').val();

			$.ajax({
				url : '/api/category/' + categoryId,
				method : "put",
				processData : true,
				contentType : "application/json; charset=UTF-8",
				data : JSON.stringify({
					name : categoryName
				})
			}).done(function(){
				$('#' + categoryId + '>input').val(categoryName);
			})
		},
		addCategoryRequest : function(event){
			categoryName = $(event.target).siblings(".categoryName").val();
			$.ajax({
				url : '/api/category/' + categoryName,
				method : "post",
				processData : true,
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					categoryId=data;
				}
			}).done(function(){
				$("ul").append(li_template);
				$("ul").find(">li:last-child").attr("id", categoryId);
				$("ul").find(">li:last-child>.categoryName").attr("value", categoryName);
			})
		}
	};
})();

$(document).on("click", ".delete", clickEventListener.deleteCategoryRequest);

$(document).on("click", ".update", clickEventListener.updateCategoryRequest);

$(document).on("click", ".add", clickEventListener.addCategoryRequest);
