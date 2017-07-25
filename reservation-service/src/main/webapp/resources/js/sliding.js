    (function (){
		var intervalId;	// setInterval 담아둘 변수
		var timerId;	// setTimeout 담아둘 변수
    	
        var $lnk_logo_reservation = $('a.lnk_logo[title=예약]');
        $lnk_logo_reservation.attr("href", "/");
		
		var $promotion_area = $('div.container_visual');
		
        
        var $sliding_ul = $('ul.visual_img');	// 프로모션 영역 ul
        var $sliding_items = $('ul.visual_img > li.item');	// 프로모션 영억 li
        var items_num = $sliding_items.length; // 프로모션 이미지 개수
 		
 		var idx_slide = 0;
        
		var $btn_pre = $promotion_area.find('.btn_pre_e');
		var $btn_nxt = $promotion_area.find('.btn_nxt_e');

        
        // 우측으로 오토슬라이딩하다가 끝에 가면 처음으로 돌아간다.
/* 		var autoSlide = function () {
			if(idx_slide < items_num - 1){
				idx_slide++;
				$sliding_ul.animate({
					left : "-=338px"
				}, {
					duration : 1000
				});
			} else {
				idx_slide = 0;
				$sliding_ul.animate({
					left : 0
				}, {
					duration : 1000
				});
			}
		};
 */		// 도전과제: FE
		// 자동 슬라이드를 순환하여 적용
		// 리스트가 계속 이어지듯이 슬라이드
		// 한 번 슬라이드 될 때마다, 
		// 첫번째 리스트를 ul 마지막에 붙이고, ul을 움직인 만큼 원위치 시키고, ul 맨 앞 리스트를 제거한다. 
	    var autoSlide = function() {
	       	var $first = $('ul.visual_img > li.item:first');
	       	$sliding_ul.animate({
	 			    left: "-=338px"
				}, {
	 			    duration: 1000,
	 			    start: function() {
	 			    	$btn_nxt.off('click');
	 			    },
	 			    complete: function() {
	 			    	$btn_nxt.on("click", function(event){
	 						pauseSliding(event);
	 						//nextSliding();
	 						autoSlide();
	 					});
	 			    	$sliding_ul.css("left", "+=338");
	 			    	$sliding_ul.append($first);
	 			    }
				});
	    };
		
		// prev버튼 클릭하면 좌측으로 이미지 슬라이드
		function prevSliding () {
			if(idx_slide > 0){
				idx_slide--;
				$sliding_ul.animate({
					left : "+=338px"
				}, {
					duration : 1000
				});
			} else {
				idx_slide = 0;
				$sliding_ul.animate({
					left : 0
				}, {
					duration : 1000
				});				
			}
		}
		
		// next버튼 클릭하면 우측으로 이미지 슬라이드
		function nextSliding () {
			if(idx_slide < items_num - 1){
				idx_slide++;
				$sliding_ul.animate({
					left : "-=338px"
				}, {
					duration : 1000
				});
			} else {
				idx_slide = 0;
				$sliding_ul.animate({
					left : 0
				}, {
					duration : 1000,
				});
			}
		}
		
		var $promotion_area = $('div.container_visual');
		
		intervalId = setInterval(autoSlide, 2000);
		
		$btn_pre.on("mouseenter", pauseSliding);
		
		// 오토 슬라이딩을 멈추고 좌측으로 슬라이딩
		$btn_pre.on("click", function(event){
			pauseSliding(event);
			//prevSliding();
			autoSlide();
		});
		
		// 오토 슬라이딩을 멈추고 우측으로 슬라이딩
		$btn_nxt.on("click", function(event){
			pauseSliding(event);
			//nextSliding();
			autoSlide();
		});

		// autoSliding을 멈추고, (clearInterval)
		// 4초 동안 클릭이 없으면 autoSliding을 재개한다.
		function pauseSliding(event){
			event.preventDefault();		// 취소가능한 이벤트를 취소한다.
			event.stopPropagation();	// 이벤트 전파를 막는다.
			clearInterval(intervalId);
			clearTimeout(timerId);
			timerId = setTimeout(function () {
				intervalId = setInterval(autoSlide, 2000);
			}, 4000);
		}
		
		var URL = "/api/detail";
		
		function viewDetail(event){
			event.preventDefault();		// 취소가능한 이벤트를 취소한다.
			event.stopPropagation();	// 이벤트 전파를 막는다.
			console.log(event.target);
			$.ajax({
				url: URL,
				type: "GET"
			}).done(function(){
				
			})
			.fail(function(){
				
			});
		}
		
		$sliding_items.on("click", viewDetail);
	})();
