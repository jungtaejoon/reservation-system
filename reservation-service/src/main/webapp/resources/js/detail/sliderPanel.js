class SliderPanel extends eg.Component {
	constructor(panel, slider) {
		super();
		this.panel = panel;
	    this.slider = slider;
	    
	    if(this.slider.maxIndex == 0) {
	    	$(this.slider.option.nextButton).find('i').addClass('off');
	    }
	    else {
	    	this.bindEvents();
	    }
	}
	bindEvents() {
		this.slider.on('moveEnd', this.refreshPanel.bind(this));
	}
	refreshPanel() {
		$(this.panel).text(this.slider.currentIndex + 1);
		if(this.slider.currentIndex === 0) {
			$(this.slider.option.prevButton).find('i').addClass('off');
		} else if (this.slider.currentIndex === this.slider.maxIndex) {
			$(this.slider.option.nextButton).find('i').addClass('off');
		} else {
			$(this.slider.option.prevButton).find('i.off').removeClass('off');
			$(this.slider.option.nextButton).find('i.off').removeClass('off');
		}
	}
}