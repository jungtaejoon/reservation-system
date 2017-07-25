var start = 0;


$(function(){
	//캐러셀
	var rolling = (function() {
		var $ul=$(".visual_img");
		var cnt = 0;
		var imgSize = $ul.children().outerWidth();
		var childCnt = $ul.children().length-2;
		var item = $ul.find("li");
		var interval = null;
		var timeout = null;
		var startInterval = {};
		
		$ul.css('width', childCnt*imgSize); 
				
		return {	
			preRolling : function preVisualRolling() {	
				rolling.clearEvent();
				if(cnt <= 0){
					cnt = childCnt;
					item.animate({'left': -(cnt*imgSize)+'px'}, 0);
				}
				cnt--;
				item.animate({'left': -(cnt*imgSize)+'px'}, 'normal');
			},
			nextRolling : function nextVisualRolling(){
				rolling.clearEvent();
				cnt++;
				item.animate({'left': -(cnt*imgSize)+'px'}, 'normal');
				if(cnt == childCnt){
					cnt = 0;
					item.animate({'left': '0px'}, 0);
				}
			},
			start : function startRolling() {
				interval = setInterval(rolling.nextRolling, 2000);
			},
			clearEvent : function(){
				clearInterval(interval);
				clearTimeout(timeout);
				timeout = setTimeout(rolling.start2, 2000);
			}

		};

	})();

	var productInfoModule = function(categoryId, start){
		
		// 중복되는 내요을 함수로 뺴고 호출
		return {
			getList : function getProductList(){
				var rest = "";
				if((categoryId == 0) || (categoryId == undefined))
					rest = start;
				else
					rest = categoryId+"/start/"+start;

				$(".lst_event_box:first").empty();
				$(".lst_event_box:last").empty();
				$.ajax({
					method : "GET",
					url : "/api/products/info/"+rest
				}).done(function(data){
					$(".event_lst_txt .pink").html(data.cnt+"개"); // 카테고리별 상품 총 개수
					
					var dummy = $("#project-item-template").html();
					var template = Handlebars.compile(dummy);
					$.each(data.list, function(index, product){
						var source = product;
						var item = template(source);
						if((index%2) == 0){
							$(".lst_event_box:first").append(item);
						}else{
							$(".lst_event_box:last").append(item);
						}
					});		
				});
			},
			getMore : function getMore(){	
				var categoryId = $(".active").parent().data("category");
				
				var rest = "";
				if(categoryId == 0)
					rest = start;
				else
					rest = categoryId+"/start/"+start;
				
				$.ajax({
					method : "GET",
					url : "/api/products/info/"+rest
				}).done(function(data){

					var leftSize = $(".lst_event_box:first .item").length;
					var rightSize = $(".lst_event_box:last .item").length;
					
					var dummy = $("#project-item-template").html();
					var template = Handlebars.compile(dummy);
					$.each(data.list, function(index, product){
						var source = product;
						
						var item = template(source);

						if(leftSize > rightSize){
							if((index%2) == 1){
								$(".lst_event_box:first").append(item);
							}else{
								$(".lst_event_box:last").append(item);
							}
						}else{
							if((index%2) == 0){
								$(".lst_event_box:first").append(item);
							}else{
								$(".lst_event_box:last").append(item);
							}
						}
					});	
				});
			}
		}
	}

	rolling.start();

	$(".prev_inn").on("click",rolling.preRolling);
	$(".nxt_inn").on("click", rolling.nextRolling);
	
	var product = productInfoModule.call(this, 0, start);
	product.getList();
	
	$(".event_tab_lst .item").on("click", anchorClick);
	
	// 더보기
	$(".more .btn").on("click", function(){
		start++;
		var categoryId = $(".active").parent().data("category");
		var product = productInfoModule.call(this, categoryId, start);
		product.getMore();
	});
	
	function anchorClick() {
		start = 0;
		$(".anchor").removeClass("active");
		$(this).find(".anchor").addClass("active");
		var categoryId = $(this).attr("data-category");
		var product = productInfoModule.call(this, categoryId, start);
		product.getList();
	}
	
	$(window).scroll(function() {
	    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	    	start++;
	    	var categoryId = $(".active").parent().data("category");
			var product = productInfoModule.call(this, categoryId, start);
			product.getMore();
	    }
	});
});
