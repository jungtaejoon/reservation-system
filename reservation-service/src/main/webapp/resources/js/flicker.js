class Flicker extends eg.Component {
    constructor(slider, option) {
        super();
        this.slider = slider;
        this.option = option || {};
        this.moveGapX;
        this.touchStartPointX;
        this.bindEvents();
    }

    bindEvents() {
        $(this.slider.rootDOM)
            .on('touchstart', this.slider.toBeMovedDOM, this.viewerTouchStart.bind(this))
            .on('touchmove', this.slider.toBeMovedDOM, this.viewerTouchMove.bind(this))
            .on('touchend', this.slider.toBeMovedDOM, this.viewerTouchEnd.bind(this));
    }

    viewerTouchStart(e) {
        this.slider.touchStartTrigger();
        $(this.slider.SUB_LAYER).addClass('touch');
        var event = e.originalEvent;
        this.moveGapX = 0;
        this.touchStartPointX = event.changedTouches[0].screenX;
        e.preventDefault();
    }

    viewerTouchMove(e) {
        var event = e.originalEvent;
        this.moveGapX = this.touchStartPointX - event.changedTouches[0].screenX;
        $(this.slider.toBeMovedDOM).css('transform', 'translateX(' + -this.moveGapX + 'px)');
        e.preventDefault();
    }

    viewerTouchEnd(e) {
        this.slider.touchEndTrigger()
        if (this.moveGapX < -50) {
            $(this.slider.BUTTON_WRAPPER).addClass('invisible');
            this.slider.prev();
        }
        if (this.moveGapX > 50) {
            $(this.slider.BUTTON_WRAPPER).addClass('invisible');
            this.slider.next();
        }
        if (this.moveGapX === 0) {
            $(this.slider.BUTTON_WRAPPER).removeClass('invisible');
        }
        $(this.slider.toBeMovedDOM).css('transform', 'translateX(0px)');
        e.preventDefault();
    }
}