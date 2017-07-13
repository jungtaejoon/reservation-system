$(function() {
	
	var bannerModule = (function() {
		var setRolling=0;
		var timeCheck=0,
		timeCheck = 0;
		var bannerList = $('.banner_list');
		var cnt = 0;
		var size = bannerList.outerWidth();
		var len = $('.banner_list').length;
		$('.visual_img').css('width', len*size);
	
		return {
			bannerRolling_nxt : function() {	// 오른쪽
				cnt++;
				if(cnt > len){
					cnt = 1;
				}
				var move = cnt%len;
				bannerList.animate({'left': -(move*size)+'px'}, 'normal');
			},
			bannerRolling_pre : function() {	// 왼쪽
				cnt--;
				if(cnt <= 0){
					cnt = 3;
				}
				var move = cnt%len;
				bannerList.animate({'left': -(move*size)+'px'}, 'normal');
			},
			test : function autoRolling() {
				// 상단 배너 자동 롤
				setRolling = setInterval(bannerModule.bannerRolling_nxt, 2000);
			},
			clear :function() {
				// 이벤트 해제
				clearInterval(setRolling);
				clearTimeout(timeCheck);
			},
			setRollings : function(){
				setRolling = setInterval(bannerModule.bannerRolling_nxt, 2000);
			},
			setTimecheck:function(value){
				timeCheck = value;
			}
			
		};
	})();


	var categoryModule = (function() {
		var firstCategory = $('.cate_list:first').find('a');
		var lastCategory = $('.cate_list:last').find('a');
		
		return {
			manageCategory : function() {
				firstCategory.addClass('active');
				lastCategory.addClass('last');
			},
			addActiveClass : function(obj) {
				var element = obj.find('a'); 
				element.addClass('active');
				
				obj.siblings().find('a').removeClass('active');
				
				if(element.hasClass('last')){
					element.removeClass('last')
				}
				else {
					lastCategory.addClass('last');
				}
			}
		};
	})();
	
	
	var productListModule = (function() {
		var start = 0;
		var categoryFlag = false;
		var countData= $('.event_lst_txt .pink');
		var handlebarTemplate = $("#product_template");
		var ulTag = $(".lst_event_box");
		
		return {
			getProducInfo : function(flag, categoryId, start) {
				if(flag == false)	// '더보기'가 아닐 경우 0번째부터 가져옴
					start = 0;
				else
					start++;

				var urlInfo = "/productInfo";
				var dataInfo = "";

				if(categoryId == 0 || categoryId == undefined) {	// 전체보기 상품
					urlInfo += "/all/"+start;
					dataInfo = "start="+start;
				}
				else {	// 카테고리별 상품
					urlInfo += "/category/"+categoryId+"/start/"+start;
					dataInfo = "categoryId="+categoryId+"&start="+start;
				}
				
				$.ajax({
				    url : urlInfo,
				    type : "GET",
				    data : dataInfo,
				    success: function(data) {
				    	productListModule.countProduct(data.productCount);
				    	
				    	if(data.productList.length == 0)
				    		alert("더이상 상품이 없습니다!");
				    	else 
				    		productListModule.productAppend(flag, data.productList);
				    },
				    error:function(request,status,error){
				        alert("code:"+request.status+"\n"+"error:"+error);
					}
				 
				}); 	
			},
			countProduct : function(count) {
				countData.html(count+'개');
			},
			productAppend : function(flag, result) {
				var source = handlebarTemplate.html();
				var template = Handlebars.compile(source);
				
				if(flag == false)	// '더보기'가 아닐 경우 리스트 비움
					ulTag.find('li').remove();
				
				$.each(result, function(index, product){
					var data = {productList : product};
					var html = template(data);
					
					if(index % 2 == 0)
						ulTag.first().append(html);
					else // 짝수
						ulTag.last().append(html);
				});	
			}
		};
	})();
	
	
	
	bannerModule.setRollings();	
	categoryModule.manageCategory();
	productListModule.getProducInfo(false, 0, 0);
	
	
	$('.btnBanner ').click(function() {
		var element = $(this).children();
		var btn = element.attr('class')
		bannerModule.clear();
		
		if(btn == 'nxt_inn') {
			bannerModule.bannerRolling_nxt();
		}
		else {
			bannerModule.bannerRolling_pre();
		}
		bannerModule.setTimecheck(setTimeout(bannerModule.test, 2000));
	});

	$('.cate_list').click(function(){
		$('#currentCategory').val($(this).data('category'));
		$('#moreCnt').val(0);
		
		categoryModule.addActiveClass($(this));
		productListModule.getProducInfo(false, $('#currentCategory').val(), 0);
	});
	
	function getMoreInfo() {
		var moreCnt = Number($('#moreCnt').val());
		moreCnt += 1;
		$('#moreCnt').val(moreCnt);

		productListModule.getProducInfo(true, $('#currentCategory').val(), moreCnt-1);
	}
	
	$('.btnMore').click(function(){
		getMoreInfo();
	})
	
	$(window).scroll(function() {
	    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	    	getMoreInfo();
	    }
	});
	
});
