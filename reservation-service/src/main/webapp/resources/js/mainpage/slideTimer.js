class SlideTimer extends eg.Component {
	constructor(slider) {
		super();
		this.slider = slider;
		this.interval;
		
		this.startTimer();
		this.bindEvents();
	}
	bindEvents() {
		this.slider.on('btnClick', this.pauseTimer.bind(this));
	}
	startTimer() {
		this.interval = setInterval(this.slider.next.bind(this.slider), 2000);
	}
	pauseTimer() {
		clearInterval(this.interval);
		setTimeout(this.startTimer.bind(this), 4000);
	}
};