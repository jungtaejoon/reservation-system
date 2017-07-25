var Product = (function() {

	// private
	var page = 1;
	var count = 0;

	/* 상품 */
	draw_view = function(productDTO) {
		var str = '';
		var source = $("#product-template").html();
		// 핸들바 템플릿 컴파일
		var template = Handlebars.compile(source);
		for ( var index in productDTO) {
			str = template(productDTO[index]);
			if (index % 2 == 0) {
				$('#productLeftList').append(str);
			} else {
				$('#productRightList').append(str);
			}
			str = '';
		}
	};

	get_list = function(callback) {
		$.ajax({
			type : 'get',
			url : '/api/products?page=' + page,
			success : function(result) {
				callback(result);
			}
		});
	};

	get_list_by_category = function(id, callback) {
		$.ajax({
			type : 'get',
			url : '/api/categories/' + id + '/products?page=' + page,
			success : function(result) {
				callback(result);
			}
		});
	};

	get_count_all = function() {
		$.ajax({
			type : 'get',
			url : '/api/products/count',
			success : function(result) {
				count = result;
				result += "개 ";
				$('#countSaleProduct').html(result);
			}
		});
	};
	get_count_by_category = function(id) {
		$.ajax({
			type : 'get',
			url : '/api/categories/'+ id + '/count',
			success : function(result) {
				count = result;
				result += "개 ";
				$('#countSaleProduct').html(result);
			}
		});
	};
	
	// public
	return {
		get : function() {
			get_list(draw_view);
		},

		list_by_category : function(id) {
			get_list_by_category(id, draw_view);
		},
		get_page : function() {
			return page;
		},
		init_page : function() {
			page = 1;
		},
		click_more : function() {
			var id = $('a.anchor.active').closest(".item").data('category');
			page++;
			if (id == 0) {
				get_list(draw_view);
			} else {
				list_by_category(id);
			}
		},
		// category를 이동 했을 때 page는 초기화하고 그려놓은 product들을 삭제한다.
		move : function(event) {
			var id = $(event.target).closest(".item").data('category');
			$('a.anchor').removeClass('active');
			$(event.target).closest('a.anchor').addClass('active');

			$('#productLeftList').empty();
			$('#productRightList').empty();
			Product.init_page();
			if (id == 0) {
				Product.get();
				get_count_all();
			} else {
				Product.list_by_category(id);
				get_count_by_category(id);
			}
		},
		set_count : function(id) {
			if (id == 0) {
				get_count_all();
			} else {
				get_count_by_category(id);
			}
		},
		get_count : function() {
			return count;
		}
	}
})();


/* ----나중에 사용하게 될 promotion ---- */
// function get_promotion_list(callback) {
// $.ajax({
// type : 'get',
// url : '/product/promotion',
// dataType : 'json',
// success : function(result) {
// callback(result);
// }
// });
// }
//	
// function list_promotion() {
// get_promotion_list(draw_promotion);
// }
// function draw_promotion(productVO) {
// var str = '';
// for (var index in productVO) {
// str += '<li class="item" style="background-image:' +
// 'url(resources/img/black.png); width: 338px;>' +
// '<a href="#"> <span class="img_btm_border"></span> <span
// class="img_right_border"></span> <span class="img_bg_gra"></span>'+
// '<div class="event_txt">'+
// '<h4 class="event_txt_tit">'+ productVO[index].name +'</h4>'+
// '<p class="event_txt_adr">'+ productVO[index].event +'</p>'+
// '<p class="event_txt_dsc">'+ productVO[index].event +'</p>'+
// '</div>'+
// '</a>'+
// '</li>';
// }
// $('.visual_img').append(str);
// }
