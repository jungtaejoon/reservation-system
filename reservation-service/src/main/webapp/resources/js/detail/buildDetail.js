import jQuery from "jquery";

window.$ = jQuery;

var BuildDetail = (function () {
    var productId;

    function init() {
        productId = $('#container').data('product-id');
        bindEvents();
    }

    function bindEvents() {
        $('.section_store_details').on('click', '.bk_more', toggleMoreButton);
        $('.info_tab_lst .item').on('click', 'a.anchor', toggleTab);
        $('.bk_btn').on('click', makeReservation);
        $('a.btn_review_more').on('click', moreComments);
        $(window).on('scroll', lazyLoad);
    }

    function lazyLoad() {
        var $lazyLoadingTarget = $('img[data-lazy-image]');
        var currentScroll = $(document).scrollTop() + $(window).height();
        if ($lazyLoadingTarget.offset().top - currentScroll < 30) {
            $lazyLoadingTarget.prop('src', $lazyLoadingTarget.data('lazy-image'));
        }
    }

    function makeReservation() {
        var salesFlag = $(".bk_btn").data('sales-flag');
        if (salesFlag === 'SALE') {
            location.href = '/booking?productId=' + productId;
        } else {
            alert('매진입니다.');
        }
    }

    function toggleMoreButton() {
        $('.store_details').toggleClass('close3');
        $('.bk_more').toggleClass('invisible');
    }

    function toggleTab(e) {
        if (!$(e.currentTarget).hasClass('active')) {
            $('.info_tab_lst a').toggleClass('active');
            $('div.detail_common').toggleClass('hide');
        }
    }
    
    function moreComments() {
        location.href = '/comment-read?productId=' + productId;
    }

    return {
        init: init
    }
})();

export {BuildDetail};