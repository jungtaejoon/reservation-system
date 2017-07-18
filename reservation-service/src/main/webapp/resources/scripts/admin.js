const HOST = 'http://localhost:8080';
(function (window) {
	$(".editBtn").on("click", function(ev){editBtn_click(ev);});
	$(document).on("click", ".updateBtn", function(ev){updateBtn_click(ev)});
	$(document).on("click", ".deleteBtn", function(ev){deleteBtn_click(ev)});
//	$(".updateBtn").on("click", updateBtn_click);
//	$(".deleteBtn").on("click", deleteBtn_click);

})(window);

function editBtn_click(ev){
	console.log(ev);
	$(ev.target).parent().addClass('editing');
	$('.editBtn').css("visibility", "hidden");
	$('.editing .category_label, .editing .editBtn').addClass('invisible');
	$('.editing .category_edit, .editing .updateBtn').removeClass('invisible');

}

function updateBtn_click(ev){
	console.log(ev);
	var url = HOST + '/api/category';
	var data = '{"id": "' + $('.editing').attr("data_id") 
		+ '", "name": "' + $('.editing .category_edit').val() + '"}';
//	var data = "id="+$('.editing').attr("data_id")+"&name="+$('.editing .category_edit').val();
	
	$.ajax({
		url: url,
		type: 'PUT',
		//contentType: 'application/x-www-form-urlencoded',
		contentType: 'application/json',
		data: data
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
	console.log(ev);
	var url = HOST+ '/api/category/'+ $(this).parent().attr("data_id");
	$(ev.target).parent().addClass("deleting");
	
	$.ajax({
		url: url,
		type: 'DELETE',
//		contentType: 'application/x-www-form-urlencoded'
		contentType: 'application/json'
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
