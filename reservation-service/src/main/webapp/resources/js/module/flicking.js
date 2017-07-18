/*!
 * jQuery namespaced 'Starter' plugin boilerplate
 * Author: @dougneiner
 * Further changes: @addyosmani
 * Licensed under the MIT license
 */

;(function ( $ ) {
    if (!$.et) {
        $.et = {};
    }

    $.et.flicking = function ( el, param, options ) {
        // To avoid scope issues, use 'base' instead of 'this'
        // to reference this class from internal events and functions.
        var base = this;

        // Access to jQuery and DOM versions of element
        base.$el = $(el);
        base.el = el;

        // Add a reverse reference to the DOM object
        base.$el.data( "et.rolling" , base );

        base.init = function (options) {
            base.param = param;

            base.eventBinding();

            base.options = $.extend({},
            $.et.flicking.defaultOptions, options);

            var options = base.options;
            var $slider = base.$el;
            var $items = $slider.find('li');
            var itemWidth = $items.width();

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

            base.options.status.size = $items.length;

            options.autoStart && base.carouselStart()
            options.flicking && base.flickingInit()
            // Put your initialization code here
        };

        base.eventBinding = function() {
            var param = base.param;

            (param.prev) && param.prev.on('click', base.move.bind(this, 'prev', 0));
            (param.next) && param.next.on('click', base.move.bind(this, 'next', 0));
        };

        base.carouselStart = function() {
            var options = base.options;

            options.intervalTimer = setInterval(function(){
                base.move(options.viewTime, 'next', 0); // auto increment
            }, options.rollingTime);
        };

        base.carouselStop = function() {
            var options = base.options;

            options.intervalTimer != null 
            && clearInterval(options.intervalTimer);

            // clear & reset timer
            clearTimeout(options.clickTimer);
            

            if(options.autoStart) {
                // 4초 아무 이벤트 없을 시 리스타트 캐러셀
                options.clickTimer = setTimeout(function() {    
                    base.carouselStart();
                }, options.restartTime);
            }
        }

        base.flickingInit = function() {
            var options = base.options;
            var $elem = base.$el
            var status = options.status
            var startX = 0
            var movePosition = 0
            var itemWidth = $elem.find('li').width()
            var saveX = -itemWidth * (status.index-1);
                
            $elem.on('touchstart', function(e) {
                if ( e.type === 'touchstart' && e.touches.length === 1 ) {
                    startX = e.touches[ 0 ].pageX;
                    saveX = parseInt($elem.css('left'));
                    e.preventDefault();
                }
            });

            $elem.on('touchmove', function(e) {
                e.preventDefault();
                var drag = 0;
                var scroll = 0;

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
                            base.move('next', movePosition);
                        } else { // prev
                            base.move('prev', movePosition);
                        }
                    
                    } else {
                        $elem.css({ 'left' : saveX }); // 초기화
                    }

                    startX = 0;
                    movePosition = 0;

                    e.preventDefault();
                }

                
            });
        }

        base.move = function(direction, swipe) {
            var extendsOptions = base.options;
            var options = extendsOptions
            var status = options.status
            var duration = options.viewTime;

            // autoStart == true 일 경우 carouselStop 호출
            options.autoStart && base.carouselStop();

            var $slider = base.$el;
            var $item = $slider.find('li');
            var itemWidth = $item.width();
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

            base.options.status = status;
            
            // 플러그인 설정할 때 넘겨 받은 param callback update Status
            base.param.updateState(status.index, status.size);
        },

        base.init(options);
    };

    $.et.flicking.defaultOptions = {
        viewTime: 500,
        rollingTime: 2000,
        restartTime: 2000,
        autoStart: true,
        circulation : true,
        flicking : false,
        direction : 'next',             // require [autoStart = true]
        carouselName : '',
        intervalTimer : null,
        clickTimer : null,
        status : {
            index : 1,
            size : 0,
        },
    };

    $.fn.Flicking = function( param, options ) {
        return this.each(function () {
            (new $.et.flicking(this, param, options));
        });
    };

})( $ );