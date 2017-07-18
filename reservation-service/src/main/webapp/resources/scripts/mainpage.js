const HOST = "http://localhost:8080";
const VISUAL_IMG_SIZE = 338;
const VISUAL_IMG_NUM = 2;
const INIT_CALL_PROUDUCT_NUM = 4;
const MORE_CALL_PROUDUCT_NUM = 10;

(function (window) {
	// There are 3 modules.
	// Order : visualModule > productModule > categoryModule;	

	var visualModule;
	var productModule;
	var categoryModule;	

	
	var visualModule = (function() {

		// private variables
		var position_num = 0;
		var autoRollId;
		var stopRollId;
		var visualImgNum = VISUAL_IMG_NUM;
		
		// init
		$('.btn_pre_e').on("click", btn_pre_eClick);
		$('.btn_nxt_e').on("click", btn_nxt_eClick);

		autoRoll();
		
		
		// methods:
		// btn_pre_eClick, btn_nxt_eClick, goPrev, goNext, autoRoll, stopRoll
		function btn_pre_eClick() {
			goPrev();
			stopRoll();
		}

		function btn_nxt_eClick() {
			goNext();
			stopRoll();
		}
		
		function goPrev() {
			if(position_num == 0 ) {
				$('.visual_img').animate({left: -visualImgNum* VISUAL_IMG_SIZE  + "px" }, 0);
				$('.visual_img').animate( { left: "+=" + VISUAL_IMG_SIZE + "px" }, 'slow');
				position_num = visualImgNum - 1 ;	
			} else {
				$('.visual_img').animate( { left: "+=" + VISUAL_IMG_SIZE + "px" }, 'slow');
				position_num = position_num - 1;
			}
		}
		
		function goNext() {
			if(position_num == visualImgNum -1) {
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
		
		return {
			setVisualImgNum: function(num) {
				visualImgNum = num;
			}
		}
	})();
	
	
	
	
	
	var productModule = (function() {
		// private variable
		var currentProductNum = 0;
		var visualImgNum = VISUAL_IMG_NUM;
		
		// init
		$('.more button').on("click", moreButtonClick);
		$(document).scroll( scrollHandler );
		getProduct(0);	// eventlist용
		getProduct(1);  // visual container 용
		
		
		// methods:
		// getProduct, showProduct, showVisual, moreButtonClick, scrollHandler		
		function getProduct(arg) {
			var url = HOST + "/api/product-for-main";
			var current_category = $(".event_tab_lst .active").parent().attr("data-category");
			var call_num;
			var data;
			if(currentProductNum == 0){
				call_num = INIT_CALL_PROUDUCT_NUM;
			} else {
				call_num = MORE_CALL_PROUDUCT_NUM;
			}
			
			if( arg == 0 && current_category != 0 ) {
					url = url + "/" + current_category;
			} else if( arg == 1 ) {
				url = url + "/visual";
			}
			
			data = {"start": currentProductNum , "count": call_num };
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
			
			if(currentProductNum == 0) {
				$(".lst_event_box li").remove(); 
			}
			
			var source = $("#lst_event_box_template").html();
			var template = Handlebars.compile(source);
			
			$.each(response, function(index, element) {
				var data = {products: element};
				
				var html = template(data);

				if(currentProductNum%2 == 0){
					$(".lst_event_box:first-child").append(html);
				} else {
					$(".lst_event_box:not(:first-child)").append(html);
				}
				
				currentProductNum++ ;
			});
		}
		
		function showVisual(response) {
			
			//visualImgNum = response.length;
			visualModule.setVisualImgNum(response.length);
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
		}
		
		function scrollHandler() {
			var maxHeight = $(document).height();
			var currentScroll = $(window).scrollTop() + $(window).height();

			if (currentScroll + 10 > maxHeight ) {
				moreButtonClick();
			}
		}
		
		return {
			getVisualImgNum: function() { return visualImgNum; },
			
			setCurrentProductNum: function(arg) { currentProductNum = arg;},
			
			doGetProduct: function(arg) { getProduct(arg); }
		};
		
	})();
	
	
	
	var categoryModule = (function() {
		
		// init
		$(document).on("click",".event_tab_lst .item", categoryClick );
		getCategory();
		getCount();
		
		// methods: getCategory, showCategory, categoryClick, getCount, showCount
		
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
			var html = template(data);
			$(".event_tab_lst").append(html);
			$(".event_tab_lst > .item:last-child > .anchor").addClass("last");
		}
		
		function categoryClick() {
			$(".event_tab_lst .anchor").removeClass("active");
			$(this).find(".anchor").addClass("active");
			productModule.setCurrentProductNum(0);
			productModule.doGetProduct(0);
			getCount();
			
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
		
	})();
	
	
	
	
	

})(window);


