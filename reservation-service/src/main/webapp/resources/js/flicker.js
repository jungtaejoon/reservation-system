var FLICKER = (function(){
    function init(){
        $.each($('.slider-container .item'), function(index){
            var offset = index * $(this).width();
            var current = $(this).prop('offsetLeft');
            $(this).css('left', current + offset);
        });

        $('.slider-container .item:first').addClass("view");
        $('.slider-container .item:not(.view)').css('visibility', 'visible');
        $('.slider-container .item').on("touchstart", handleTouchStart);
        $('.slider-container .item').on("touchmove", handleTouchMove);
        $('.slider-container .item').on("touchend", handleTouchEnd);
    }

    var startingX;
    var startingOffsetLeft;
    var beforeX;

    var handleTouchStart = function (evt) {
        evt.preventDefault();
        console.log("start: " + evt.touches[0].clientX);
        startingX = evt.touches[0].clientX;
        startingOffsetLeft = $(this).offset().left;
        beforeX = $(this).offset().left;
    }

    var handleTouchMove = function(evt){
        evt.preventDefault();
        console.log("moving: " + evt.touches[0].clientX);
        var touch = evt.touches[0];
        var change = beforeX - touch.clientX;

        var $movingItems = $(this).siblings().addBack();
        if (change < 0){
            $.each($movingItems, function(index){
                beforeX = $(this).offset();
                var position = startingOffsetLeft + (index * $(this).width());
                $(this).css('left', position + change);
            });
        } else {
            $.each($movingItems, function(index){
                beforeX = $(this).offset();
                var position = startingOffsetLeft + (index * $(this).width());
                $(this).css('left', position - change);
            });
        }
    }

    var handleTouchEnd = function(evt){
        evt.preventDefault();
        var change = startingX - evt.changedTouches[0].clientX;
        var threshold = screen.width / 3;
        console.log($(this).siblings().addBack());

        var $movingItems = $(this).siblings().addBack();
        if (change < threshold){    // 이동한 거리가 기준보다 작을 때는 원래대로
            $.each($movingItems, function(index){
                var current = $(this).offset();
                var position = startingOffsetLeft + (index * $(this).width());
                $(this).css('left', position);
                $(this).css('transition', 'all .3s');
            });
        } else {    // // 이동한 거리가 기준보다 클 때는 한 칸 진행
            $.each($movingItems, function(index){
                var offset = $(this).width();
                var position = startingOffsetLeft + (index * $(this).width());
                $(this).css('left', position - offset);
                $(this).css('transition', 'all .3s');
            });
        }
    };
    return {
        init: init
    }
})();

