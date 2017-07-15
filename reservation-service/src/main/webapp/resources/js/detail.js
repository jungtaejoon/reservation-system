/**
 * 예약 상품 자세히 보기 js
 */
(function(window) {
	'use strict';

    var DetailProduct = {

        callback : {},

        /**
         * 초기화 함수
         */
        init : function () {
            this.bindEvents();

            //rolling
            this.callback = $('.visual_img').rolling({ 
                autoStart: false, 
                circulation: false,
                flicking: true,
                viewTime: 300,
            });

            console.log(this.callback);

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
         * @param status : 슬라이드 이동간에 rotate
         */
        prevProduct : function () {
            var status = this.callback.prev();
            status && this.updateIndex(status.index, status.size);
        },

        /**
         * 다음 슬라이드 클릭
         */
        nextProduct : function () {
            var status = this.callback.next();
            status && this.updateIndex(status.index, status.size);
        },

        /**
         * 2.1 슬라이드 넘길 경우 슬라이드 위치 업데이트
         * @param index : 현재 이미지 슬라이드 위치
         * @param total : 총 이미지 슬라이드 갯수
         */
        updateIndex : function (index, size) {
            var $container = $('.figure_pagination');
            var $indexElem = $container.find('span.num:first');
            var $totalElem = $container.find('span.num.off');

            $indexElem.text(index);
            $totalElem.text(' / ' + size);
        }
    }
    
    DetailProduct.init();

})(window);