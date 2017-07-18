var $event_tab_lst_li = $(".section_event_tab>.event_tab_lst>.item");
var $product_ul_left = $(".wrap_event_box>:first-child");
var $product_ul_right = $(".wrap_event_box>:nth-child(2)");
var $more_btn = $(".more>.btn");
var categoryId = $(".event_tab_lst>.item:first-child").attr("data-category");
var listOffset=0;
var product_li_template = "<li class='item'>"+
								"<a href='#' class='item_book'>"+
									"<div class='item_preview'> <img alt='뮤지컬 드림걸즈(DREAMGIRLS) 최초 내한' class='img_thumb' src='https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945'><span class='img_border'></span> </div>"+
									"<div class='event_txt'>"+
										"<h4 class='event_txt_tit'> <span></span> <small class='sm'></small> </h4>"+
										"<p class='event_txt_dsc'></p>"
									"</div>"+
								"</a>"+
							"</li>";

$(".event_tab_lst>li:last-child>a").addClass("last");
loadList(categoryId, listOffset);

$event_tab_lst_li.on("click", function(event){
	categoryId = $(event.currentTarget).attr("data-category");
	listOffset=0;
	$event_tab_lst_li.find(">.active").removeClass("active");
	$(event.currentTarget).find(">.anchor").addClass("active");
	changeNumberOfLst(categoryId);
	$product_ul_left.find(">").remove();
	$product_ul_right.find(">").remove();
	loadList(categoryId, listOffset);
});

$more_btn.on("click", function(){
	listOffset += 1;
	loadList(categoryId, listOffset);
});

$(document).ready(function (){
	imageSlide();
});

function changeNumberOfLst(categoryId){
	$.ajax({
		url : "/api/product/number/" + categoryId,
		method : "get",
		processData : true,
		contentType : "application/json; charset=UTF-8",
		success : function(data){
			$(".pink").text(data+"개");
		}
	});
}
function loadList(categoryId, listOffset){
	$.ajax({
		url : '/api/product/list/' + categoryId  + "/" + listOffset,
		method : "get",
		processData : true,
		contentType : "application/json; charset=UTF-8",
		success : function(data){
			var index=0;
			for(var i in data){
				if(index%2==0){
					$product_ul_left.append(product_li_template);
					$product_ul_left.find(">.item:last-child>.item_book>.event_txt>.event_txt_tit>span").text(data[i].name);
					$product_ul_left.find(">.item:last-child>.item_book>.event_txt>.event_txt_dsc").text(data[i].description);
					index+=1;
				}else{
					$product_ul_right.append(product_li_template);
					$product_ul_right.find(">.item:last-child>.item_book>.event_txt>.event_txt_tit>span").text(data[i].name);
					$product_ul_right.find(">.item:last-child>.item_book>.event_txt>.event_txt_dsc").text(data[i].description);
					index+=1;
				}
			}
		}
	});
}

function imageSlide(){
	var $promotionItems = $(".visual_img");
	var autoTimeInterval = 2000;
	var stopTimeInterval = 4000;
	var movePx = 338;
	var autotimer=0;
	var stoptimer=0;
	
	setAuto();
	
	$(".btn_pre_e").on("click", function(){
		clearInterval(autotimer);
		clearTimeout(stoptimer);
		preSlide();
		stoptimer = setTimeout(setAuto, stopTimeInterval);
	});
	
	$(".btn_nxt_e").on("click", function(){
		clearInterval(autotimer);
		clearTimeout(stoptimer);
		nxtSlide();
		stoptimer = setTimeout(setAuto, stopTimeInterval);
	});
	
	function setAuto(){
		autotimer = setInterval(nxtSlide, autoTimeInterval);
	}
	
	function preSlide(){
		var lastList = $promotionItems.find('>.item:last-child').clone(true);
		lastList.prependTo($promotionItems);
		$promotionItems.css("left", "-"+movePx+"px");
		$promotionItems.find(">.item:last-child").remove();
		$promotionItems.animate({left: '0'}, "slow");
	}
	
	function nxtSlide(){
		var firstList = $promotionItems.find(">.item:first-child").clone(true);
		firstList.appendTo($promotionItems);
		$promotionItems.find(">.item:first-child").remove();
		$promotionItems.css("left", "0");
		$promotionItems.animate({left: "-"+movePx+"px"}, "slow");
	}
}



