$(function() {
	var CategoryList = (function() {
		var template = Handlebars.compile($('#category_list_template').html());
		CachedAjax.ajax('/categories').then(appendCategory);
		function appendCategory(res) {
			
			var productTotalCount = res.reduce(function add(acc, value) {
				return acc + value.productCount;
			}, 0);		
			// Q. data('product-count')로 하면 값변경이 안됨
			$('.event_tab_lst li[data-category="0"]').attr('data-product-count', productTotalCount);
			$('.event_lst_txt .pink').text(productTotalCount+'개');
			
			res = {
				items: res
			}
			$('ul.event_tab_lst').append(template(res));
		}
	})();
	
	var ProductList = (function() {
		var categoryId = 0;
		var template = Handlebars.compile($('#product_list_template').html());
		var pageNum = 0;
		function init() {
			bindEvents();
			getProductList(pageNum, "html");
		}
		function bindEvents() {
			$('ul.event_tab_lst').on('click', 'li.item', clickCategoryEvent);
			$(window).scroll(scrollUpdate); 
		}
		function clickCategoryEvent(e){
			pageNum = 0;
			$('li.item a').removeClass('active');
			$(e.currentTarget).find('a').addClass('active');
			$('.event_lst_txt .pink').text($(e.currentTarget).data('product-count')+'개');
			categoryId = $(e.currentTarget).data('category');
			getProductList(pageNum, "html");
		}
		function getProductList(pageNum, type) {
			var url = '/categories/' + categoryId + '/products?page='+pageNum;
			CachedAjax.ajax(url).then(appendProduct.bind(this, type));
		}
		function appendProduct(type, res) {
			var left = [];
			var right = [];
			for(var i = 0, l = res.length; i < l; i++) {
				if(i%2) {
					right.push(res[i]);
				} else {
					left.push(res[i]);
				}
			}
			$('.lst_event_box.left_box')[type](template({products:left}));
			$('.lst_event_box.right_box')[type](template({products:right}));
		}
		function scrollUpdate(e){
			var maxHeight = $(document).height();
			var currentScroll = $(document).scrollTop() + $(window).height();
			if(maxHeight - currentScroll < 30){
				var productTotalCount = parseInt($(".event_lst_txt .pink").text().replace('개', ''));
				pageNum++;
				if(productTotalCount > pageNum*10){					
					getProductList(pageNum, "append");
				}
			}
		}
		return {
			init: init,
		}
	})();

	ProductList.init();
	
});



