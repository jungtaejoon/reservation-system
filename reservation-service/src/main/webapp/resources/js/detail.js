/**
 * 예약 상품 자세히 보기 js
 */
(function(window) {
	'use strict';

    var DetailProduct = {

        Template : {},
        comments : [],
        mainSlider : null,
        popupSlider : null,


        init : function () {
            this.bindEvents();
            this.initialHandlebars();
            this.getProduct();
            this.getPreviewComments();

            this.mainSlider = Flicking.setup();
            this.popupSlider = Flicking.setup();
        },

        
        bindEvents : function () {
            $('.section_store_details').on('click', '._open, ._close', this.contentMoreToggle.bind(this));
            $('.info_tab_lst').on('click', '._detail, ._path', this.changeInfoTab.bind(this));
            $('.short_review_area').on('click', '.thumb', this.openPhotoViewer.bind(this));
            $('.popup').on('click', 'label', this.closePhotoViewer.bind(this));
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
            this.Template.photoViewer = Handlebars.compile($('#comment_photo_templ').html());

            /**
             * 하단 상세 설명
             */
            this.Template.info = Handlebars.compile($('#info_templ').html());
            this.Template.path = Handlebars.compile($('#path_templ').html());
            
        },


        getProduct : function() {
            var url = '/api' + window.location.pathname;
            var result = this.ajaxWrapper('GET', url, null);

            result.then(function(res) {

                DetailProduct.updateMainStatus(1, res.product.files.length);
                DetailProduct.titleAreaRendering(res);
                DetailProduct.detailInfoRendering(res.product);

            }).then(function initFlickingSlider(res){

                var $slider = $('.visual_img');
                var imageCount = $slider.find('li').length;

                DetailProduct.mainSlider.init({
                    autoStart: false, 
                    circulation: false,
                    flicking: true,
                    viewTime: 300,
                    slider : '.visual_img',
                    buttonContainer : '.group_visual',
                    updateState : DetailProduct.updateMainStatus,
                    status: {
                        size: imageCount,
                        index: 1,
                    }
                })

            });
        },


        getPreviewComments : function() {
            var url = '/api' + window.location.pathname + '/comments';
            var result = this.ajaxWrapper('GET', url, null);

            result.then(function(res) {
                DetailProduct.comments = res.comments;
                DetailProduct.previewCommentRendering(res);
            });
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


        detailInfoRendering : function(product) {
            var Templates = this.Template;

            $('.detail_info_group').prepend(Templates.info(product));
            $('.box_store_info').append(Templates.path(product));

            NaverMap.init();
        },


        previewCommentRendering : function(res) {
            var Templates = this.Template;
            var rating = (res.total.average / 5.0) * 100;
            var $commentContainer = $('.short_review_area');

            $commentContainer.append(Templates.comment(res));
            
            // comment total rating (%)
            $('.graph_value').css('width', rating + '%');
        },


        updateMainStatus : function (index, size) {
            var $container = $('.figure_pagination');
            var $indexElem = $container.find('span.num:first');
            var $totalElem = $container.find('span.num.off');

            $indexElem.text(index);
            $totalElem.text(' / ' + size);

            // this.toggleOff(index, size)
        },


        updatePreviewStatus : function (index, size) {
            var $container = $('.preview_center');
            var $indexElem = $container.find('span.index');
            var $totalElem = $container.find('span.size');

            $indexElem.text(index);
            $totalElem.text(size);
        },


        toggleOff : function(index, size) {
            var $prevBtn = $('.prev').find('i');

            if(index === 1) {
                !$prevBtn.hasClass('off') && $prevBtn.addClass('off')

                return false;
            }

            $prevBtn.removeClass('off');
        },
        
        
        /**
         * 펼처보기 toggle
         */
        contentMoreToggle : function (e) {
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

            if($ele.closest('li').hasClass('active')) return false;

            else {
                $container.find('li').removeClass('active');
                $ele.closest('li').addClass('active');

                if($ele.closest('li').hasClass('_detail')) {
                    $infoTab.addClass('active');
                    $pathTab.removeClass('active');
                    $infoContent.removeClass('hide');
                    $pathContent.addClass('hide');
                    
                } else { // map setting
                    $infoTab.removeClass('active');
                    $pathTab.addClass('active');
                    $infoContent.addClass('hide');
                    $pathContent.removeClass('hide');
                }
            }

        },


        /**
         * Popup 형식의 사진 뷰어 ( 댓글 단 사람들의 사진 ) Open
         */
        openPhotoViewer : function(e) {
            e.preventDefault();

            var Templates = this.Template;
            var cid = $(e.target).data('cid');
            
            var $photoViewer = $('#photoviewer');
            var $photoList = $('.photo_list');

            var filteredComment = this.comments.filter(function(comment, i) {
                if(comment.cid === cid) return comment
            });

            var comment = filteredComment[0];
            var imageCount = comment.images.length;

            $photoList.append(Templates.photoViewer(comment.images));
            DetailProduct.updatePreviewStatus(1, imageCount);

            DetailProduct.popupSlider.init({
                slider : '.photo_list',
                buttonContainer : '.popup',
                updateState : DetailProduct.updatePreviewStatus,
                autoStart: false, 
                circulation: false,
                flicking: true,
                viewTime: 300,
                status: {
                    size: imageCount,
                    index: 1,
                }
            });

            $photoViewer.show();
        },


        /**
         * PhotoViewer Close
         */
        closePhotoViewer : function(e) {
            e.preventDefault();

            $('#photoviewer').hide();
            $('.photo_list li').remove();
            $('.photo_list').css('left' , 0);

            DetailProduct.popupSlider.clear();
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


    function ImageLazyLoad() {
        var $window = $(window);

        $window.scroll(function() {
            $.each($('img'), function() {
                if ( $(this).data('lazy-image') && $(this).offset().top < ($window.scrollTop() + $window.height() + 100) ) {
                    var source = $(this).data('lazy-image');
                    $(this).attr('src', source);
                    $(this).removeAttr('data-lazy-image');
                }
            })
        });
    }
    
    ImageLazyLoad();
    DetailProduct.init();

})(window);