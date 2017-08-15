class Slider extends eg.Component {
    constructor(id, option) {
        super();
        this.id = id;
        this.option = option;
        this.maxIndex = option.max - 1;
        this.moveRange = option.moveRange;
        this.stopOption = option.stopOption || false;
        this.currentIndex = 0;
        this.isMoving = false;
        this.rootDOM = id;
        this.toBeMovedDOM = 'ul.visual_img';
        this.bindEvents();
    }

    bindEvents() {
        $(this.id).on('click', this.option.prevButton, this.clickPrev.bind(this));
        $(this.id).on('click', this.option.nextButton, this.clickNext.bind(this));
    }

    clickPrev() {
        if (this.isMoving) {
            return;
        }
        this.trigger('btnClick');
        this.prev();
    }

    clickNext() {
        if (this.isMoving) {
            return;
        }
        this.trigger('btnClick');
        this.next();
    }

    prev() {
        if (this.currentIndex > 0) {
            this.currentIndex--;
        } else if (this.currentIndex === 0) {
            if (this.stopOption) {
                return;
            }
            this.currentIndex = this.maxIndex;
        }
        this.move();
    }

    next() {
        if (this.currentIndex < this.maxIndex) {
            this.currentIndex++;
        } else if (this.currentIndex === this.maxIndex) {
            if (this.stopOption) {
                return;
            }
            this.currentIndex = 0;
        }
        this.move();
    }

    move() {
        this.isMoving = true;
        $(this.toBeMovedDOM).animate({left: -(this.currentIndex * this.moveRange)}, this.endMove.bind(this));
    }

    endMove() {
        this.isMoving = false;
        this.trigger('moveEnd');
    }

    touchStartTrigger() {
        this.trigger('touchStart');
    }

    touchEndTrigger() {
        this.trigger('touchEnd')
    }

}