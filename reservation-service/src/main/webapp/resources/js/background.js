
var UTIL = (function(){
	
	var number_of_img = 0;
	var index = 0;
	var isMove = 0;
	var intervalId;
	var size;
	
	slideImg = function(){
		clearTimeout();
		intervalId = setInterval(checkImg, 2000);
	};
	delayImg = function () {
		timeoutId = setTimeout(slideImg, 4000);
	};

	checkImg = function(){
		if(isMove == 0){
			isMove = 1;
			index++;
			if(number_of_img < index){
				index = 0;
				$(".visual_img").css("left", 0);
			}
			$(".visual_img").animate({"left": "-=" + size}, "slow" );
			isMove = 0;
		}
    };
    
	previous_click = function(){
		clearInterval(intervalId);
		clearTimeout();
		if(isMove == 0){
			isMove = 1;
			index--;
       		if(index < 0){
   				index = number_of_img;
   				$(".visual_img").css("left", -size*(number_of_img+2));
   			}
       		$(".visual_img").animate({"left": "+=" + size}, "slow", function(){
       			delayImg();
       		});
       		isMove = 0;
		}
    };
    
	next_click = function(){
		clearInterval(intervalId);
		clearTimeout();
		if(isMove == 0){
			isMove = 1;
			index++;
			if(number_of_img < index){
				index = 0;
				$(".visual_img").css("left", 0);
			}
			$(".visual_img").animate({"left": "-=" + size}, "slow", function(callback){
				delayImg();
			});
			isMove = 0;
		}
	};
	
	return{
		set_size: function(n){
			size = n;
		},
		start: function(){
			slideImg();
		},
		next: function(){
			next_click();
		},
		previous: function(){
			previous_click();
		},
		get_index: function(){
			return index;
		},
		set_number_of_img: function(n){
			number_of_img = n;
		},
		get_number_of_img: function(){
			return number_of_img;
		}
	}
})();



	

