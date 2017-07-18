define(['jquery'], function($) {
		"use strict";
		function Rolling (parentSelector, rollingSelector, userOption) {
		  this.parentSelector = parentSelector;
		  this.rollingSelector = rollingSelector;
		  this.rollingWidth= parseInt($(rollingSelector).outerWidth());
		  this.option = userOption ? this.setOption(userOption) : defaultOption;
		  this.number = $(parentSelector + ">" + rollingSelector).length;
		  this.maxMargin = parseInt(this.rollingWidth * (this.number - 1 )* -1);
		  this.intervalId;

		  if(this.option.autoSlide)
		    this.autoSliding();
		  if(this.option.prevBtn)
		    this.addPrevBtnListener();
		  if(this.option.nextBtn)
		    this.addNextBtnListener();
		};

		//디폴트 옵션
		var defaultOption = {
		   autoSlide : true,
		   autoSlideSecond : 2000,
		   circular : true,
		   prevBtn : "",
		   nextBtn : "",
		   animateSpeed : 2000
		};

		// 사용자가 입력한 옵션 + 디폴트 옵션 추가
		Rolling.prototype.setOption = function(userOption) {
		  $.each(defaultOption, function(index, value) {
		    if(!userOption.hasOwnProperty(index))
		      userOption[index]=value;
		  });
		  return userOption;
		}

		Rolling.prototype.addPrevBtnListener = function () {
		  $(this.option.prevBtn).on("click", this.prevBtnListener.bind(this) );
		}

		Rolling.prototype.addNextBtnListener = function () {
		  $(this.option.nextBtn).on("click", this.nextBtnListener.bind(this) );
		}

		// this는 Rolling의 인스턴스
		Rolling.prototype.prevBtnListener = function(e) {
		  e.preventDefault();
		  if(this.checkCanPress()) {
		    this.slidingBack();
		    this.resetInterval();
		    //4초후 실행  (2초 기다리고 실행)
		    setTimeout(this.autoSliding.bind(this),2000)
		  }
		}

		// this는 Rolling의 인스턴스
		Rolling.prototype.nextBtnListener = function(e) {
		  e.preventDefault();
		  if(this.checkCanPress()) {
		    this.sliding();
		    this.resetInterval();

		    //4초후 실행 (2초 기다리고 실행)
		    setTimeout(this.autoSliding.bind(this),2000)
		  }
		}

		Rolling.prototype.resetInterval = function() {
		    clearInterval(this.intervalId);
		    this.intervalId = null;
		}

		Rolling.prototype.checkCanPress = function() {
		  var currentMargin = this.getMarginLeft();
		  return (currentMargin % this.rollingWidth*-1 === 0 ) ? true : false;
		}

		Rolling.prototype.checkCanSlide = function() {
		  var currentMargin = this.getMarginLeft();
		  return (currentMargin > this.maxMargin) ? true : false;
		}

		Rolling.prototype.autoSliding= function () {
		  if(this.intervalId)
		    return;
		  if(this.option.autoSlide) {
		    this.intervalId = setInterval(
		      this.sliding.bind(this), this.option.autoSlideSecond);
		    };
		}

		Rolling.prototype.sliding = function () {
		  var currentMargin = this.getMarginLeft();
		  // 슬라이드 할 수 있는지 체크
		  if(this.checkCanSlide()) {
		    $(this.parentSelector).animate({"margin-left" : "+="+this.rollingWidth*-1});
		  }
		  else {
		    // 순환 옵션이면 처음으로 돌아감
		    if(this.option.circular)
		      $(this.parentSelector).animate({"margin-left" : 0}, this.option.a);
		    // 멈춤
		    else
		      this.resetInterval();
		  }
		}

		Rolling.prototype.slidingBack = function () {
		  var currentMargin = this.getMarginLeft();
		  if (currentMargin!=0)
		    $(this.parentSelector).animate({"margin-left" : "+="+this.rollingWidth});
		}

		Rolling.prototype.getMarginLeft = function () {
		  return parseInt($(this.parentSelector).css("margin-left"));
		}

		var exports = Rolling
		return exports;
});
