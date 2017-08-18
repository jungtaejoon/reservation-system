import {CachedAjax} from "../cachedAjax";
import {Date} from "../dateFormat";

var ReviewList = (function () {
    var template = require('./review-more-load-template.html');
    var page;
    var productId;
    var productName;
    var count;
    var maxHeight;
    var currentScroll

    function init() {
        template = require('./review-more-load-template.html');
        page = 1;
        productId = $('#container').data('product-id');
        productName = $('a.title').text();
        count = parseInt($('em.green').text().replace('개', ''));
        bindEvents();
    }

    function bindEvents() {
        $('div.top_title').on('click', () => history.back());
        $(window).scroll(scrollUpdate);
    }

    function scrollUpdate() {
        if (count <= page * 10) {
            return;
        }
        maxHeight = $(document).height();
        currentScroll = $(document).scrollTop() + $(window).height();
        if (maxHeight - currentScroll < 30) {
            CachedAjax.get('/comments?productId=' + productId + '&page=' + page++).then(appendMoreComments);
        }
    }

    function appendMoreComments(res) {
        res.map((v) => {
            v['productName'] = productName;
            v['createDate'] = new Date(v['createDate']).format('yyyy.MM.dd');
            v['score'] = v['score'].toFixed(1);
        });
        var obj = {items: res};
        $('ul.list_short_review').append(template(obj));
    }

    return {
        init: init
    }
})();

export {ReviewList};