import jQuery from "jquery";
import Component from "@egjs/component";

window.$ = jQuery;

class SlideTimer extends Component {
    constructor(slider) {
        super();
        this.slider = slider;
        this.interval;
        this.timeout;
        this.startTimer();
        this.bindEvents();
    }

    bindEvents() {
        this.slider
            .on('btnClick', this.clearAndResetTimer.bind(this))
            .on('touchStart', this.pauseTimer.bind(this))
            .on('touchEnd', this.resetTimer.bind(this));
        $(window)
            .on('blur', this.pauseTimer.bind(this))
            .on('focus', this.startTimer.bind(this));
    }

    pauseTimer() {
        clearTimeout(this.timeout);
        clearInterval(this.interval);
    }

    startTimer() {
        this.interval = setInterval(this.slider.next.bind(this.slider), 2000);
    }

    resetTimer() {
        this.timeout = setTimeout(this.startTimer.bind(this), 2000);
    }

    clearAndResetTimer() {
        this.pauseTimer();
        this.resetTimer();
    }
};

export {SlideTimer};