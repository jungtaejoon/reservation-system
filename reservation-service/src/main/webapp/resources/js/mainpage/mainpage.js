$(function() {
	var slider = new Slider('#main_slider', {
		max: 3,
		prevButton: '.prev_e',
		nextButton: '.nxt_e'
	});
	var slideTimer = new SlideTimer(slider);
    CategoryList.init();
});



