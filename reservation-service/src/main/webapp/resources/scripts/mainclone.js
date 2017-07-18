const HOST = "http://localhost:8080";
const VISUAL_IMG_SIZE = 338;
const VISUAL_IMG_NUM = 2;
const INIT_CALL_PROUDUCT_NUM = 4;
const MORE_CALL_PROUDUCT_NUM = 10;

(function (window) {
	var position_num = 0;
	var autoRollId;
	var stopRollId;
	var current_product_num = 0;
	var visual_img_num = VISUAL_IMG_NUM;
	
	init();
	
	
	function init(){
		$('.btn_pre_e').on("click", btn_pre_eClick);
		$('.btn_nxt_e').on("click", btn_nxt_eClick);
		$('.more button').on("click", moreButtonClick);
		$(document).on("click",".event_tab_lst .item", categoryClick );
		$(document).scroll( scrolling );
		
		getCategory();
		autoRoll();
		getCount();
		getProduct(0);	// eventlist용
		getProduct(1);  // visual container 용
	}
	
	var categoryModule = (function() {
		
		
	})();
	function getCategory() {
		var url = HOST + "/api/category";
		$.ajax({
			url: url,
			type: "GET",
			dataType: 'json',
			contentType: 'application/json'
		})
		.done( function(data){showCategory(data); } )
		.fail();
	}
	
	function showCategory(data) {
		var source = $("#event_tab_item_template").html();
		var template = Handlebars.compile(source);
		var data = {categories: data};
		////console.log(data);
		var html = template(data);
		$(".event_tab_lst").append(html);
		$(".event_tab_lst > .item:last-child > .anchor").addClass("last");
	}
	
	
	function btn_pre_eClick() {

		goPrev();
		stopRoll();
		////console.log("Pre, position_num = " + position_num);
	}

	function btn_nxt_eClick() {
		goNext();
		stopRoll();
		////console.log("Nex, position_num = " + position_num);
	}
	
	function goPrev() {
		if(position_num == 0 ) {
			$('.visual_img').animate({left: -visual_img_num* VISUAL_IMG_SIZE  + "px" }, 0);
			$('.visual_img').animate( { left: "+=" + VISUAL_IMG_SIZE + "px" }, 'slow');
			position_num = visual_img_num - 1 ;	
		} else {
			$('.visual_img').animate( { left: "+=" + VISUAL_IMG_SIZE + "px" }, 'slow');
			position_num = position_num - 1;
		}
	}
	
	function goNext() {
		if(position_num == visual_img_num -1) {
			position_num = 0;
			$('.visual_img').animate( { left: "-=" + VISUAL_IMG_SIZE + "px" }, 'slow');
			$('.visual_img').animate({left: "0px" }, 0);
			////console.log(position_num);
		} else {
			position_num = position_num + 1;
			$('.visual_img').animate( { left: "-=" + VISUAL_IMG_SIZE + "px" }, 'slow');
			////console.log(position_num);
		}
	}
	
	function autoRoll() {
		autoRollId = setInterval(goNext, 2000);
	}
	
	function stopRoll() {
		clearTimeout(stopRollId);
		clearInterval(autoRollId);
		stopRollId = setTimeout(autoRoll, 4000);
	}
	
	function categoryClick() {
		$(".event_tab_lst .anchor").removeClass("active");
		$(this).find(".anchor").addClass("active");
		current_product_num = 0;
		//console.log("category clicked");
		
		getCount();
		getProduct(0);
	}
	

	
	
	function getCount() {
		var url = HOST + "/api/product-for-main/count";
		var current_category = $(".event_tab_lst .active").parent().attr("data-category");
		if( current_category != 0 ) {
			url = url + "/" + current_category;
		}
		$.ajax({
			url: url,
			type: "GET",
			dataType: "json"
		})
		.done(
			showCount.bind(this)
		)
		.fail(function() {
			//console.log("error");
		});
	}
	
	function showCount(response) {
		var result = response + "개";
		$(".event_lst_txt span").html(result);
	}
	
	
	function getProduct(arg) {
		var url = HOST + "/api/product-for-main";
		var current_category = $(".event_tab_lst .active").parent().attr("data-category");
		var call_num;
		var data;
		
		if(current_product_num==0){
			call_num = INIT_CALL_PROUDUCT_NUM;
		} else {
			call_num = MORE_CALL_PROUDUCT_NUM;
		}
		
		if( arg == 0 && current_category != 0 ) {
				url = url + "/" + current_category;
		} else if( arg == 1 ) {
			url = url + "/visual";
		}
		
		data = {"start": current_product_num , "count": call_num };
		
		$.ajax({
			url: url,
			type: "GET",
			dataType: "json",
			contentType: 'application/json',
			data: data
		})
		.done(
			function(response) {
				if(arg == 0) {
					showProduct(response);
				}
				else {
					showVisual(response);
				}
			}
			
		)
		.fail(function() {
			//console.log("error");
		});
		
	}
	

	
	function showProduct(response) {
		//console.log(response);
		if(current_product_num == 0) {
			$(".lst_event_box li").remove(); 
		}
		
		var source = $("#lst_event_box_template").html();
		var template = Handlebars.compile(source);
		
		$.each(response, function(index, element) {
			var data = {products: element};
			
			var html = template(data);

			if(current_product_num%2 == 0){
				$(".lst_event_box:first-child").append(html);
			} else {
				$(".lst_event_box:not(:first-child)").append(html);
			}
			
			current_product_num++ ;
		});
	}
	
	function showVisual(response) {
		//console.log(response);
		visual_img_num = response.length;
		var source = $("#container_visual_template").html();
		var template = Handlebars.compile(source);
		var data = {visual: response};
		var html = template(data);
		$(".container_visual ul").append(html);
		
		
		// 로테이션을 위해 끝에 2개 element 추가
		var data = {visual: response[0]};
		var html = template(data);
		$(".container_visual ul").append(html);
		var data = {visual: response[1]};
		var html = template(data);
		$(".container_visual ul").append(html);
	}
	
	function moreButtonClick() {
		getProduct(0);
		//console.log("c_num=" + current_product_num);
	}
	
	function scrolling() {
		var maxHeight = $(document).height();
		var currentScroll = $(window).scrollTop() + $(window).height();
		//console.log(currentScroll);

		if (currentScroll + 10 > maxHeight ) {
			moreButtonClick();
		}
	}
	
})(window);


