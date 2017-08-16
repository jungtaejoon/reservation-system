import {CachedAjax} from "../cachedAjax";
import {ProductList} from "./productList";
import jQuery from "jquery";

window.$ = jQuery;

var CategoryList = (function () {
    var template;
    var productTotalCount;

    function init() {
        template = require('./category-list-template.html');
        CachedAjax.get('/categories').then(appendCategory);
    }

    function appendCategory(res) {
        productTotalCount = res.reduce(function add(acc, value) {
            return acc + value.productCount;
        }, 0);
        $('.event_tab_lst li[data-category="0"]').data('product-count', productTotalCount);
        $('.event_lst_txt .pink').text(productTotalCount + '개');
        $('ul.event_tab_lst').append(template({items: res}));
        ProductList.init();
    }

    return {
        init: init
    }
})();
export {CategoryList};