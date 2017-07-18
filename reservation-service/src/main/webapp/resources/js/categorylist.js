var categorylist = (function(){
	'use strict'
	
	var $ul_lst_event_boxes = $('ul.lst_event_box');

	var curruntCategoryId = 0;
	var lastProductId;
    
	var scrollFlag = true;
	
	// productList 추가
	function appendProductList(product_list){
		$.each(product_list, function(index, product){
			lastProductId = product.id;
			var template = Handlebars.templates.product(product);
			if(index%2 === 0){
				$($ul_lst_event_boxes[0]).append(template);
			} else {
				$($ul_lst_event_boxes[1]).append(template);
			}
		})
	};
	
	return {
		viewProductByCategory: function(event){
			// active 클래스 제거 및 추가
			$(this).parent().find('.active').removeClass('active');
			$(this).find('a').addClass('active');
			
			$ul_lst_event_boxes.find('li').remove(); // 프로덕트 리스트 초기화
			
			curruntCategoryId = $(this).data('category');
			var url = '/api/product/';
			if(curruntCategoryId === 0){	// 이건 전체 카테고리
				
			} else {
				url = url + curruntCategoryId;
			}
			$.ajax({
				url: url,
				type: 'GET',
				contentType: 'application/json; charset=UTF-8'
			}).done(function(result){
				if(result.length !== 0){
					appendProductList(result);
				} else {
					alert('상품 정보가 없습니다.');
				}
			})
			.fail(function(){
			});
		},
		
		viewMoreProductList: function(event){
			var url = '/api/product/more';
			if(curruntCategoryId === 0){	// 이건 전체 카테고리
			} else {
				url = url + "/" + curruntCategoryId;
			}
			$.ajax({
				url: url + "/" + lastProductId,
				type: 'GET',
				contentType: 'application/json'
			})
			.done(function(result){
				if(result.length !== 0){
					appendProductList(result);
				} else {
					//alert('더보기 결과가 없습니다.');
				}
				scrollFlag = true;
			})
			.fail(function(){
			});
		}, 
		
		updateCount: function(event){
			curruntCategoryId = $(this).data('category');
			var url = '/api/product/count/';
			if(curruntCategoryId === 0){	// 이건 전체 카테고리
				
			} else {
				url = url + curruntCategoryId;
			}
			$.ajax({
				url: url,
				type: 'GET',
				contentType: 'application/json; charset=UTF-8'
			}).done(function(result){
				$('div.section_event_lst span.pink').text(result);
			})
			.fail(function(){
			});
		}, 
		
		scrollViewMoreProductList: function(){
			var timer;
			var docTop = Math.round($(document).scrollTop());
			var docHeight = $(document).height();
			var winHeight = $(window).height();
			if(scrollFlag && docTop === docHeight - winHeight){
				scrollFlag = false;
				categorylist.viewMoreProductList(event);
			}
		}
	}
})();

$('ul.event_tab_lst').on('click', 'li.item', categorylist.viewProductByCategory);
$('ul.event_tab_lst').on('click', 'li.item', categorylist.updateCount);
$('ul.lst_event_box').on('click', 'li.item', function(event){
	event.preventDefault();
	event.stopPropagation();
	
	var id = $(this).data('id');
	var baseUrl = 'http://localhost:8080';
	var url = baseUrl + '/product/detail/' + id;
	window.location.href = url;
});

// 처음에 전체 리스트 출력하도록
$('li.item:first-child').trigger('click');

// 더보기 이벤트 추가
$('div.more > button.btn').on('click', categorylist.viewMoreProductList);

$(window).on("scroll", categorylist.scrollViewMoreProductList);
