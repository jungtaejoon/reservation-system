$(function(){
	$(".lazy").lazyload();
	$(".section_store_details .bk_more").on("click", function(){

		if($(".section_store_details ._open").css("display") != 'none'){
			$(".section_store_details .store_details").removeClass("close3");
			$(".section_store_details ._open").css("display", "none");
			$(".section_store_details ._close").css("display", "block");
		}else{
			$(".section_store_details .store_details").addClass("close3");
			$(".section_store_details ._open").css("display", "block");
			$(".section_store_details ._close").css("display", "none");
		}
	});
	
	$(".section_info_tab .info_tab_lst ._detail").on("click", function() {
		event.preventDefault();
		$(".section_info_tab .info_tab_lst").find("a").removeClass("active");
		$(this).children("a").addClass("active");
		$(".detail_area_wrap").removeClass("hide");
		$(".detail_location").addClass("hide");
	});
	
	$(".section_info_tab .info_tab_lst ._path").on("click", function() {
		event.preventDefault();
		$(".section_info_tab .info_tab_lst").find("a").removeClass("active");
		$(this).children("a").addClass("active");
		$(".detail_area_wrap").addClass("hide");
		$(".detail_location").removeClass("hide");
	});
		
	Carousel.init.bind($(".visual_img"))();
	$(".group_visual .prev_inn").on("click", Carousel.prev);
	$(".group_visual .nxt_inn").on("click", Carousel.next);
	

	var pageNum = 1;
	var pageMax = Number($(".figure_pagination span:last").html());
	$(".group_visual .prev_inn").on("click", pageNumMinus);
	$(".group_visual .nxt_inn").on("click", pageNumPlus);
	
	
	// 예매하기 버튼
	$(".section_btn").on("click", function(){
		var saleStatus = $("#product_sales").val();
		alert(saleStatus);
		if(saleStatus == '판매가능'){
			var productId = $(".section_btn").data("category");
			location.href = "/reserve/"+productId;
		}
	});
	
	
	// 상품이미지 터치
	var touchStartX = 0;
	var touchEndX = 0;

	$(".visual_img").bind("touchstart", function(e){
		touchStartX = e.targetTouches[0].pageX;
	});
	
	$(".visual_img").bind("touchmove", function(e){
		var touchMoveX = e.targetTouches[0].pageX;
		$(".visual_img .item").css("left", -touchMoveX+"px");
	});
	
	$(".visual_img").bind("touchend", function(e){
		touchEndX = e.changedTouches[0].pageX;
		if(touchStartX - touchEndX < 20){
			Carousel.prev();
			pageNumMinus();
		}else if(touchEndX - touchStartX < 20){
			Carousel.next();
			pageNumPlus();
		}
	});

	function pageNumMinus(){
		pageNum--;
		if(pageNum < 1){
			pageNum = pageMax;
		}
		$(".figure_pagination span:first").html(pageNum);
	}
	
	function pageNumPlus(){
		pageNum++;
		if(pageNum > pageMax){
			pageNum = 1;
		}
		$(".figure_pagination span:first").html(pageNum);
	}
	

	// 레이어팝업
	$(".review_area .thumb_area").on("click", function(){
		$("#photoviwer").css("display", "block");
		var commentId = $(this).attr("data-category");
		var imgWidth = $(".inner").width();
		$.ajax({
			method : "GET",
			url : "/api/files/comments/"+commentId,
		}).done(function(data){
			$("#photoviwer .outer .inner ul").css('width', (data.length+2)*imgWidth);
			$("#photoviwer .outer .inner ul").empty();
			$("#photoviwer .photo_count").empty();
			$("#photoviwer .photo_count").append("<em class='green'>1</em>/"+data.length);
			$.each(data, function(index, commentImg){
				var dummy = $("#photoviwer-item-template").html();
				var template = Handlebars.compile(dummy);
				var source = commentImg;
				var item = template(source);
				$("#photoviwer ul").append(item);
			});
			$(".photoul li").css('width', imgWidth);
			Popcarousel.init.bind($(".photoul"))();	// 이벤트처리순서중요!
		});
	});
	
	$("#photoviwer ._close").on("click", function(){
		$("#photoviwer").css("display", "none");
	});
	
	// 레이어팝업 터치	
	var popTouchStartX = 0;
	var popTouchEndX = 0;
	$(".photoul").bind("touchstart", function(e){
		popTouchStartX = e.targetTouches[0].pageX;
		Popcarousel.prev();
	});
	
	$(".photoul").bind("touchmove", function(e){
		var popTouchMoveX = e.targetTouches[0].pageX;
		$(".photoul .item").css("left", -popTouchMoveX+"px");
	});
	
	$(".photoul").bind("touchend", function(e){
		popTouchEndX = e.changedTouches[0].pageX;
		if(popTouchStartX - popTouchEndX < 20){
			Popcarousel.prev();
		}else if(popTouchEndX - popTouchStartX < 20){
			Popcarousel.next();
		}
	});
});
