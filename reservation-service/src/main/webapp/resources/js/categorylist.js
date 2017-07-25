var CATEGORY_LIST = (function(){
    'use strict'

    const BASE_URL = 'http://localhost:8080';

    var $ul_lst_event_boxes = $('ul.lst_event_box');

    var currentCategoryId = 0;
    var lastProductId;

    var apiUrl = "/api/products";

    var scrollFlag = true;

    // productList 추가
    var appendProductList = function (product_list){
        $.each(product_list, function(index, product){
            lastProductId = product.id;
            var template = Handlebars.templates.product(product);
            if(index%2 === 0){
                $($ul_lst_event_boxes[0]).append(template);
            } else {
                $($ul_lst_event_boxes[1]).append(template);
            }
        })
    };

    var viewProductByCategory = function(event){
        // active 클래스 제거 및 추가
        $(this).parent().find('.active').removeClass('active');
        $(this).find('a').addClass('active');

        $ul_lst_event_boxes.find('li').remove(); // 프로덕트 리스트 초기화

        currentCategoryId = $(this).data('category');
        if(currentCategoryId !== 0){
            apiUrl = apiUrl + "/" + currentCategoryId;
        }
        $.ajax({
            url: apiUrl,
            type: 'GET',
            contentType: 'application/json; charset=UTF-8'
        }).done(function(result){
            if(result.length !== 0){
                appendProductList(result);
            } else {
                alert('상품 정보가 없습니다.');
            }
        })
    };

    var viewMoreProductList = function(event){
        if(currentCategoryId !== 0){
            apiUrl = apiUrl + "/" + currentCategoryId;
        }
        $.ajax({
            url: apiUrl + "/more/" + lastProductId,
            type: 'GET',
            contentType: 'application/json'
        })
            .done(function(result){
                if(result.length !== 0){
                    appendProductList(result);
                } else {
                    //alert('더보기 결과가 없습니다.');
                }
                scrollFlag = true;
            })
            .fail(function(){
            });
    };

    var updateCount = function(event){
        currentCategoryId = $(this).data('category');
        if(currentCategoryId !== 0){
            apiUrl = apiUrl + "/" + currentCategoryId;
        }
        $.ajax({
            url: apiUrl + "/count",
            type: 'GET',
            contentType: 'application/json; charset=UTF-8'
        }).done(function(result){
            $('div.section_event_lst span.pink').text(result);
        })
    };

    var scrollViewMoreProductList = function(){
        var timer;
        var docTop = Math.round($(document).scrollTop());
        var docHeight = $(document).height();
        var winHeight = $(window).height();
        if(scrollFlag && docTop === docHeight - winHeight){
            scrollFlag = false;
            viewMoreProductList(event);
        }
    };

    var moveProductDetail = function moveProductDetail(event){
        event.preventDefault();
        event.stopPropagation();

        var id = $(this).data('id');
        var categoryId = $(this).data('categoryid');
        var categoryId = $(this).data('categoryId');
        var url = BASE_URL + '/products/' + categoryId + '/product/' + id;
        window.location.href = url;
    }

    var init = function (){
        $('ul.event_tab_lst').on('click', 'li.item', viewProductByCategory);
        $('ul.event_tab_lst').on('click', 'li.item', updateCount);
        $('ul.lst_event_box').on('click', 'li.item', moveProductDetail);

        // 처음에 전체 리스트 출력하도록
        $('li.item:first-child').trigger('click');

        // 더보기 이벤트 추가
        $('div.more > button.btn').on('click', viewMoreProductList);

        $(window).on("scroll", scrollViewMoreProductList);
    }

    return {
        init : init
    }
})();

$(document).ready(function(){
    CATEGORY_LIST.init();
})
