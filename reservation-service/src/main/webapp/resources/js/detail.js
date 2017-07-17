/**
 * 예약 상품 자세히 보기 js
 */
(function(window) {
	'use strict';

    var DetailProduct = {

        callback : {},
        Template : {},

        /**
         * 초기화 함수
         */
        init : function () {
            this.bindEvents();
            this.initialHandlebars();
            this.getProduct();
            this.getPreviewComments();
        },

        getProduct : function() {
            var url = '/api' + window.location.pathname;
            console.log(url);
            var result = this.ajaxWrapper('GET', url, null);

            result.then(function(res) {
                this.updateStatus(1, res.product.files.length);
                this.titleAreaRendering(res);
            }.bind(this));
        },

        getPreviewComments : function() {
            var url = '/api' + window.location.pathname + '/comments';
            console.log(url);
            var result = this.ajaxWrapper('GET', url, null);

            result.then(function(res) {
                this.previewCommentRendering(res);
            }.bind(this))
            .then(function() {
                //rolling
                this.callback = $('.visual_img').rolling({ 
                    autoStart: false, 
                    circulation: false,
                    flicking: true,
                    viewTime: 300,
                });

                console.log(this.callback);
            }.bind(this));
        },

        initialHandlebars : function() {
            /**
             * 상품 타이틀 영역
             */
            this.Template.image = Handlebars.compile($('#images_templ').html());
            this.Template.goto = Handlebars.compile($('#goto_templ').html());
            this.Template.content = Handlebars.compile($('#content_templ').html());
            this.Template.event = Handlebars.compile($('#event_templ').html());
            this.Template.confirmBtn = Handlebars.compile($('#btn_templ').html());

            /**
             * 예매자 한줄평
             */
            this.Template.comment = Handlebars.compile($('#comment_templ').html());


            /**
             * 하단 상세 설명
             */

        },

        titleAreaRendering : function(res) {
            var Templates = this.Template;
            var product = res.product;
            var statusText = this.setConfirmButton(product.salesEnd, product.salesFlag);

            $('.visual_img').append(Templates.image(product));
            $('.group_btn_goto').append(Templates.goto(product));
            $('.store_details').append(Templates.content(product));
            $('.section_event').append(Templates.event(product));
            $('.section_btn').append(Templates.confirmBtn(statusText));
        },

        previewCommentRendering : function(res) {
            var Templates = this.Template;
            console.log(res);
            $('.short_review_area').append(Templates.comment(res));
        },
        
        /**
         * 슬라이드 버튼 이벤트 바인딩
         */
        bindEvents : function () {
            $('.prev').on('click', this.prevProduct.bind(this));
            $('.nxt').on('click', this.nextProduct.bind(this));
            $('.section_store_details').on('click', '._open, ._close', this.contentMoretoggle.bind(this));
            $('.info_tab_lst').on('click', '._detail, ._path', this.changeInfoTab.bind(this))
        },

        /**
         * 이전 슬라이드 클릭
         * @param status : 슬라이드 이동간에 rotate
         */
        prevProduct : function () {
            var status = this.callback.prev();
            status && this.updateStatus(status.index, status.size);
        },

        /**
         * 다음 슬라이드 클릭
         */
        nextProduct : function () {
            var status = this.callback.next();
            status && this.updateStatus(status.index, status.size);
        },

        /**
         * 2.1 슬라이드 넘길 경우 슬라이드 위치 업데이트
         * @param index : 현재 이미지 슬라이드 위치
         * @param total : 총 이미지 슬라이드 갯수
         */
        updateStatus : function (index, size) {
            var $container = $('.figure_pagination');
            var $indexElem = $container.find('span.num:first');
            var $totalElem = $container.find('span.num.off');

            $indexElem.text(index);
            $totalElem.text(' / ' + size);

            this.toggleOff(index, size)
        },

        toggleOff : function(index, size) {
            // var $nextBtn = $('.nxt').find('i');
            var $prevBtn = $('.prev').find('i');

            if(index === 1) {
                !$prevBtn.hasClass('off') && $prevBtn.addClass('off')

                return false;
            }

            /**
             * 첫 이미지만 해당되는 것인가? 마지막 이미지에 대한 style.css 정의가 되어있지 않음
             * ico_arr6_rt.off 에 대한 opacity가 없음. 보류
             */ 
            /*
            if(index === size) {
                !$nextBtn.hasClass('off') && $nextBtn.addClass('off')
                // 
                return false;
            }
            */

            // $nextBtn.removeClass('off');
            $prevBtn.removeClass('off');
        },
        
        /**
         * 펼처보기 toggle
         */
        contentMoretoggle : function (e) {
            e.preventDefault();

            var $el = $(e.target);
            var $container = $el.closest('.section_store_details');
            var $content = $container.find('.store_details');
            var $openBtn = $container.find('._open');
            var $closeBtn = $container.find('._close');

            // 닫혀있음
            if($content.hasClass('close3')) {
                $openBtn.hide();
                $closeBtn.show();
            } else {
                $openBtn.show();
                $closeBtn.hide();
            }
            $content.toggleClass('close3');
        },

        /**
         * confirmButton statusText setting
         */
        setConfirmButton : function(endDate, flag) {
            var statusText = '예매하기';
            
            if(flag) statusText = '매진';
            this.isProductExpire(endDate) && (statusText = '판매 종료');

            return {
                statusText : statusText
            }
        },

        /**
         * Diff Date 
         * @param endDate : 만료 사간
         * @return [true] : 만료되지 않은 상품 , [false] : 만료된 상품
         */
        isProductExpire : function(endDate) {
            var end = new Date(endDate);
            var now = new Date();

            if(end < now) return true;
            else return false;
        },

        /**
         * 상세정보 / 오시는길 Tab 전환
         */
        changeInfoTab : function(e) {
            e.preventDefault();
            e.stopPropagation();

            var $ele = $(e.target);
            var $container = $ele.closest('.section_info_tab');
            var $infoTab = $container.find('._detail .anchor');
            var $pathTab = $container.find('._path .anchor');

            var $infoContent = $container.find('.detail_area_wrap');
            var $pathContent = $container.find('.detail_location');

            $infoTab.toggleClass('active');
            $pathTab.toggleClass('active');
            $infoContent.toggleClass('hide');
            $pathContent.toggleClass('hide');
        },

        ajaxWrapper : function(method, url, data) {
            return $.ajax({
				contentType : 'application/json; charset=UTF-8',
				method : method,
				url : url,
				data : data,
				dataType : 'json',
			});
        },
    };
    
    
    DetailProduct.init();

})(window);