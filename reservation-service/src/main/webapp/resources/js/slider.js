class Slider extends eg.Component {
	constructor(id, option) {
		super();
	    this.id = id;
	    this.option = option;
	    this.maxIndex = option.max;
	    this.currentIndex = 0;
	    this.isMoving = false;
	    this.moveRange = 338;
	    this.bindEvents();
	}
	bindEvents() {
		$(this.id).on('click', this.option.prevButton, this.clickPrev.bind(this));
		$(this.id).on('click', this.option.nextButton, this.clickNext.bind(this));
	}
	clickPrev() {
		if(this.isMoving) {
			return;
		}
		this.trigger('btnClick');
		this.prev();
	}
	clickNext() {
		if(this.isMoving) {
			return;
		}
		this.trigger('btnClick');
		this.next();
	}
	prev() {
		if(this.currentIndex > 0) {
			this.currentIndex--;
		} else if (this.currentIndex === 0) {
			this.currentIndex = (this.maxIndex - 1);
		}
		this.move();
	}
	next() {
		if(this.currentIndex < this.maxIndex - 1) {
			this.currentIndex++;
		} else if (this.currentIndex === this.maxIndex - 1) {
			this.currentIndex = 0;
		}
		this.move();
	}
	move() {
		this.isMoving = true;
		$(this.id).find('ul.visual_img').animate({left: -(this.currentIndex * this.moveRange)}, this.endMove.bind(this));
	}
	endMove() {
		this.isMoving = false;
	}
	
}