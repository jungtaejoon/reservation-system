var DetailModule = (function(){
	
	var init = function(){
		DetailModule.selectProductDetail();
		DetailModule.showImageforScroll();

		$('ul.info_tab_lst').on('click', 'li a.anchor', DetailModule.detailToggling);
		$('div.group_btn_goto').on('click', '.naver-splugin.btn_goto_share', DetailModule.naverShareAPI);
		
	}
	
	var selectProductDetail = function(){
		
		var id = $('div#container').data('product-id');
		
		$.ajax({
			type : "GET",
			url : "/products/" + id,
			success : function(productDetail){ 
				DetailModule.productDetailtext(productDetail);
				DetailModule.naverMapAPI(productDetail.placeStreet);
			}
		});
	};
	
	var productDetailtext = function(productDetail){
		//관람시간, 시작날짜, 끝나는날짜 
		var productDetailhtml = productDetail.observationTime + "<br>" + productDetail.displayStart + "<br>" + productDetail.displayEnd;
		$('div.store_details p.dsc').html(productDetailhtml);
		$('div.event_info div.in_dsc').text(productDetail.event);
		
		//장소
		var $location = $('div.store_addr_wrap');
		$location.find('.store_addr.addr_detail').text(productDetail.placeName);
		$location.find('p.store_addr.store_addr_bold').text(productDetail.placeStreet);
		$location.find('span.addr_old_detail').text(productDetail.placeLot);

		var $detailInfo = $('ul.lst_store_info').find('span.item_rt a');
		$detailInfo.eq(0).text(productDetail.tel).prop('href', 'tel:'+productDetail.tel);
		$detailInfo.eq(1).text(productDetail.homepage).prop('href', productDetail.homepage);
		$detailInfo.eq(2).text(productDetail.email).prop('href', 'mailto:'+productDetail.email);
		
		var $additionalService = $('div.group_btn_goto').find('a');
		$additionalService.eq(0).prop('href', productDetail.homepage);
		$additionalService.eq(1).prop('href', 'tel:'+productDetail.tel);
		$additionalService.eq(2).prop('href', 'mailto:'+productDetail.email);
		
		var $productTitle = $('ul.visual_img').first();
		$productTitle.find('.visual_txt_tit').first().text(productDetail.name);
		$productTitle.find('.visual_txt_dsc').first().text(productDetail.description);
	}
	
	var detailToggling = function(e){
		e.preventDefault();
		
		var $detail_information = $('div.detail_area_wrap');
		var $detail_location = $('div.detail_location');
		
		$('ul.info_tab_lst li a.active').removeClass('active');
		$(this).addClass('active');
		
		//상세정보, 오시는길 카테고리 전환
		if($(this).closest('li').hasClass('_detail')){
			$detail_information.removeClass('hide');
			$detail_location.addClass('hide');
		}else if($(this).closest('li').hasClass('_path')){
			$detail_location.removeClass('hide');
			$detail_information.addClass('hide');
		}
	}
	
	var showImageforScroll = function(){
		$(window).on('scroll', function(){
			  
			  var $imageGroup = $('ul.detail_info_group');
			  var scrollBottom = $(window).scrollTop()+ $(window).height() ;
			  var imageTop = $imageGroup.find('li').eq(1).offset().top;
			  var lazyImageTop = $imageGroup.find('li').eq(2).offset().top;
			  
			  if(scrollBottom > imageTop){
				  $('#detail_imgview').removeClass('hide');
			  }
			  
			  if(scrollBottom > lazyImageTop && lazyImageTop!==0){
				  $imageGroup.find('li.in_img_lst img').eq(1).lazyload();
				  //$(this).off('scroll');//최초에 한번실행, 이미지 로딩후 더 이상 불필요한 스크롤 이벤트 객체 해제
			  }
			  
		});
	}
	
	var naverMapAPI = function(streetAddress){
		
		var map = new naver.maps.Map('map');
	      var myaddress = streetAddress;// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
	      naver.maps.Service.geocode({address: myaddress}, function(status, response) {
	          if (status !== naver.maps.Service.Status.OK) {
	              return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
	          }
	          var result = response.result;
	          
	          var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
	          map.setCenter(myaddr); // 검색된 좌표로 지도 이동
	          // 마커 표시
	          var marker = new naver.maps.Marker({
	            position: myaddr,
	            map: map
	          });
	      });
	
	}
	
	var naverShareAPI = function(e){
		e.preventDefault();
        var url = encodeURI(encodeURIComponent("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&oquery=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B0%9C%EB%B0%9C%EC%9E%90%EC%84%BC%ED%84%B0&ie=utf8&query=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B0%9C%EB%B0%9C%EC%9E%90%EC%84%BC%ED%84%B0"));
        var title = encodeURI("네이버개발자센터 검색결과");
        var shareURL = "http://share.naver.com/web/shareView.nhn?url=" + url + "&title=" + title;
        document.location = shareURL;
	}
	
	return {
		init : init,
		selectProductDetail : selectProductDetail,
		detailToggling : detailToggling,
		showImageforScroll : showImageforScroll,
		productDetailtext : productDetailtext,
		naverMapAPI : naverMapAPI,
		naverShareAPI : naverShareAPI
	};
	
})();

