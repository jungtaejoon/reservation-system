$(function() {
	var slider = new Slider('#main_slider', {
		max: 2,
		prevButton: '.prev_e',
		nextButton: '.nxt_e',
		moveRange: 338
	});
	var slideTimer = new SlideTimer(slider);
    CategoryList.init();
});



