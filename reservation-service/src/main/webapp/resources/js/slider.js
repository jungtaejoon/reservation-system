var SliderModule = (function(){

	var interval;
	var timeout;
	var width = 338;
	var animationSpeed = 1000;
	var currentSlide = 1;
	var automoveAfter = 4000;

	var $slider = $('#promotion_slider');
	var $slideContainer = $slider.find('ul.visual_img');
	var $slides = $slideContainer.find('li.item');
	

	var init = function(){
		SliderModule.autoMove();
		$('div.prev_e').on('click', '.prev_inn', SliderModule.preButtonMove);
		$('div.nxt_e').on('click', '.nxt_inn', SliderModule.nxtButtonMove);
	}

	var autoMove = function(){
		var direction = "-=";
		var pause = 2000;

		interval = setInterval(function() {

			CommonModule.imgMove($slideContainer, direction, width, animationSpeed, SliderModule.imgMoveAnimate);
		}, pause);
	};
	
	var imgMoveAnimate = function(){
		currentSlide++;
		if(currentSlide === $slides.length-1) {
			currentSlide = 1;
			$slideContainer.css('margin-left', 0);
		}

	};
	
	var stopSlider = function(){
		clearInterval(interval);
	};
	
	var preButtonMove = function(){
		var direction = "+=";
		SliderModule.stopTimeout();
		SliderModule.stopSlider();
		if(currentSlide===1) {
			$slideContainer.css('margin-left', -676);
		}
		CommonModule.imgMove($slideContainer, direction, width, animationSpeed, SliderModule.imgMoveAnimate);
		SliderModule.restartAutomove();
	};
	
	var nxtButtonMove = function(){
		var direction = "-=";
		SliderModule.stopTimeout();
		SliderModule.stopSlider();
		CommonModule.imgMove($slideContainer, direction, width, animationSpeed, SliderModule.imgMoveAnimate);
		SliderModule.restartAutomove();
	};
	
	var stopTimeout = function(){
		clearTimeout(timeout);
	};
	
	var restartAutomove = function(){
		timeout = setTimeout(function(){ 
			SliderModule.autoMove(); 
		}, automoveAfter);
	};
	
	return {
		init : init,
		autoMove : autoMove,
		imgMoveAnimate : imgMoveAnimate,
		stopSlider : stopSlider,
		preButtonMove : preButtonMove,
		nxtButtonMove : nxtButtonMove,
		stopTimeout : stopTimeout,
		restartAutomove : restartAutomove
	};
	
})();

$(function(){
	SliderModule.init();
});










