
/*scroll */
	//더 보기를 하였을 때 page를 1증가 시키고 해당 category의 product를 10개 더 불러온다.
	//var isMore = true;



		
		
		/* ----나중에 사용하게 될 promotion ---- */
//		function get_promotion_list(callback) {
//			$.ajax({
//				type : 'get',
//				url : '/product/promotion',
//				dataType : 'json',
//				success : function(result) {
//					callback(result);
//				}
//			});
//		}
	//	
//		function list_promotion() {
//			get_promotion_list(draw_promotion);
//		}
//		function draw_promotion(productVO) {
//			var str = '';
//			for (var index in productVO) {
//				str += '<li class="item" style="background-image:' + 
//						'url(resources/img/black.png); width: 338px;>' +
//		        		'<a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>'+
//		            	'<div class="event_txt">'+
//		                '<h4 class="event_txt_tit">'+ productVO[index].name +'</h4>'+
//		                '<p class="event_txt_adr">'+ productVO[index].event +'</p>'+
//		                '<p class="event_txt_dsc">'+ productVO[index].event +'</p>'+
//		                '</div>'+
//		            	'</a>'+
//		        		'</li>';
//			}
//			$('.visual_img').append(str);
//		}