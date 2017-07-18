

	//promotion갯수 받아와서 사용
	//numberOfImg = $('#countSaleProduct').html().slice(0,-2);

	var numberOfImg = 3-1;
	var index = 0;
	var isMove = 0;
	
	function slideImg() {
		clearTimeout();
   		intervalId = setInterval(checkImg, 2000);
	}
	function delayImg() {
		timeoutId = setTimeout(slideImg, 4000);
	}
	slideImg();

	function checkImg(){
			if(isMove == 0){
				isMove = 1;
				index++;
				if(numberOfImg < index){
					index = 0;
					$(".visual_img").css("left", 0);
				}
				$(".visual_img").animate({"left": "-=338px"}, "slow" );
				isMove = 0;
			}
    }
	$(".visual_img").css("left", "-338px");
    
	$(".btn_pre_e").click(function() {
		clearInterval(intervalId);
		clearTimeout();
		if(isMove == 0){
			isMove = 1;
			index--;
       		if(index < 0){
   				index = numberOfImg;
   				$(".visual_img").css("left", -338*(numberOfImg+2));
   			}
       		$(".visual_img").animate({"left": "+=338px"}, "slow", function(){
	       		delayImg();
	       		isMove = 0;
       		});
		}
    });
    
	$(".btn_nxt_e, .nxt_fix").click(function(){
		clearInterval(intervalId);
		clearTimeout();
		if(isMove == 0){
			isMove = 1;
			index++;
			if(numberOfImg < index){
				index = 0;
				$(".visual_img").css("left", 0);
			}
			$(".visual_img").animate({"left": "-=338px"}, "slow", function(){
				delayImg();
				isMove = 0;
			});
		}
	});
	
	/* 카운트 */
	function get_count() {
		$.ajax({
			type:'get',
			url:'/product/count',
			success:function(result) {
				result += "개 ";
				$('#countSaleProduct').html(result);
			}
		});
	}

