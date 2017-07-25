var DisplayProducts = (function() {
	var template; 
	function init() {
		template = Handlebars.compile($("#display_info_box_template").html());
		bindEvents();
	}
	function bindEvents() {
		$('.more .btn').on('click', moreBtnClick.bind(this));
		$('.anchor').on('click', anchorClick.bind(this));
	}
	function appendProducts(res) {
		var left = [];
		var right = [];
		for(var i = 0; i < res.length; i++) {
			if(i % 2 === 0) {
				left.push(res[i]);
			} else {
				right.push(res[i]);
			}
		}
		var leftData = {items: left};
		var rightData = {items: right};
		$('#left_column').append(template(leftData));
		$('#right_column').append(template(rightData));
		if(etcData.getGap() <= 10) {$('.more .btn').addClass('invisible');}
	}
	function changeCounts(res) {
		etcData.setCounts(res);
		$('#product_counts').html(res + '개');
		if(etcData.getGap() > 10) {$('.more .btn').removeClass('invisible');}
	}
	function refreshProducts(res) {
		$('#display_info_box ul').empty();
		appendProducts(res);
	}
	function moreBtnClick(e) {
		etcData.increaseFirstIndex(10);
		if(etcData.getCategoryId()) {
			url = '/categories/' + etcData.getCategoryId() + '/products?start=' + etcData.getFirstIndex();
		} else {
			url = '/products/?start=' + etcData.getFirstIndex();
		}
		callAjax(url, appendProducts);
	}
	function anchorClick(e) {
		etcData.setCategoryId($(e.currentTarget).data('category-id'));
		etcData.resetFirstIndex();
		var url1;
		var url2;
		if(etcData.getCategoryId()) {
			url1 = '/categories/' + etcData.getCategoryId() + '/products?start=' + etcData.getFirstIndex();
			url2 = '/categories/' + etcData.getCategoryId() + '/products/count';
		} else {
			url1 = '/products/?start=' + etcData.getFirstIndex();
			url2 = '/products/count';
		}
		callAjax(url1, refreshProducts);
		callAjax(url2, changeCounts);
		if($(e.currentTarget).hasClass('active')) {
			return;
		} else {
			$('.anchor').removeClass('active');
			$(e.currentTarget).addClass('active');
		}
	}
	$(window).scroll(function() {
		var maxHeight = $(document).height();
		var currentScroll = $(window).scrollTop() + $(window).height();
		if(maxHeight - currentScroll < 30) {
			if(!$('.more .btn').hasClass('invisible')) {moreBtnClick();}
		}
	});
	function callAjax(url, func) {
		$.ajax({
		    method : 'get',
		    url : url,
		    success : func,
		    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
		    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	}
		});
	}
	return {
		init: init
	}
})();