var TitleImageModule = (function(){
	var width = 414;
	var animationSpeed = 1000;
	var $slider = $('div.container_visual');
	var $slideContainer = $slider.find('ul.visual_img').first();
	var imgNum=1;
	var imgCount;
	
	var id = $('div#container').data('product-id');
	
	var source = $("#product_image_template").html(); 
	var product_image_template = Handlebars.compile(source); 
	
	var init = function(){
		TitleImageModule.selectProductTitle();
		
		$('div.prev').on('click', 'div.prev_inn',TitleImageModule.preButtonMove);
		$('div.nxt').on('click', 'div.nxt_inn', TitleImageModule.nxtButtonMove);
	}
	
	var selectProductTitle = function(){
		
		$.ajax({
			type : "GET",
			url : "/products/" + id + "/imageCount",
			success : function(imageList){
				imgCount = imageList.length;
				$('div.figure_pagination').find('span.num.off').text('/ '+imgCount);
				
				$.map(imageList, function(image){
					$slideContainer.append(product_image_template(image));
				})
			}			
		});	
	}
	
	var preButtonMove = function(e){
		e.preventDefault();
		if(imgNum <= 1) return;
		var direction ="+=";
		CommonModule.imgMove($slideContainer, direction, width, animationSpeed, TitleImageModule.imgMoveAnimate);//재활용
		imgNum--;
	}
	
	var nxtButtonMove = function(e){
		e.preventDefault();
		if(imgNum >= imgCount) return;
		var direction ="-=";
		CommonModule.imgMove($slideContainer, direction, width, animationSpeed, TitleImageModule.imgMoveAnimate);
		imgNum++;
	}
	
	var imgMoveAnimate = function(){
		$('div.figure_pagination').find('span.num').first().text(imgNum);
	}
	
	return{
		init : init,
		selectProductTitle : selectProductTitle,
		preButtonMove : preButtonMove,
		nxtButtonMove : nxtButtonMove,
		imgMoveAnimate : imgMoveAnimate
	}
	
})();

var TouchModule = (function(){
	
	var $touchContainer = $('div.group_visual');
	var $touchImage = $('#product_image_template').closest('div.container_visual');
	var startX;
	var moveX;
	var endX;
	var width;
	var imageStartPosition;
	
	
	var init = function(){
		$($touchContainer).on('touchstart', $touchImage, TouchModule.touchStart);
		$($touchContainer).on('touchmove', $touchImage, TouchModule.touchMove);
		$($touchContainer).on('touchend', $touchImage, TouchModule.touchEnd);
	}
	
	var touchStart = function(event){
		event.preventDefault(); 
	    var e = event.originalEvent; 

		console.log('터치시~~~작');
		imageStartPosition = $(this).css('left');
		console.log(imageStartPosition);
		startX = e.targetTouches[0].pageX; 
		
	}
	
	var touchMove = function(event){
		event.preventDefault(); 
	    var e = event.originalEvent; 
	    
	    var elm = $(this).offset();

		console.log('elm'+elm.left);

		moveX = e.targetTouches[0].pageX; 
		console.log(moveX);
		
		width = moveX - startX;
		
		//console.log(imageStartPosition+width);
		
		$(this).css('left', width);
		
		e.preventDefault();
		
	}
	
	var touchEnd = function(){
		console.log('터치끄~~~~읕');
		if(width>100) {
			console.log("넘어가랏!");
			$(this).animate({left: 414}, 'fast'); 
			//$(this).css('left', 414);
		}else if(width<-100){
			//$(this).css('left', imageStartPosition-414);
			$(this).animate({left: -414}, 'fast');
		}else{
			console.log('돌아와랏');
			$(this).css('left', imageStartPosition);
		}
	}


	return {
		init : init,
		touchStart : touchStart,
		touchMove : touchMove,
		touchEnd : touchEnd
	}

	
})();


$(function(){
	DetailModule.init();
	TitleImageModule.init();
	TouchModule.init();
})

