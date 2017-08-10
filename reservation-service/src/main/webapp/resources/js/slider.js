class Slider extends eg.Component {
	constructor(id, option) {
		super();
	    this.id = id;
	    this.option = option;
	    this.maxIndex = option.max;
	    this.currentIndex = 0;
	    this.moveRange = 338;
	    this.bindEvents();
	}
	bindEvents() {
		$(this.id).on('click', this.option.prevButton, this.prev.bind(this));
		$(this.id).on('click', this.option.nextButton, this.next.bind(this));
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
		$(this.id).find('ul.visual_img').animate({left: -(this.currentIndex * this.moveRange)});
	}
	
}