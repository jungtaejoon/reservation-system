/**
 * rolling plugins
 */

(function($) {

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
     */
    $.rollingOptions = {
        viewTime: 500,
        rollingTime: 2000,
        restartTime: 2000,
        autoStart: true,
        circulation : true,
        flicking : false,
        direction : 'next',             // require [autoStart = true]
        carouselName : '.visual_img',
        intervalTimer : null,
        clickTimer : null,
        status : {
            index : 1,
            size : 0,
        },
    }

    /**
     * jQuery rolling function 
     * example) $('div').rolling(options)
     * 
     * @param options = $.rollingOptions
     */
    $.fn.rolling = function(options) {
        init(options);

        return {
            prev : move.bind(this, options, 'prev', 0),
            next : move.bind(this, options, 'next', 0),
        }

        // return this;
    }


    


    /**
     * --------------------------------------------------------------------------------------
     * Function
     * --------------------------------------------------------------------------------------
     */


    /**
     * 최초 한번 실행 initializing 함수
     * @param options : 초기 설정 시 부여하는 options Object
     */
    function init(options) {
        initOptions(options)
    }

    /**
     * @param options
     */
    function initOptions(options) {
        var extendsOptions = $.extend({}, $.rollingOptions, options);
        carouselInit(extendsOptions)
    }

    /**
     * 캐러샐 순환 형식 적용 
     * 순환되는 캐러샐을 위해서 앞뒤로 마지막과 첫번째 슬라이드를 복제해서 넣는다.
     */
    function carouselInit(options) {
        var $slider = $(options.carouselName);
        var $items = $slider.find('li');
        var itemWidth = $items.width();

        // 순환 [적용] 일 경우
        if(options.circulation) {
            var cloneLast = $items.last().clone(true);
            var cloneFirst = $items.first().clone(true);

            $items.first().before(cloneLast);
            $items.last().after(cloneFirst);
            $slider.css({'left' : -itemWidth}); // css 초기화
        } else {
            $slider.css({'left' : 0});
        }

        

        $.rollingOptions.status.size = $items.length;

        options.autoStart && carouselStart()
        options.flicking && flickingInit(options)
    }

    /**
     * 자동 rolling을 위해서 setInterval 지정해주는 함수
     */
    function carouselStart() {
        var options = $.rollingOptions;

        options.intervalTimer = setInterval(function(){
            move(options.viewTime, 'next', 0); // auto increment
        }, options.rollingTime);
    };

    /**
     * 자동 rolling 설정 시 버튼 이벤트를 통해서 rolling 일시 정지
     * options.restartTime 만큼 대기
     */
    function carouselStop() {
        var options = $.rollingOptions;

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
        
    };

    function flickingInit(_options) {
        var $elem = $(_options.carouselName);
        var options = _options
            , status = options.status
            , startX = 0
            , saveX = -itemWidth * (status.index-1)
            , movePosition = 0
            , itemWidth = $elem.find('li').width();

        $elem.on('touchstart', function(e) {
            if ( e.type === 'touchstart' && e.touches.length === 1 ) {
                startX = e.touches[ 0 ].pageX;
                saveX = parseInt($elem.css('left'));
                e.preventDefault();
            }
        });

        $elem.on('touchmove', function(e) {
            e.preventDefault();
            // $elem.css('transition-duration', '0ms');
            var drag = 0
                , scroll = 0;

            if ( e.type === 'touchmove' && e.touches.length === 1 ) {
                drag = e.touches[0].pageX - startX;
                movePosition = ( drag / itemWidth ) * 100;

                if(status.index === 1 && !options.circulation) {
                    // 첫번째 페이지에서 왼쪽으로 터치이벤트시 실행되지 않는다.
                    if(movePosition >= 0) return false;
                }
                else if(status.index === status.size && !options.circulation) {
                    // 마지막 페이지에서 오른쪽으로 터치이벤트시 실행되지 않는다.
                    if(movePosition <= 0) return false;
                }

                /**
                 * 현재 보여지는 페이지의 left 값을 가져와서 연산한다.
                 */
                if (Math.abs(drag) > Math.abs(scroll)) {

                    $elem.css({'left' : saveX + movePosition });
                    
                    e.preventDefault();
                } 
            }
        });

        $elem.on('touchend', function(e) {
            if ( e.type === 'touchend' && e.touches.length === 0 ) {

                if(status.index === 1 && !options.circulation) {
                    // 첫번째 페이지에서 왼쪽으로 터치이벤트시 실행되지 않는다.
                    if(movePosition >= 0) return false;
                }
                else if(status.index === status.size && !options.circulation) {
                    // 마지막 페이지에서 오른쪽으로 터치이벤트시 실행되지 않는다.
                    if(movePosition <= 0) return false;
                }
                
                if (Math.abs( movePosition ) > 40 ) {
                    if(movePosition < 0) { // next
                        move({
                            autoStart: false, 
                            circulation: false,
                            viewTime: 300,
                        }, 'next', movePosition);
                    } else { // prev
                        move({
                            autoStart: false, 
                            circulation: false,
                            viewTime: 300,
                        }, 'prev', movePosition);
                    }
                
                } else {
                    $elem.css({ 'left' : saveX }); // 초기화
                }

                startX = 0;
                movePosition = 0;

                e.preventDefault();
            }

            /**
             * TODO:: status update.... 
             */
            var $container = $('.figure_pagination');
            var $indexElem = $container.find('span.num:first');
            var $totalElem = $container.find('span.num.off');

            $indexElem.text(status.index);
            $totalElem.text(' / ' + status.size);
        });

    }


    function move(options, direction, swipe) {

        var extendsOptions = $.extend({}, $.rollingOptions, options)
        , options = extendsOptions
        , status = options.status
        , duration = options.viewTime;

        // autoStart == true 일 경우 carouselStop 호출
        options.autoStart && carouselStop();

        var $slider = $($.rollingOptions.carouselName);
        var $item = $slider.find('li');
        var itemWidth = $item.outerWidth();
        var leftIndent = parseInt($slider.css('left'));

        if(direction === 'prev') {

            // index가 0인데, circulation가 false 일 경우 순환 캐러샐이 아니기 때문에, 진행하지 않고 리턴
            if((status.index === 1) && !options.circulation) return false;

            $slider.filter(':not(:animated)').animate({ "left" : leftIndent + (itemWidth - parseInt(swipe)) }, duration, 
            function compldeted() {
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

            $slider.filter(':not(:animated)').animate({ "left" : leftIndent - (itemWidth + parseInt(swipe)) }, duration, 
            function compldeted() {
                options.circulation && $item.last().after($item.first());
                options.circulation && $slider.css({'left' : -itemWidth}); // 초기화
                !options.circulation && $slider.css({'left' : -itemWidth * (status.index-1)});

            });

            ++status.index;

            if(status.index > status.size) {
                status.index = 1;
            }
        }

        $.rollingOptions.status = status;

        return {
            index : $.rollingOptions.status.index,
            size : $.rollingOptions.status.size
        }
    }

})($);