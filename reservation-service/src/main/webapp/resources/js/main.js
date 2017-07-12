$(document).ready(function() {
	setRolling = setInterval(bannerRolling_nxt, 2000);
	manageCategory();
	getProducInfo(categoryFlag, 0, start);
});
var start = 0;
var categoryFlag = false;

var setRolling;
var timeCheck=null;

var test = function autoRolling() {
	setRolling = setInterval(bannerRolling_nxt, 2000);
}

var cnt = 0;
var size = $('.banner_list').outerWidth();
var len = $('.banner_list').length;
//var len = $('.visual_img').children().length-2;

$('.visual_img').css('width', len*size);

function bannerRolling_nxt() { // 오른쪽
	cnt++;
	if(cnt > len){
		cnt = 1;
	}
	var move = cnt%len;
	$('.banner_list').animate({'left': -(move*size)+'px'}, 'normal');
	

/*	cnt++;
	$('.banner_list').animate({'left': -(cnt*size)+'px'}, 'normal');
	if(cnt == 2) {
		cnt = 0;
		$('.banner_list').animate({'left': 0+'px'}, 0);
	}*/
};

function bannerRolling_pre() {// 왼쪽
	cnt--;
	if(cnt <= 0){
		cnt = 3;
	}
	var move = cnt%len;
	$('.banner_list').animate({'left': -(move*size)+'px'}, 'normal');
	
/*	cnt--;
	var move = cnt%len;
	//if(move < 0) move *= -1;
	if(cnt == 0) {
		cnt = len-1;
	}
	else {
		$('.banner_list').animate({'left': +(cnt*size)+'px'}, 'normal');
	}*/
}
$('.btnBanner ').bind('click', function() {
	var element = $(this).children();
	var btn = element.attr('class')
	
	clearEvent();
	
	if(btn == 'nxt_inn') {
		bannerRolling_nxt();
	}
	else {
		bannerRolling_pre();
	}
	timeCheck = setTimeout(test, 4000);
});

function clearEvent() {
	clearInterval(setRolling);
	clearTimeout(timeCheck);
}



function manageCategory() {
	$('.cate_list:last').find('a').addClass('last');
	$('.cate_list:first').find('a').addClass('active');
}

$('.cate_list').click(function(){
	categoryFlag = false;
	$('#currentCategory').val($(this).data('category'));
	addActiveClass($(this));
	getProducInfo(categoryFlag, $('#currentCategory').val(), start);
});

function addActiveClass(obj) {
	// e, obj 차이?
	var element = obj.find('a'); 
	element.addClass('active');
	
	obj.siblings().find('a').removeClass('active');
	
	if(element.hasClass('last')){
		element.removeClass('last')
	}
	else {
		$('.cate_list:last').find('a').addClass('last');
	}
};

function getProducInfo(flag, categoryId, start) {
	
	if(flag == false)	// '더보기'가 아닐 경우 0번째부터 가져옴
		start = 0;

	var urlInfo = "";
	var dataInfo = "";

	if(categoryId == 0 || categoryId == undefined) {	// 전체보기 상품
		urlInfo = "/api/getAllProduct/"+start;
		dataInfo = "start="+start;
	}
	else {	// 카테고리별 상품
		urlInfo = "/api/changeCategory/"+categoryId+"/start/"+start;
		dataInfo = "categoryId="+categoryId+"&start="+start;
	}
	
	$.ajax({
	    url : urlInfo,
	    type : "GET",
	    data : dataInfo,
	    success: function(data) {
	    	$('.event_lst_txt .pink').html(data.productCount+'개');
	    	productAppend(data.productList);
	    },
	    error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"error:"+error);
		}
	 
	}); 	
}

$('.btnMore').click(function(){
	categoryFlag = true;
	start++;
	getProducInfo(categoryFlag, $('#currentCategory').val(), start);
})


function productAppend(data) {
	var appendZone = '';
	var odd = '';
	var even = '';
	
	$.each(data, function(index, product){
		appendZone = 
			"<li class='product_list item category'"+product.categoryId+">"+
			"<a href='#' class='item_book'>" +
			"<div class='item_preview'>" +
			"<img alt="+product.fileName+" class='img_thumb' src="+product.saveFileName+">" +
			"<span class='img_border'></span>" +
			"</div>" +
			"<div class='event_txt'>" +
			"<h4 class='event_txt_tit'>" +
			"<span>"+product.productName+"</span>" +
			"<small class='sm'>"+product.placeName+"</small>" +
			"</h4>" +
			"<p class='event_txt_dsc'>"+product.description+"</p>" +
			"</div></a></li>";
		
		if(product.productId % 2 != 0) // 홀수
			odd += appendZone;
		else // 짝수
			even += appendZone;
	});
	
	if(categoryFlag == false)	// '더보기'가 아닐 경우 리스트 비움
		$('.lst_event_box').empty();
	
	$('.lst_event_box:first').append(odd);
	$('.lst_event_box:last').append(even);
}
