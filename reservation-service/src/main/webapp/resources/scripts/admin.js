const HOST = 'http://localhost:8080/admin';
(function (window) {
	$(".editBtn").on("click", editBtn_click);
	$(".updateBtn").on("click", updateBtn_click);
	$(".deleteBtn").on("click", deleteBtn_click);

})(window);

function editBtn_click(){
	
	$(this).parent().addClass('editing');
	$('.editBtn').css("visibility", "hidden");
	$('.editing .category_label, .editing .editBtn').addClass('invisible');
	$('.editing .category_edit, .editing .updateBtn').removeClass('invisible');

}

function updateBtn_click(){
	
	var url = HOST + '/api';
	var data = '{"id": "' + $('.editing').attr("data_id") 
		+ '", "name": "' + $('.editing .category_edit').val() + '"}';
	
	$.ajax({
		url: url,
		type: 'PUT',
		contentType: 'application/json',
		dataType: 'json',
		data: data,
	})
	.done(function() {
		var name = $('.editing .category_edit').val();
		$('.editing .category_label').html(name);
		$('.editing .category_edit').attr("value", name);
	})
	.fail(function() {
		alert("update failed.");
	})
	.always(function() {
		$('.editing .category_edit, .editing .updateBtn').addClass('invisible');
		$('.editing .category_label, .editBtn').removeClass('invisible');
		$('.editBtn').css("visibility", "visible");
		$('.editing').removeClass('editing');
	});
}

function deleteBtn_click() {
	var url = HOST+ '/api/'+ $(this).parent().attr("data_id");
	$(this).parent().addClass("deleting");
	
	$.ajax({
		url: url,
		type: 'DELETE',
		contentType: 'application/json',
		dataType: 'json'
	})
	.done(function() {
		$('.deleting').parent().remove();
	})
	.fail(function() {
		alert("delete failed.");
	})
	.always(function() {
		
	});
	
}
