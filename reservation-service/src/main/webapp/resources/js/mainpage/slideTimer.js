class SlideTimer extends eg.Component {
	constructor(slider) {
		super();
		this.slider = slider;
		this.interval;
		this.timeout;
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
		clearTimeout(this.timeout);
		clearInterval(this.interval);
		this.timeout = setTimeout(this.startTimer.bind(this), 2000);
	}
};