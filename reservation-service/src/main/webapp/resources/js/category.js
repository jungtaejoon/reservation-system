function remove_category_view(view, id) {
	view.remove();
}


function remove_category(view, id, callback) { 
	$.ajax({
		type:'post',
		url:'/category/remove',
		data:"id="+id,
		success:function() {
			callback(view, id);
		}
	});
}