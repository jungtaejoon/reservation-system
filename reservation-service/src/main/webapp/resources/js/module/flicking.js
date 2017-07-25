/**
 * Flicking Module
 *
 
 var options = {
    slider : '.visual_img',
    buttonContainer : '.container_visual',
    viewTime: 300,
    status: {
        size: imageCount,
        index: 1,
    },
}

Flicking.setup().init(options);

 */

var Flicking = (function($, window, document, undefined){
    
    var instance = null;

    function Flicking(options) {

        /**
         * Default Options Object
         * @param viewTime : 슬라이드 애니메이션 시간
         * @param rollingTime : 슬라이드 자동 넘어가는 시간
         * @param restartTime : 슬라이드 재시작 대기 시간
         * @param autoStart : 슬라이드 자동 시작 여부
         * @param circulation : 순환 방식 적용 여부
         * @param carouselName : 슬라이드 클래스 및 아이디 이름
         * @param intervalTimer : setInterval 변수
         * @param clickTimer : setTimeout 변수
         * 
         * * Status 관리 Object
         * @param index : 현재 슬라이드 위치
         * @param size  : 슬라이드 총 갯수
         * 
         * * jQuery Object
         * @param slider : 슬라이드 컨테이너 객체
         * @param buttonContainer : 슬라이드 컨트롤 (이전, 다음) 버튼 컨테이너 객체
         * 
         * * callback Function
         * @param updateState : index, size 업데이트 콜백 function 지정
         * 
         */

        var defaultOptions = {
            viewTime: 500,
            rollingTime: 2000,
            restartTime: 2000,
            autoStart: true,
            circulation : true,
            flicking : false,
            direction : 'next',
            carouselName : '',
            intervalTimer : null,
            clickTimer : null,
            status : {
                index : 1,
                size : 0,
            },
            slider : null,
            buttonContainer : null,
            updateState : function() {}
        }


        function init(options) {
            defaultOptions = $.extend({}, defaultOptions, options);

            var options = defaultOptions;
            var $slider = $(options.slider);
            var $items = $slider.find('li');
            var itemWidth = $items.width();

            eventBinding();

            // 순환 [적용] 일 경우
            if(options.circulation) {
                
                // 아이템의개수가 3이상이면, 마지막 슬라이드를 첫번째 앞에 붙이고 마지막 슬라이드를 삭제
                // 아이템 개수가 3개 미만일 경우에는 앞뒤에 붙여준다.
                if($items.length < 3) {
                    var cloneLast = $items.last().clone(true);
                    var cloneFirst = $items.first().clone(true);

                    $items.first().before(cloneLast);
                    $items.last().after(cloneFirst);
                } else {
                    var cloneLast = $items.last().clone(true);
                    $items.first().before(cloneLast);
                    $items.last().remove();
                }
                
                $slider.css({'left' : -itemWidth}); // css 초기화
            } else {
                $slider.css({'left' : 0});
            }

            options.status.size = $items.length;

            options.autoStart && carouselStart()
            options.flicking && flickingInit()
        }


        function clear() {
            defaultOptions = $.extend({}, defaultOptions, {
                status: {
                    index : 1,
                    size : 0,
                }
            });
            UnEventBinding();
        }


        function setStatus(status) {
            defaultOptions = $.extend({}, defaultOptions, status);
        }

        function eventBinding() {
            var $container = $(defaultOptions.buttonContainer);

            var $prevButton = ($container.find('.prev').length) 
                            ? $container.find('.prev') 
                            : $container.find('.prev_e');

            var $nextButton = ($container.find('.nxt').length) 
                            ? $container.find('.nxt') 
                            : $container.find('.nxt_e');

            ($prevButton.length) && $prevButton.on('click', move.bind(this, 'prev', 0));
            ($nextButton.length) && $nextButton.on('click', move.bind(this, 'next', 0));
        }


        function UnEventBinding() {
            var $slider = $(defaultOptions.slider);
            var $container = $(defaultOptions.buttonContainer);

            var $prevButton = ($container.find('.prev').length) 
                            ? $container.find('.prev') 
                            : $container.find('.prev_e');

            var $nextButton = ($container.find('.nxt').length) 
                            ? $container.find('.nxt') 
                            : $container.find('.nxt_e');

            ($slider.length) && $slider.off();
            ($prevButton.length) && $prevButton.off();
            ($nextButton.length) && $nextButton.off();
        }


        function carouselStart() {
            var options = defaultOptions;

            options.intervalTimer = setInterval(function(){
                move(options.viewTime, 'next', 0); // auto increment
            }, options.rollingTime);
        }


        function carouselStop() {
            var options = defaultOptions;

            options.intervalTimer != null 
            && clearInterval(options.intervalTimer);

            // clear & reset timer
            clearTimeout(options.clickTimer);

            if(options.autoStart) {
                // 4초 아무 이벤트 없을 시 리스타트 캐러셀
                options.clickTimer = setTimeout(function() {    
                    carouselStart();
                }, options.restartTime);
            }
        }


        function flickingInit() {
            var options = defaultOptions;
            var $slider = $(options.slider);
            var status = options.status
            var startX = 0
            var movePosition = 0
            var itemWidth = $slider.find('li').width()
            var saveX = -itemWidth * (status.index-1);
                
            $slider.on('touchstart', function(e) {
                if ( e.type === 'touchstart' && e.touches.length === 1 ) {
                    startX = e.touches[ 0 ].pageX;
                    saveX = parseInt($slider.css('left'));
                    e.preventDefault();
                }
            });

            $slider.on('touchmove', function(e) {
                e.preventDefault();
                var drag = 0;
                var scroll = 0;

                if ( e.type === 'touchmove' && e.touches.length === 1 ) {
                    drag = e.touches[0].pageX - startX;
                    movePosition = ( drag / itemWidth ) * 100;

                    if(!isPossibleMove(status, options.circulation, movePosition)) return false;

                    if (Math.abs(drag) > Math.abs(scroll)) {
                        
                        $slider.css({'left' : saveX + movePosition });
                        e.preventDefault();
                    } 
                }
            });

            $slider.on('touchend', function(e) {
                if ( e.type === 'touchend' && e.touches.length === 0 ) {

                    if(!isPossibleMove(status, options.circulation, movePosition)) return false;
                    
                    if (Math.abs( movePosition ) > 40 ) {

                        if(movePosition < 0) { // next
                            move('next', movePosition);
                        } else { // prev
                            move('prev', movePosition);
                        }
                    
                    } else {
                        $slider.css({ 'left' : saveX }); // 초기화
                    }

                    startX = 0;
                    movePosition = 0;

                    e.preventDefault();
                }
            });
        }


        function isPossibleMove(status, circulation, movePosition) {

            if(status.index === 1 && status.size === 1 && !circulation) {
                return false;
            }
            else if(status.index === 1 && !circulation) {
                // 첫번째 페이지에서 왼쪽으로 터치이벤트시 실행되지 않는다.
                if(movePosition >= 0) return false;
            }
            else if(status.index === status.size && !circulation) {
                // 마지막 페이지에서 오른쪽으로 터치이벤트시 실행되지 않는다.
                if(movePosition <= 0) return false;
            }

            return true;
        }


        function move(direction, swipe) {
            var options = defaultOptions;
            var status = options.status;
            var duration = options.viewTime;

            // autoStart == true 일 경우 carouselStop 호출
            options.autoStart && carouselStop();

            var $slider = $(options.slider);
            var $item = $slider.find('li');
            var itemWidth = $item.width();
            var leftIndent = parseInt($slider.css('left'));
            var movePosition = parseInt(swipe) || 0;

            if(direction === 'prev') {

                // index가 0인데, circulation가 false 일 경우 순환 캐러샐이 아니기 때문에, 진행하지 않고 리턴
                if((status.index === 1) && !options.circulation) return false;

                $slider.filter(':not(:animated)').animate({ "left" : leftIndent + (itemWidth - movePosition) }, duration, 
                function complete() {
                    options.circulation && $item.first().before($item.last());
                    options.circulation && $slider.css({'left' : -itemWidth}); // 초기화
                    !options.circulation && $slider.css({'left' : -itemWidth * (status.index-1)});

                });

                --status.index;

                if(status.index <= 0) {
                    status.index = status.size;
                }

            } else {

                // index이 size와 같으면서, circulation가 false 일 경우 순환 캐러샐이 아니기 때문에, 진행하지 않고 리턴
                if((status.index === status.size) && !options.circulation) return false;

                $slider.filter(':not(:animated)').animate({ "left" : leftIndent - (itemWidth + movePosition) }, duration, 
                function complete() {
                    options.circulation && $item.last().after($item.first());
                    options.circulation && $slider.css({'left' : -itemWidth}); // 초기화
                    !options.circulation && $slider.css({'left' : -itemWidth * (status.index-1)});

                });

                ++status.index;

                if(status.index > status.size) {
                    status.index = 1;
                }
            }

            defaultOptions = $.extend({}, defaultOptions, status);

            
            // 설정할 때 넘겨 받은 param callback update Status
            (options.updateState) && options.updateState(status.index, status.size);
        }

        return {
            init : init,
            clear : clear,
        }
    }

    return {
        setup : function(options) {
            instance = Flicking(options);
            return instance;
        }
    }

})($, window, document, undefined);