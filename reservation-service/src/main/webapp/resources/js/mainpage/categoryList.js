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
        
        // Q. data로 입력할 때 값이 변경은 되어 사용은 할 수 있지만 DOM에는 반영이 되지 않아서 의아했습니다. 원래 그런 건가요.
        $('.event_tab_lst li[data-category="0"]').data('product-count', productTotalCount);
        $('.event_lst_txt .pink').text(productTotalCount+'개');
        $('ul.event_tab_lst').append(template({items:res}));
        ProductList.init();
    }
    return {
        init: init
    }
})();
