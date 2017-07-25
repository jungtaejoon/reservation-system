const baseUrl = window.location.origin;
const naverAllowedUrl = "http://127.0.0.1:8080";
var pathName = window.location.pathname;
var productId = $('body').data('id');
var apiUrl = baseUrl + "/api" + pathName;

$(function(){
    DETAIL.init();
    COMMENT.init();
});

var DETAIL = (function(AutoSlidingModule){
    var $group_visual = $('div.group_visual');
    var $btn_pre = $group_visual.find('a.btn_prev');
    var $btn_nxt = $group_visual.find('a.btn_nxt');
    var $sliding_ul = $('ul.visual_img');	// 프로모션 영역 ul
    var items_length;

    var $section_store_details = $("div.section_store_details");

    var page_num;

    var product_detail;

    var init = function () {
        loadTitle();
        requestProductDetail();
        toggleDetailContent();
        //<div class="section_btn"> <button type="button" class="bk_btn"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </button> </div>
        $('.section_btn > .bk_btn').click(goToReserv);
    }

    var goToReserv = function (evt) {
        window.location.href = baseUrl + "/reserving" + pathName;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    var loadTitle = function (){
        $.ajax({
            url: apiUrl + "/images",
            type: 'GET'
        }).done(function(product_images){
            if(product_images.length === 1) {
                hideElement($('div.prev>div[class$="_inn"],div.nxt>div[class$="_inn"]'));
            }
            if(product_images.length >= 1){
                updateGroupBtnGoto(product_images[0].displayInfo);
            }
            appendTitleList(product_images);
        }).then(bindSlideEvents).then(initPaginationNum)
            .fail(function(){
                console.log("failed");
            })
    }

    var appendTitleList = function (product_images){
        $.each(product_images, function(index, product_image){
            var template = Handlebars.templates['productDetailTitleTemplate'](product_image);
            $sliding_ul.append(template);
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    var requestProductDetail = function (){
        $.ajax({
            url: apiUrl,
            type: "GET"
        }).then(updateProductDetail)
            .then(changeSalesStat)
    }

    var failed = function (error){
        console.log(error);
    }

    var updateProductDetail = function(productDetail){
        $section_store_details.find('p.dsc').text(productDetail.content);
        $('div.section_event').html(Handlebars.templates['eventInfo'](productDetail));
        return productDetail;
    }

    var changeSalesStat = function (productDetail){
        if(Date.now() > productDetail.salesEnd){
            $('button.bk_btn span').text("판매종료");
        } else if(productDetail.salesFlag){
            $('button.bk_btn span').text("매진");
        }
    }

    var hideElement = function (ele){
        ele.addClass('hide');
    }

    var showElement = function (ele){
        ele.removeClass('hide');
    }

    var bindSlideEvents = function (){
        if(AutoSlidingModule !== undefined){
            AutoSlidingModule.init(false);

            $group_visual.on("click", 'a.btn_prev',function(event){
                event.preventDefault();
                event.stopPropagation();
                if(!$sliding_ul.hasClass("active")){
                    AutoSlidingModule.prevSliding();
                    page_num = AutoSlidingModule.getSlidingIdx();
                    updatePaginationNum(page_num);
                    if(page_num !== 1){
                        hideElement($('div.visual_txt'));
                    } else {
                        showElement($('div.visual_txt'));
                    }
                }
            });

            // 오토 슬라이딩을 멈추고 우측으로 슬라이딩
            $group_visual.on("click", 'a.btn_nxt', function(event){
                event.preventDefault();
                event.stopPropagation();
                if(!$sliding_ul.hasClass("active")){
                    AutoSlidingModule.nextSliding();
                    page_num = AutoSlidingModule.getSlidingIdx();
                    updatePaginationNum(page_num);
                    if(page_num !== 1){
                        hideElement($('div.visual_txt'));
                    } else {
                        showElement($('div.visual_txt'));
                    }
                }
            });
        }
    }

    var initPaginationNum = function (){
        items_length = $sliding_ul.find('li.item').length;
        if(items_length !== 0){
            $('div.pagination > div.figure_pagination > span.num.off > span').text(items_length);
            $('div.pagination > div.figure_pagination > span.num:first-child').text(AutoSlidingModule.getSlidingIdx());
        }
    }

    var updatePaginationNum = function (pageNum){
        $('div.pagination > div.figure_pagination > span.num:first-child').text(pageNum);
    }

    var updateGroupBtnGoto = function (display_info){
        $('div.group_btn_goto > a.btn_goto_home').attr("href", display_info.homepage);
        $('div.group_btn_goto > a.btn_goto_tel').attr("href","tel:" + display_info.tel);
        $('div.group_btn_goto > a.btn_goto_mail').attr("href","mailto:" + display_info.email);
        var goto_path = naverAllowedUrl + pathName + "/map?address=" + display_info.placeStreet;
        $('div.group_btn_goto > a.btn_goto_path').attr("href", goto_path);
        $('div.group_btn_goto > a.btn_goto_share').click(share);
    }

    var share = function (event) {
        event.preventDefault();
        event.stopPropagation();
        var url = encodeURI(encodeURIComponent(document.location.href));
        var title = encodeURI("공유하기");
        var shareURL = "http://share.naver.com/web/shareView.nhn?url=" + url + "&title=" + title;
        window.open(shareURL, "share_naver", "width=410, height=500, resizable=no");
    }

    var toggleDetailContent = function (){
        $("a.bk_more").click(function(event) {
            event.preventDefault();
            event.stopPropagation();

            $("a.bk_more").toggle();

            var $store_details = $("div.store_details");
            if($store_details.hasClass('close3')){
                $store_details.removeClass('close3');
            } else {
                $store_details.addClass('close3');
            }
        });
    }

    return {
        init: init
    }
})(AUTO_SLIDNG_MODULE);

var COMMENT = (function(){
    function init(){
        requestComment();
        $('.btn_review_more').click(goReviewPage);
        $('.list_short_review').on("click", '.review_area:not(.no_img) > .thumb_area > .thumb', ajaxCommentImage);
    }

    var ajaxCommentImage = function(evt){
        var commentId = $(this).closest('li.list_item').data("id");
        $.ajax(apiUrl + "/comments/" + commentId + "/images", {
             type: "GET"
        }).then(appendPhotoViewerImage).then(function(){
            FLICKER.init();
        });
        $('#container').toggle();
        $('footer').toggle();
        $('#photoviwer').toggle();
    }

    var appendPhotoViewerImage = function (imageData){
        var $photoViewer = $("#photoviwer");
        var source = {
            commentImage: imageData
        }
        $photoViewer.html(Handlebars.templates.popuplayer(source));
    }

    var goReviewPage = function(){
        window.location.href = window.location.href + "/review";
    }

    var requestComment = function (){
        $.ajax({
            url: apiUrl + "/comments",
            type: "GET"
        }).done(addCommentList(updateGradeArea, hideReviewMoreButton))
            .then(changeDateFormat);
    }

    var hideReviewMoreButton = function(totalCount){
        if(totalCount <= 3){
            $('.btn_review_more').addClass('hide');
        }
    }

    var updateGradeArea = function(totalCount, totalScore) {
        var avg = (totalScore/totalCount).toFixed(1);
        $('.grade_area > .text_value > span').text(avg);
        var percentage = (avg / 5 * 100).toFixed() + "%";
        $('.grade_area > .graph_mask > .graph_value').css("width", percentage);
        $('.grade_area > .join_count > .green').text(totalCount);
    }

    var changeDateFormat = function (){
        $('.date').each(function(index){
            $(this).text(new Intl.DateTimeFormat('ko-KR').format($(this).text()) + " 방문");
        })
    }

    var addCommentList = function(first_fn, second_fn) {
        return function(data) {
            var arr = [];
            var source = {};
            var comments = data.comments;
            source.product = data.product;
            $('ul.list_short_review').html(comments.map(function (v, i) {
                source.comment = v;
                return Handlebars.templates['usercomment'](source);
            }).join(""));
            first_fn(data.totalCount, data.totalScore);
            second_fn(data.totalCount);
        };
    }

    //var promise = $.ajax("url", "setting");

    // var viewPopupImage = function (ele){
    //     var commentId =
    //     $.ajax(apiUrl + "/comments/{commentId}/images")
    // }

    return {
        init: init
    }
})();


