var BuildDetail = (function() {
    function init() {
        bindEvents();
    }
    function bindEvents() {
        $('.section_store_details').on('click', '.bk_more', toggleMoreButton);
        $('.info_tab_lst .item').on('click', 'a.anchor', toggleTab);
        $('.bk_btn').on('click', makeReservation);
        $(window).on('scroll', lazyLoad);
    }
    function lazyLoad() {
        var lazyLoadingTarget = $('img[data-lazy-image]');
        var currentScroll = $(document).scrollTop() + $(window).height();
        if(lazyLoadingTarget.offset().top - currentScroll < 30) {
            lazyLoadingTarget.prop('src', lazyLoadingTarget.data('lazy-image'));
        }
    }
    function makeReservation() {
        var productId = $('#container').data('product-id');
        var salesFlag = $(".bk_btn").data('sales-flag');
        if(salesFlag === 'SALE'){
            location.href='/reservation?productId='+productId;
        }else{
            alert('매진입니다.')
        }
    }
    function toggleMoreButton() {
        $('.store_details').toggleClass('close3');
        $('.bk_more').toggleClass('invisible');
    }
    function toggleTab(e) {
        if(!$(e.currentTarget).hasClass('active')) {
            $('.info_tab_lst a').toggleClass('active');
            $('div.detail_common').toggleClass('hide');
        }
    }
    return {
        init: init
    }
})();