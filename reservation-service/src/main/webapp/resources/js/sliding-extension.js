var AUTO_SLIDNG_MODULE = (function () {
    'use strict';

    var intervalId;	// setInterval 담아둘 변수s
    var timerId;	// setTimeout 담아둘 변수

    var items_num;
    var sliding_idx;
    var li_item_width;	// 리스트 너비
    var is_auto_flag;

    var $ul_visual_img = $('ul.visual_img');

    function init(is_auto){
        items_num = $('ul.visual_img > li.item').length; // 프로모션 이미지 개수
        sliding_idx = 1;
        li_item_width = $ul_visual_img.find('li.item:eq(0)').width();	// 리스트 너비
        is_auto_flag = is_auto;

        if(is_auto_flag){
            $('ul.visual_img > li.item:last-child').clone().prependTo($ul_visual_img);
            $('ul.visual_img > li.item:first-child').clone().appendTo($ul_visual_img);

            $ul_visual_img.addClass('autoslide');

            intervalId = setInterval(nextSliding, 2000);
        } else {
            is_auto_flag = false;
        }
    }

    // next버튼 클릭하면 우측으로 이미지 슬라이드
    function nextSliding () {
        if(is_auto_flag){
            if(sliding_idx === items_num){
                sliding_idx = 0;
                $ul_visual_img.css('left', 0);
            } else {}
            sliding_idx++;
            $ul_visual_img.animate({
                left : "-=" + li_item_width + "px"
            }, {
                duration : 1000,
                complete: function() {
                    $(this).removeClass("active");
                }
            });
            $ul_visual_img.addClass("active");
        } else {
            if(sliding_idx < items_num){
                sliding_idx++;
                $ul_visual_img.animate({
                    left : "-=" + li_item_width + "px"
                }, {
                    duration : 1000,
                    complete: function() {
                        $(this).removeClass("active");
                    }
                });
                $ul_visual_img.addClass("active");
            }
        }
    }

    // prev버튼 클릭하면 좌측으로 이미지 슬라이드
    function prevSliding () {

        if(is_auto_flag){
            if(sliding_idx === 0){
                sliding_idx = items_num;
                $ul_visual_img.css('left', items_num * (-1) * li_item_width);
            } else {}
            sliding_idx--;
            $ul_visual_img.animate({
                left : "+=" + li_item_width + "px"
            }, {
                duration : 1000,
                complete: function() {
                    $(this).removeClass("active");
                }
            });
            $ul_visual_img.addClass("active");
        } else {
            if(sliding_idx > 1){
                sliding_idx--;
                $ul_visual_img.animate({
                    left : "+=" + li_item_width + "px"
                }, {
                    duration : 1000,
                    complete: function() {
                        $(this).removeClass("active");
                    }
                });
                $ul_visual_img.addClass("active");
            }
        }
    }
    // autoSliding을 멈추고, (clearInterval)
    // 4초 동안 클릭이 없으면 autoSliding을 재개한다.
    function pauseSliding(event){
        event.preventDefault();		// 취소가능한 이벤트를 취소한다.
        event.stopPropagation();	// 이벤트 전파를 막는다.
        clearInterval(intervalId);
        clearTimeout(timerId);
        timerId = setTimeout(function () {
            intervalId = setInterval(nextSliding, 2000);
        }, 4000);
    };

    function getSlidingIdx(){
        return sliding_idx;
    };

    return {
        getSlidingIdx: getSlidingIdx,
        pauseSliding: pauseSliding,
        prevSliding: prevSliding,
        nextSliding: nextSliding,
        init: init
    }
})();