import jQuery from 'jquery';
import Component from '@egjs/component';

window.$ = jQuery;

class Ticket extends Component {
    constructor(id) {
        super();
        this.root = '#'+id;
        this.$btnMinus = $(this.root).find('.ico_minus3');
        this.$btnPlus = $(this.root).find('.ico_plus3');
        this.$countInput = $(this.root).find('.count_control_input');
        this.count = 0;
        this.bindEvents();
    }
    
    bindEvents() {
    	this.$btnMinus.on('click', this.clickMinus.bind(this));    	
    	this.$btnPlus.on('click', this.countPlus.bind(this));
    }
    
    clickMinus() {
    	if(this.count === 0){
    		return;
    	}
    	this.countMinus();
    }
    
    countMinus() {
    	this.count--;
    	this.$countInput.val(this.count);
    	if(this.count === 0){
    		this.$btnMinus.addClass('disabled');
    		this.$countInput.addClass('disabled');		
    	}
    	this.setTotalPrice();
    }
    
    countPlus() {
    	this.count++;
    	this.$countInput.val(this.count);
    	if(this.$btnMinus.hasClass('disabled')){
    		this.$btnMinus.removeClass('disabled');
    		this.$countInput.removeClass('disabled');	
    	}
    	this.setTotalPrice();
    }
     
    setTotalPrice() {
    	var totalPrice = this.count * parseInt($(this.root).find('.price').text().replace(',', ''));
    	$(this.root).find('.total_price').text(totalPrice);
    }
}

export {Ticket};