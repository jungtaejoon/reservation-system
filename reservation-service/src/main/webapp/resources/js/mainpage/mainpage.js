$(function() {
	var template = Handlebars.compile($('#category_list_template').html());
	callAjax('/categories').then(appendCategory);
	function appendCategory(res) {
		res = {
			items: res
		}
		$('ul.event_tab_lst').append(template(res));
	}
	$('ul.event_tab_lst').on('click', 'li.item', function(e){
		var categoryId = $(e.currentTarget).data('category');
		getProductList(categoryId);
	});
	getProductList();
	
});


function out(res) {
	console.log(res);
}

function getProductList(categoryId) {
	var categoryId = categoryId || 0;
	var url = '/categories/' + categoryId + '/products?start=0';
	callAjax(url).then(out);
}