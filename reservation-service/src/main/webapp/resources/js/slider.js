var Slider = (function(){
	var target;
    var childWidth;
    var slideNum = 1;
    var slideCounts;
    var slideLoop;
    var needInterval = false;
    function init(interval) {
    	target = $('#slider');
    	needInterval = interval;
    	childWidth = target.children().outerWidth();
    	slideCounts = target.children().length;
    	prepareFirst();
    	bindEvents();
    	if(needInterval) {
    		intervalSetter();
    		$(window).blur(intervalCleaner.bind(this));
    		$(window).focus(intervalSetter.bind(this));
    	}
    }
    function intervalSetter() {
    	slideLoop = setInterval(next, 2000);
    }
    function intervalCleaner() {
    	clearInterval(slideLoop);
    }
    function bindEvents() {
    	$('#btn_nxt').on('click', clickNext.bind(this));
    	$('#btn_pre').on('click', clickPrev.bind(this));
    }
    function clickNext() {
    	next();
    	if(needInterval) {waitAndSlide();}
    }
    function clickPrev() {
    	prev();
    	if(needInterval) {waitAndSlide();}
    }
    function prepareFirst() {
    	var repeat = 0;
    	if(target.children().length > 5) repeat = 2;
    	else if(target.children().length > 2) repeat = 1;
    	for(var i = 0; i < repeat; i++) prepareLeft();
    }
	function prepareLeft() {
		target.prepend(target.children().last());
		target.animate({left: '-=' + childWidth}, 0);
	}
	function prepareRight() {
		target.append(target.children().first());
		target.animate({left: '+=' + childWidth}, 0);
	}
	function next() {
		if(slideCounts <= 1) {return;}
		if(target.is(':animated')) {return;}
		target.animate({
		    left: '-=' + childWidth
		}, {duration: 500, 
			complete: prepareRight
		});
		if(slideNum == slideCounts) {
			slideNum = 1;
		} else {
			slideNum++;
		}
		$('#slideNum').html(slideNum);
	}
	function prev() {
		if(slideCounts <= 1) {return;}
		if(target.is(':animated')) {return;}
		prepareLeft();
		target.animate({
		    left: '+=' + childWidth
		}, {duration: 500});
		if(slideNum == 1) {
			slideNum = slideCounts;
		} else {
			slideNum--;
		}
		$('#slideNum').html(slideNum);
	}
	function waitAndSlide() {
		intervalCleaner();
		setTimeout(function(){
			intervalCleaner();
			intervalSetter();
		}, 2000);
	}
	return {
		init: init,
	}
})();