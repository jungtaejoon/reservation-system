$(function() {
	var slider = new Slider('#main_slider', {
		max: 2,
		prevButton: '.prev_e',
		nextButton: '.nxt_e'
	});
	var slideTimer = new SlideTimer(slider);
    CategoryList.init();
});



