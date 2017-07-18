var slider = function(target, needInterval){
    var childWidth = target.children().outerWidth();
    var slideLoop;
    if(needInterval) {
    	slideLoop = setInterval(next, 2000);
    	$(window).blur(function() {
    		clearInterval(slideLoop);
    	});
    	$(window).focus(function() {
    		slideLoop = setInterval(next, 2000);
    	});
    }
    (function prepareFirst() {
    	var repeat = 1;
    	if(target.children().length > 5) repeat = 2;
    	for(var i = 0; i < repeat; i++) prepareLeft();
    })(); 
	function prepareLeft() {
		target.prepend(target.children().last().clone());
		target.animate({left: '-=' + childWidth}, 0);
		target.children().last().remove();
	}
	function prepareRight() {
		target.append(target.children().first().clone());
		target.animate({left: '+=' + childWidth}, 0);
		target.children().first().remove();
	}
	function next() {
		target.animate({
		    left: '-=' + childWidth
		}, {duration: 500, 
			complete: prepareRight
		});
	}
	function prev() {
		target.animate({
		    left: '+=' + childWidth
		}, {duration: 500, 
			complete: prepareLeft
		});
	}
	function waitAndSlide() {
		clearInterval(slideLoop);
		setTimeout(function(){
			clearInterval(slideLoop);
			slideLoop = setInterval(next, 2000);
		}, 2000);
	}
	return {
		next: function() {
			next();
			if(needInterval) waitAndSlide();
		},
		prev: function() {
			prev();
			if(needInterval) waitAndSlide();
		}
	}
}