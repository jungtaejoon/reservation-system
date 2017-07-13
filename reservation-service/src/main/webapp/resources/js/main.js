/**
 * 
 */
(function(window) {
	'use strict';

    // GLOBAL VALUE
    var TIMER = null;
    var CLICK_EVENT = null;
    
    /**
     * 
     * --------------------------------------------------------------------------------------
     * 프로모션 영역
     * PromotionCarousel
     * --------------------------------------------------------------------------------------
     * 
     */
    var PromotionCarousel = {

        option : {
            index : 0,
            size : 0,
            view_time: 1500,
            rolling_time: 2500,
            restart_time: 4000,
        },

        init : function() {
            this.bindEvents()
            this.carouselInit()
            this.carouselStart()
        },

        bindEvents : function() {
            $(".container_visual").on("click", ".prev_e", this.prevPromotion.bind(this));
            $(".container_visual").on("click", ".nxt_e, .nxt_fix", this.nextPromotion.bind(this));
        },

        carouselInit : function() {
            // 순환되는 캐러샐을 위해서 앞뒤로 마지막과 첫번째 슬라이드를 복제해서 넣는다.
            var cloneLast = $('.visual_img li:last').clone(true);
            var cloneFirst = $('.visual_img li:first').clone(true);

            $('.visual_img li:first').before(cloneLast);
            $('.visual_img li:last').after(cloneFirst);

            $('.visual_img').css({'left' : -338}); // 초기화
        },

        // Promotion Auto Rolling Carousel
        carouselStart : function() {
            TIMER = setInterval(function(){
                PromotionCarousel.promotionAnimation(PromotionCarousel.option.view_time, 'next'); // auto increment
            }, PromotionCarousel.option.rolling_time);
        },

        carouselStop : function() {
            TIMER != null && clearInterval(TIMER);

            // clear & reset timer
            clearTimeout(CLICK_EVENT);
            
            // 4초 아무 이벤트 없을 시 리스타트 캐러셀
            CLICK_EVENT = setTimeout(function() {    
                PromotionCarousel.carouselStart();
            }, PromotionCarousel.option.restart_time);
        },

        promotionAnimation : function(duration, direction) {
            var $item = $(".visual_img li")
            var $slider = $(".visual_img");
            var itemWidth = $item.outerWidth();
            
            if(direction === 'prev') {

                var leftIndent = parseInt($('ul.visual_img').css('left')) + itemWidth;

                $slider.filter(':not(:animated)').animate({ "left" : leftIndent }, duration, 
                function compldeted() {
                    // $('ul.visual_img').prepend($('.visual_img li:last')); // 차이점 ?
                    $('.visual_img li:first').before($('.visual_img li:last'));
                    $slider.css({'left' : -itemWidth}); // 초기화
                });
            } else {

                var leftIndent = parseInt($('ul.visual_img').css('left')) - itemWidth;

                $slider.filter(':not(:animated)').animate({ "left" : leftIndent }, duration, 
                function compldeted() {
                    // $('ul.visual_img').append($('.visual_img li:first')); 차이점 ?
                    $('.visual_img li:last').after($('.visual_img li:first'));
                    $slider.css({'left' : -itemWidth}); // 초기화

                });
            }
        },

        prevPromotion : function () {
            event.preventDefault();
            
            // 캐러샐 중지
            this.carouselStop();
            this.promotionAnimation(500, 'prev');

        },

        nextPromotion : function () {
            event.preventDefault();

            // 캐러샐 중지
            this.carouselStop();
            this.promotionAnimation(500, 'next');

        },

    };


    /**
     * 
     * --------------------------------------------------------------------------------------
     * 카테고리 
     * Category
     * --------------------------------------------------------------------------------------
     * 
     */

    var Category = {
        init : function () {
            this.categoryTemplate = Handlebars.compile($('#category-template').html());
            this.getAllCategories()
            this.bindEvents()
        },

        bindEvents : function () {
            $('ul.event_tab_lst').on('click', '.item', this.changeEventTab)
        },

        changeEventTab : function () {
            var $clickedTab = $(this);
            var categoryId = $clickedTab.data('category');

            // call & categoryId!
            var result = Products.getProductsByCategoryId.call(Products, categoryId);

            result.done(function(res) {
                // toggle button
                $('.event_tab_lst .item .anchor').removeClass('active');
                $clickedTab.find('.anchor').addClass('active');

                // rendering
                Products.rendering(res);
            });

            result.fail(function(err) {
                alert('현재 카테고리에 데이터가 없습니다.');
            })
        },

        getAllCategories : function () {
            var html = '';

            var result =  Common.ajaxWrapper.call(undefined, 'GET', '/categories', null);
            
            result.done(function(res) {
                if(res) {
                    res.forEach(function(item, i) {
                        item.active = '';
                        if(i === 0) item.active = 'active';
                        if(res.length-1 === i) item.active = 'last';
                    });
                    $('.event_tab_lst').html(Category.categoryTemplate(res));
                }
            });
        },
    }

    /**
     * 
     * --------------------------------------------------------------------------------------
     * 제품
     * Products
     * --------------------------------------------------------------------------------------
     * 
     */

    var Products = {
        data : {
            categoryId : 0,
            totalCount : 0,
            item : [],
        },

        init : function() {
            this.productTemplate = Handlebars.compile($('#product-template').html());
            this.bindEvents()
            this.initializingProducts()
        },

        bindEvents : function() {
            $('div.more').on('click', '.btn', this.getProductsByOffset.bind(this)); // 더보기 버튼
        },

        initializingProducts : function() {
            // 초기 데이터 받아오기
            var result = Common.ajaxWrapper.call(undefined, 'GET', '/products', null);
            
            result.done(function(res) {
                Products.rendering(res);
            });
        },

        getProductsByCategoryId : function(categoryId) {
            event.preventDefault();

            this.data.item = []; // === Products.data.item Reset data item
            this.data.categoryId = categoryId; // change categoryId

            // Category 에서 탭이 변경 될 때 .call을 통해서 호출
            // 카테고리별 initial products data ajaxWrapper
            return Common.ajaxWrapper.call(undefined, 'GET', '/products?cid=' + categoryId, null);

        },

        rendering : function(res) {

            // caching
            var leftSection = ''
                , rightSection = ''
                , $eventBox = $('.wrap_event_box ul')
                , $listText = $('.event_lst_txt .pink');

            // category Changed then clear inner product contents!
            // category Change method in Products.data.item = []; // reset!
            if(Products.data.item.length === 0) {
                Products.data.totalCount = res.totalCount;
                $eventBox.html('');
                $listText.text(res.totalCount + '개'); // update totalCount
            }

            if(res.products) {
                res.products.forEach(function(p, i) {
                    // data caching
                    Products.data.item.push(p);

                    if(i % 2 === 0) leftSection += Products.productTemplate(p);
                    else rightSection += Products.productTemplate(p);
                    
                });

                // 기존에 있는 데이터들도 있을 수 있기 때문에 append
                $($eventBox[0]).append(leftSection);
                $($eventBox[1]).append(rightSection);

                // 총 갯수와 현재 아이템 갯수를 비교해서 같아지면 모든 데이터를 받아온 것 이기 때문에 '더보기' 버튼 invisible
                // 또, product의 데이터가 홀수인 경우,
                if((res.totalCount === Products.data.item.length))
                    $('div.more .btn').addClass('invisible');
                else
                    $('div.more .btn').removeClass('invisible');
            }

        },

        getProductsByOffset : function() {
            
            var curItemCount = Products.data.item.length;
            var categoryId = Products.data.categoryId;

            // 10개씩 더불러오기. 현재의 아이템의 갯수가 offset이 되고, limit은 서버에 10으로 고정
            var getURL = '/products?cid=' + categoryId + '&offset=' + curItemCount;

            // 모든 데이터를 가지고 왔을 경우 Ajax 요청을 막는다.
            if(Products.data.totalCount > curItemCount) {
                var result = Common.ajaxWrapper.call(undefined, 'GET', getURL, null);

                result.done(function(res) {
                    Products.rendering(res);
                });

                result.fail(function(err) {
                    console.log('load productData failure');
                });

            } else {
                console.log('Already get All Products List');
            }
            
        },

    };


    /**
     * 
     * --------------------------------------------------------------------------------------
     * 공용
     * Common
     * --------------------------------------------------------------------------------------
     * 
     */

    var Common = {
        ajaxWrapper : function(method, url, data) {
            return $.ajax({
				contentType : 'application/json; charset=UTF-8',
				method : method,
				url : url,
				data : data,
				dataType : 'json',
			});
        },

        infiniteScroll : function(flag) {
            if(flag) {
                $(window).scroll(function() {
                    if ($(window).scrollTop() + 50 >= ($(document).height() - $(window).height())) {
                        Products.getProductsByOffset.apply();
                    }
                });
            }
        }
    }
	
    PromotionCarousel.init();
    Category.init();
    Products.init();
    Common.infiniteScroll(false); // true => infinite Scroll active!

})(window);