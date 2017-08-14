class SliderPanel extends eg.Component {
	constructor(panel, slider) {
		super();
		this.panel = panel;
	    this.slider = slider;
	    this.bindEvents();
	}
	bindEvents() {
		this.slider.on('moveEnd', this.refreshPanel.bind(this));
	}
	refreshPanel() {
		$(this.panel).text(this.slider.currentIndex + 1);
		if(this.slider.currentIndex === 0) {
			console.log('first')
		} else if (this.slider.currentIndex === this.slider.maxIndex - 1) {
			console.log('last')
			
		} else {
			console.log('else')
			
		}
	}
}