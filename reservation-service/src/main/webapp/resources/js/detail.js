/**
 * 예약 상품 자세히 보기 js
 */
(function(window) {
	'use strict';

    var DetailProduct = {

        /**
         * 초기화 함수
         */
        init : function () {
            Carousel.init({
                autoStart: false,
                carouselName : '.visual_img',
            });

            this.bindEvents();
        },
        
        /**
         * 슬라이드 버튼 이벤트 바인딩
         */
        bindEvents : function () {
            $('.prev').on('click', this.prevProduct.bind(this));
            $('.nxt').on('click', this.nextProduct.bind(this));
        },

        /**
         * 이전 슬라이드 클릭
         */
        prevProduct : function () {
            var result = Carousel.promotionAnimation(500, 'prev');
            
            result.then(function(status) {
                this.updateIndex(status.index, status.size);
            }.bind(this));
        },

        /**
         * 다음 슬라이드 클릭
         */
        nextProduct : function () {
            var result = Carousel.promotionAnimation(500, 'next');
            
            result.then(function(status) {
                this.updateIndex(status.index, status.size);
            }.bind(this));
        },

        /**
         * 2.1 슬라이드 넘길 경우 슬라이드 위치 업데이트
         * @param index : 현재 이미지 슬라이드 위치
         * @param total : 총 이미지 슬라이드 갯수
         */
        updateIndex : function (index, total) {
            var $container = $('.figure_pagination');
            var $indexElem = $container.find('span.num:first');
            var $totalElem = $container.find('span.num.off');

            $indexElem.text(index);
            $totalElem.text(' / ' + total);
        }
    }
    
    DetailProduct.init();

})(window);