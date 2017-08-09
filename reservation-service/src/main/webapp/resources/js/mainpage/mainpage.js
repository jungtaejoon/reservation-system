$(function() {
	var CategoryList = (function() {
		var template = Handlebars.compile($('#category_list_template').html());
		CashedAjax.ajax('/categories').then(appendCategory);
		function appendCategory(res) {
			res = {
				items: res
			}
			$('ul.event_tab_lst').append(template(res));
		}
	})();
	
	var ProductList = (function() {
		var categoryId = 0;
		var template = Handlebars.compile($('#product_list_template').html());
		function init() {
			bindEvents();
			getProductList();
		}
		function bindEvents() {
			$('ul.event_tab_lst').on('click', 'li.item', clickCategoryEvent);
		}
		function clickCategoryEvent(e){
			$('li.item a').removeClass('active');
			$(e.currentTarget).find('a').addClass('active');
			categoryId = $(e.currentTarget).data('category');
			getProductList();
		}
		function getProductList() {
			var url = '/categories/' + categoryId + '/products?start=0';
			CashedAjax.ajax(url).then(appendProduct);
		}
		function appendProduct(res) {
			var left = [];
			var right = [];
			for(var i = 0, l = res.length; i < l; i++) {
				if(i%2) {
					right.push(res[i]);
				} else {
					left.push(res[i]);
				}
			}
			$('.lst_event_box.left_box').append(template({products:left}));
			$('.lst_event_box.right_box').append(template({products:right}));
		}
		return {
			init: init
		}
	})();

	ProductList.init();
});



