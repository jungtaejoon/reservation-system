var CategoryList = (function() {
    var template;
    var productTotalCount;
    function init() {
        template = Handlebars.compile($('#category_list_template').html());
        CachedAjax.ajax('/categories').then(appendCategory);
    }
    function appendCategory(res) {
        productTotalCount = res.reduce(function add(acc, value) {
            return acc + value.productCount;
        }, 0);
        // Q. data('product-count')로 하면 값변경이 안됨
        $('.event_tab_lst li[data-category="0"]').attr('data-product-count', productTotalCount);
        $('.event_lst_txt .pink').text(productTotalCount+'개');
        $('ul.event_tab_lst').append(template({items:res}));
        ProductList.init();
    }
    return {
        init: init
    }
})();
