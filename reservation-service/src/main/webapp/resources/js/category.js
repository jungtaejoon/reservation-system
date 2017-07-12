$(document).ready(function() {
	$("#btnUpdate").css("display", "none");
});

function deleteCategory(cateId) {
	var element = $(this).parent('tr');
	$.ajax({
	    url : "/category/removeCategory/"+cateId,
	    type : "POST",
	    data : "cateId="+cateId,
	    success: function(data) {
	    	element.remove();
	    },
	    error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"error:"+error);
		}
	 
	}) 
};

function updateCategory(id, name) {
	$("#cateId").val(id);
	$("#newCategory").val(name);

	$("#btnSubmit").css("display", "none");
	$("#btnUpdate").css("display", "inline");
};

