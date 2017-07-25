const HOST = "http://localhost:8080";


//const VisualModule;  from VisualModule.js

(function(window) {
	
	var info;
	var VisualModule;
	var LoadModule;   //image and product info.
	var NaverMap
	
	var VisualModule = VisualModule_.getInstance();
	//setting
		VisualModule.setVisualImgSize(VISUAL_IMG_SIZE);
		VisualModule.setVisualImgNum(VISUAL_IMG_NUM);
		VisualModule.setAutoRoll(false);
		VisualModule.setScrollEndFlag(0);
		VisualModule.setModuleClass("section_visual");
		VisualModule.setButton($('.section_visual .btn_prev'), $('.section_visual .btn_nxt'));
		VisualModule.init();
	
	
	var	CommentModule = CommentModule_;
		CommentModule.setProductId(productId);
		CommentModule.load();
		
	var NaverMap = NaverMap_;
		
	
	var LoadModule = (function(){
		
		var visualImgNum = VISUAL_IMG_NUM;
		var getProductAjax;
		var getVisualAjax;
		
		getProduct();
		getVisual();
		setButtons();
		
		function getProduct() {
			var url = HOST + "/api/detail/info/" + productId;
			
			getProductAjax = $.ajax({
				url: url,
				type: "GET",
				dataType: "json"
			})
			.done(
					showProduct.bind(this)
			)
			.fail(function() {
				//console.log("error");
			});
			
		}
		
		function showProduct(response) {
			
			info = response;
			
			$(".section_store_details .dsc").html(info.content);
			
			
			$(".detail_info .in_dsc").html(info.content);
			
			var name = response.name;
			var desc = response.description;
			
			$.when(getProductAjax, getVisualAjax).done(function(){

				$(".visual_img li:first-of-type .visual_txt_tit span").html(name);
				$(".visual_img li:first-of-type .visual_txt_dsc").html(desc);
				
			});
			
			
			if(response.event != null){
				$(".event_info .in_dsc").html(info.event);
			}
			
			//상단 아이콘
			$(".btn_goto_home").attr("href", info.homepage);
			$(".btn_goto_tel").attr("href", "tel:" + info.tel);
			$(".btn_goto_mail").attr("href", "malto:" + info.email);
			
			
			// 코멘트 통계 부분
			var source = $("#grade_area_template").html();
			var template = Handlebars.compile(source);
			
			var avgScore;
			if(response.avgScore != null) {
				avgScore = parseFloat(response.avgScore).toPrecision(2);
			} else {
				avgScore = 0
			}
			var avgPercent = avgScore * 20;
			
			var commentCount;
			if(response.commentCount != null) {
				commentCount = response.commentCount;
			} else {
				commentCount = 0;
			}
			
			var commentstat = {
					"average": avgScore,
					"length" : commentCount,
					"avgPercent" : avgPercent
			};
			var data = { "commentstat" : commentstat };
			var html = template(data);
			
			//console.log(data);
			
			$(".grade_area").append(html);
			
			
			
			NaverMap.set(info.placeLot);
			//하단 지도 설명 부분
			$(".store_name").html(info.name);
			$(".store_addr_bold").html(info.placeStreet);
			$(".addr_old_detail").html(info.placeLoc);
			$(".addr_detail").html(info.placeName);
			
			$(".store_tel").html(info.tel);
			$(".store_tel").attr("href", "tel:" + info.tel);

		}
		
		function getVisual() {
			var url = HOST + "/api/detail/images/" + productId;
			
			getVisualAjax = $.ajax({
				url: url,
				type: "GET",
				dataType: "json"
			})
			.done(
					showVisual.bind(this)
			)
			.fail(function() {
				//console.log("error");
			});
		}
		
		function showVisual(response) {
			
			var source = $("#container_visual_template").html();
			var template = Handlebars.compile(source);
			var data = {visual: response};
			var html = template(data);
			$(".section_visual .container_visual ul").append(html);
			
			$(".section_visual .figure_pagination .num.off span").html(response.length);	
			VisualModule.setVisualImgNum(response.length);			
			VisualModule.initPrintPositionHandler( $(".section_visual .figure_pagination .num:first-child") );
			
			if(response.length <= 1) {
				$(".section_visual .prev").css("visibility", "hidden");
				$(".section_visual .nxt").css("visibility", "hidden");
			} else {
				$(".section_visual .prev").css("visibility", "");
				$(".section_visual .nxt").css("visibility", "");
			}
			
		}
		
		function setButtons() {
			//펼쳐보기
			$(".bk_more._open").on("click", function(event) {
				console.log("openBtn");
				$(".bk_more._close").css({display: "block"});
				$(".store_details").removeClass("close3");
				$(".bk_more._open").css({display: "none"});
				event.preventDefault(); 
				event.stopPropagation();
			});
			
			
			//접기
			$(".bk_more._close").on("click", function(event) {
				$(".bk_more._open").css("display", "block");
				$(".store_details").addClass("close3");
				$(".bk_more._close").css("display", "none");
				event.preventDefault(); 
				event.stopPropagation();
			});
			
			
			//예매하기
			$(".bk_btn").on("click", function() {
				
				if(info.salesEnd < (new Date()).getTime() ) {
					alert("죄송합니다. 판매기간이 종료되었습니다.");
				} else if(info.salesFlag == 1) {
					alert("죄송합니다. 매진되었습니다.");
				} else {
					
					location.href =  HOST + "/reserve/" + info.id;
				}
			})
			
			
			//상세정보
			$(".section_info_tab ._detail").on("click", function() {
				if($(".section_info_tab ._detail").hasClass("active") != true ){
					$(".section_info_tab ._detail").addClass("active");
					$(".section_info_tab ._path").removeClass("active");
					
					$(".detail_location").addClass("hide");
					$(".detail_area_wrap").removeClass("hide");
				}
			})
			
			//오시는길
			$(".section_info_tab ._path").on("click", function() {
				if($(".section_info_tab ._path").hasClass("active") != true ){
					$(".section_info_tab ._path").addClass("active");
					$(".section_info_tab ._detail").removeClass("active");
					
					$(".detail_area_wrap").addClass("hide");
					$(".detail_location").removeClass("hide");
				}
			})
			
			
		
		
		}
		
		
	})();
	
	
	
})();

