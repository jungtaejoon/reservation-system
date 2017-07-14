/**
 * 
 * --------------------------------------------------------------------------------------
 * 프로모션 영역
 * Carousel
 * --------------------------------------------------------------------------------------
 * 
 */
var Carousel = {

    /**
     * Default Options Object
     * @param viewTime : 슬라이드 애니메이션 시간
     * @param rollingTime : 슬라이드 자동 넘어가는 시간
     * @param restartTime : 슬라이드 재시작 대기 시간
     * @param autoStart : 슬라이드 자동 시작 여부
     * @param carouselName : 슬라이드 클래스 및 아이디 이름
     * @param intervalTimer : setInterval 변수
     * @param clickTimer : setTimeout 변수
     */
    options : {
        viewTime: 500,
        rollingTime: 2000,
        restartTime: 2000,
        autoStart: true,
        carouselName : '.visual_img',
        intervalTimer : null,
        clickTimer : null,
    },

    /**
     * Status 관리 Object
     * @param index : 현재 슬라이드 위치
     * @param size  : 슬라이드 총 갯수
     */
    status : {
        index : 1,
        size : 0,
    },

    /**
     * @param options : Carousel.init({options}) 할때에 옵션 Object 넘어온 변수들만 자동 할당
     */
    initOptions : function(options) {
        if(typeof options === "object" 
            && Object.keys(options).length > 0) {

            options.viewTime && (this.options.viewTime = options.viewTime)
            options.rollingTime && (this.options.rollingTime = options.rollingTime)
            options.restartTime && (this.options.restartTime = options.restartTime)
            options.carouselName != null && !options.carouselName && (this.options.carouselName = options.carouselName)
            options.autoStart != null && !options.autoStart && (this.options.autoStart = options.autoStart)
        }
    },

    /**
     * 최초 한번 실행 initializing 함수
     * @param options : Carousel.init({options}) 초기 설정 시 부여하는 options Object
     */
    init : function(options) {
        this.initOptions(options)
        this.carouselInit()
        this.options.autoStart && this.carouselStart()
    },

    /**
     * 캐러샐 순환 형식 적용 
     * 순환되는 캐러샐을 위해서 앞뒤로 마지막과 첫번째 슬라이드를 복제해서 넣는다.
     */
    carouselInit : function() {
        var $slider = $(this.options.carouselName);
        var $items = $slider.find('li');

        var itemWidth = $items.outerWidth();
        var cloneLast = $items.last().clone(true);
        var cloneFirst = $items.first().clone(true);

        $items.first().before(cloneLast);
        $items.last().after(cloneFirst);

        $slider.css({'left' : -itemWidth}); // css 초기화
        this.status.size = $items.length;
    },

    /**
     * 자동 rolling을 위해서 setInterval 지정해주는 함수
     */
    carouselStart : function() {
        this.options.intervalTimer = setInterval(function(){
            Carousel.promotionAnimation(Carousel.options.viewTime, 'next'); // auto increment
        }, this.options.rollingTime);
    },

    /**
     * 자동 rolling 설정 시 버튼 이벤트를 통해서 rolling 일시 정지
     * options.restartTime 만큼 대기
     */
    carouselStop : function() {
        this.options.intervalTimer != null 
        && clearInterval(this.options.intervalTimer);

        // clear & reset timer
        clearTimeout(this.options.clickTimer);
        

        if(this.options.autoStart) {
            // 4초 아무 이벤트 없을 시 리스타트 캐러셀
            this.options.clickTimer = 
            setTimeout(function() {    
                Carousel.carouselStart();
            }, this.options.restartTime);
        }
        
    },

    /**
     * 실제 rolling시에 슬라이드 넘어가는 애니메이션 작동 함수 
     * 
     * @param duration : 애니메이션 작동 시간
     * @param direction : 왼쪽('prev'), 오른쪽('next') 구분
     * @return Promise Object : 현재의 Carousel 상태를 저장한 status 반환
     */
    promotionAnimation : function(duration, direction) {
        
        // autoStart == true 일 경우 carouselStop 호출
        this.options.autoStart && this.carouselStop();

        var $slider = $(this.options.carouselName);
        var $item = $slider.find('li');
        var itemWidth = $item.outerWidth();
        var leftIndent = parseInt($slider.css('left'));

        if(direction === 'prev') {

            $slider.filter(':not(:animated)').animate({ "left" : leftIndent + itemWidth }, duration, 
            function compldeted() {
                $item.first().before($item.last());
                $slider.css({'left' : -itemWidth}); // 초기화
            });

            --this.status.index;

            if(this.status.index <= 0) {
                this.status.index = this.status.size;
            }

        } else {

            $slider.filter(':not(:animated)').animate({ "left" : leftIndent - itemWidth }, duration, 
            function compldeted() {
                $item.last().after($item.first());
                $slider.css({'left' : -itemWidth}); // 초기화
            });

            ++this.status.index;

            if(this.status.index > this.status.size) {
                this.status.index = 1;
            }
        }

        return new Promise(function(resolve, reject) {
            resolve(this.status);
        }.bind(this));
    },
};