var ProductList = (function() {
    var productTotalCount = 0;
    var categoryId = 0;
    var pageNum = 0;
    var template;
    function init() {
        bindEvents();
        template = Handlebars.compile($('#product_list_template').html());
        getProductList('html');
    }
    function bindEvents() {
        $('ul.event_tab_lst').on('click', 'li.item', clickCategoryEvent);
        $(window).scroll(scrollUpdate);
    }
    function clickCategoryEvent(e){
        pageNum = 0;
        $('li.item a.active').removeClass('active');
        $(e.currentTarget).find('a').addClass('active');
        $('.event_lst_txt .pink').text($(e.currentTarget).data('product-count')+'개');
        categoryId = $(e.currentTarget).data('category');
        getProductList('html');
    }
    function getProductList(type) {
        productTotalCount = parseInt($('.event_lst_txt .pink').text().replace('개', ''));
        var url = '/products?page='+pageNum+'&categoryId='+categoryId;
        CachedAjax.get(url).then(appendProduct.bind(this, type));
    }
    function appendProduct(type, res) {
        var left = [];
        var right = [];
        for(var i = 0, l = res.length; i < l; i++) {
            if(i%2) {
                right.push(res[i]);
            } else {
                left.push(res[i]);
            }
        }
        $('.lst_event_box.left_box')[type](template({products:left}));
        $('.lst_event_box.right_box')[type](template({products:right}));
        if(productTotalCount > (pageNum+1)*10){
            $('.more .btn').removeClass('invisible');
        } else {
            $('.more .btn').addClass('invisible');
        }
    }
    function scrollUpdate(e){
        var maxHeight = $(document).height();
        var currentScroll = $(document).scrollTop() + $(window).height();
        if(maxHeight - currentScroll < 30){
            pageNum++;
            if(productTotalCount > pageNum*10){
                getProductList('append');
            }
        }
    }
    return {
        init: init
    }
})();