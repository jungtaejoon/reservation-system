var $event_tab_lst_li = $(".section_event_tab>.event_tab_lst>.item");
var $more_btn = $(".more>.btn");
var $promotion_prev_btn = $(".btn_pre_e");
var $promotion_nxt_btn = $(".btn_nxt_e");

//프로모션 슬라이드
var promotionSlide = (function(){
	var $promotionItems = $(".visual_img");
	var autoTimeInterval = 2000;
	var stopTimeInterval = 4000;
	var movePx = 338;
	var autotimer=0;
	var stoptimer=0;

	function setAuto(){
		autotimer = setInterval(nxtSlide, autoTimeInterval);
	};
	function prevSlide(){
		var lastList = $promotionItems.find('>.item:last-child').clone(true);
		lastList.prependTo($promotionItems);
		$promotionItems.css("left", "-"+movePx+"px");
		$promotionItems.find(">.item:last-child").remove();
		$promotionItems.animate({left: '0'}, "slow");
	};
	function nxtSlide(){
		var firstList = $promotionItems.find(">.item:first-child").clone(true);
		firstList.appendTo($promotionItems);
		$promotionItems.find(">.item:first-child").remove();
		$promotionItems.css("left", "0");
		$promotionItems.animate({left: "-"+movePx+"px"}, "slow");
	};


	return {
		btnPrevEventListener : function(){
			clearInterval(autotimer);
			clearTimeout(stoptimer);
			prevSlide();
			stoptimer = setTimeout(setAuto, stopTimeInterval);
		},
		btnNxtEventListener : function(){
			clearInterval(autotimer);
			clearTimeout(stoptimer);
			nxtSlide();
			stoptimer = setTimeout(setAuto, stopTimeInterval);
		},
		startAutoSlide : function(){
			setAuto();
		}
	};
})();

//상품 리스트 로드
var productLoad = (function(){
	var $product_ul_left = $(".wrap_event_box>:first-child");
	var $product_ul_right = $(".wrap_event_box>:nth-child(2)");
	var categoryId = $(".event_tab_lst>.item:first-child").attr("data-category");
	var listOffset=0;
	var index=0;
	var source = $("#product-list").html();
	var template = Handlebars.compile(source);
	var html;

	function loadAndShowList(id, offset){
		$.ajax({
			url : '/api/products/categories/' + id  + "/pages/" + offset,
			method : "get",
			processData : true,
			contentType : "application/json; charset=UTF-8",
			success : function(data){
				index=0;
				for(var i in data){
					html = template(data[i]);
					if(index%2==0){
						$product_ul_left.append(html);
						index+=1;
					}else{
						$product_ul_right.append(html);
						index+=1;
					}
				}
			}
		});
	};
	function changeNumberOfList(id){
		$.ajax({
			url : "/api/products/count/" + id,
			method : "get",
			processData : true,
			contentType : "application/json; charset=UTF-8",
			success : function(data){
				$(".pink").text(data+"개");
			}
		});
	};
	return {
		showList : function(){
			loadAndShowList(categoryId, listOffset);
		},
		categoryListEventListener : function(data){
			categoryId = $(data.currentTarget).attr("data-category");
			listOffset=0;
			$event_tab_lst_li.find(">.active").removeClass("active");
			$(event.currentTarget).find(">.anchor").addClass("active");
			changeNumberOfList(categoryId);
			$product_ul_left.find(">").remove();
			$product_ul_right.find(">").remove();
			loadAndShowList(categoryId, listOffset);
		},
		btnMoreEventListener : function(event){
			listOffset += 1;
			loadAndShowList(categoryId, listOffset);
		}
	};
})();

$(".event_tab_lst>li:last-child>a").addClass("last");

//초기 실행 함수들
productLoad.showList();
$(document).ready(function (){
	promotionSlide.startAutoSlide();
});

//이벤트 리스너
$event_tab_lst_li.on("click", productLoad.categoryListEventListener);
$more_btn.on("click", productLoad.btnMoreEventListener);
$promotion_prev_btn.on("click", promotionSlide.btnPrevEventListener);
$promotion_nxt_btn.on("click", promotionSlide.btnNxtEventListener);
