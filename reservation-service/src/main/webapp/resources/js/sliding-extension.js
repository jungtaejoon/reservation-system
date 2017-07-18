var AutoSlidingModule = (function () {
	'use strict';
	
	var _setInterval;	// setInterval 담아둘 변수s
	var _setTimeout;	// setTimeout 담아둘 변수
	
    var $sliding_ul = $('ul.visual_img');	// 프로모션 영역 ul
    var $sliding_items = $('ul.visual_img > li.item');	// 프로모션 영억 li
    var items_num = $sliding_items.length; // 프로모션 이미지 개수
	
    var $sliding_first_item = $('ul.visual_img > li.item:first-child');
    var $sliding_last_item = $('ul.visual_img > li.item:last-child');
	
	var sliding_idx = 1;
	
	var li_item_width = $sliding_ul.find('li.item:eq(0)').width();	// 리스트 너비
	
	var is_auto_flag = true;
	
	function init(is_auto){
		is_auto_flag = is_auto;
		if(is_auto_flag){
		    $sliding_last_item.clone().prependTo($sliding_ul);
		    $sliding_first_item.clone().appendTo($sliding_ul);
		    
		    $sliding_ul.addClass('autoslide');
		    
		    _setInterval = setInterval(nextSliding, 2000);
		} else {
			is_auto_flag = false;
		}
	}
	
	// next버튼 클릭하면 우측으로 이미지 슬라이드
	function nextSliding () {
		if(is_auto_flag){
			if(sliding_idx === items_num){
				sliding_idx = 0;
				$sliding_ul.css('left', 0);
			} else {}
			$sliding_ul.animate({
				left : "-=" + li_item_width + "px"
			}, {
				duration : 1000,
			    complete: function() {
			    	sliding_idx++;
			    	$(this).removeClass("active");
			    }
			});
			$sliding_ul.addClass("active");
		} else {
			if(sliding_idx < items_num){
				$sliding_ul.animate({
					left : "-=" + li_item_width + "px"
				}, {
					duration : 1000,
				    complete: function() {
				    	sliding_idx++;
				    	$(this).removeClass("active");
				    }
				});
				$sliding_ul.addClass("active");
			}
		}
	}
	
	// prev버튼 클릭하면 좌측으로 이미지 슬라이드
	function prevSliding () {
		if(is_auto_flag){
			if(sliding_idx === 0){
				sliding_idx = items_num;
				$sliding_ul.css('left', items_num * (-1) * li_item_width);
			} else {}
			$sliding_ul.animate({
				left : "+=" + li_item_width + "px"
			}, {
				duration : 1000,
			    complete: function() {
					$(this).removeClass("active");
			    	sliding_idx--;
			    }
			});
			$sliding_ul.addClass("active");
		} else {
			if(sliding_idx > 1){
				$sliding_ul.animate({
					left : "+=" + li_item_width + "px"
				}, {
					duration : 1000,
				    complete: function() {
						$(this).removeClass("active");
				    	sliding_idx--;
				    }
				});
				$sliding_ul.addClass("active");
			}
		}
	}
	// autoSliding을 멈추고, (clearInterval)
	// 4초 동안 클릭이 없으면 autoSliding을 재개한다.
	function pauseSliding(event){
		event.preventDefault();		// 취소가능한 이벤트를 취소한다.
		event.stopPropagation();	// 이벤트 전파를 막는다.
		clearInterval(_setInterval);
		clearTimeout(_setTimeout);
		_setTimeout = setTimeout(function () {
			_setInterval = setInterval(nextSliding, 2000);
		}, 4000);
	};
	
	
	return {
		pauseSliding: pauseSliding,
		prevSliding: prevSliding,
		nextSliding: nextSliding,
		init: init
	}
})();