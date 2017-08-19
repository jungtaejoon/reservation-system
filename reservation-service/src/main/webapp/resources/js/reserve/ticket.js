import jQuery from 'jquery';
import Component from '@egjs/component';

window.$ = jQuery;

class Ticket extends Component {
    constructor(id) {
        super();
        this.root = id;
        this.$btnMinus = $(this.root).find('.ico_minus3');
        this.$btnPlus = $(this.root).find('.ico_plus3');
        this.$countInput = $(this.root).find('.count_control_input');
        this.count = 0;
        this.price = parseInt($(this.root).find('.price').text().replace(',', ''));
        this.totalPrice = 0;
        this.$indPrice = $(this.root).find('.individual_price');
        this.bindEvents();
    }

    bindEvents() {
        this.$btnMinus.on('click', this.clickMinus.bind(this));
        this.$btnPlus.on('click', this.countPlus.bind(this));
    }

    clickMinus() {
        if (this.count === 0) {
            return;
        }
        this.countMinus();
    }

    countMinus() {
        this.count--;
        this.$countInput.val(this.count);
        if (this.count === 0) {
            this.$btnMinus.addClass('disabled');
            this.$countInput.addClass('disabled');
        }
        this.setTotalPrice();
    }

    countPlus() {
        this.count++;
        this.$countInput.val(this.count);
        if (this.$btnMinus.hasClass('disabled')) {
            this.$btnMinus.removeClass('disabled');
            this.$countInput.removeClass('disabled');
        }
        this.setTotalPrice();
    }

    setTotalPrice() {
        this.totalPrice = this.count * this.price;
        $(this.root).find('.total_price').text(this.threeComma(this.totalPrice));
        if (this.totalPrice && !this.$indPrice.hasClass('on_color')) {
            this.$indPrice.addClass('on_color');
        } else if (!this.totalPrice && this.$indPrice.hasClass('on_color')) {
            this.$indPrice.removeClass('on_color');
        }
        this.trigger('changeCount');
    }

    threeComma(num) {
        var reg = /(^[+-]?\d+)(\d{3})/;
        num += '';
        while (reg.test(num)) {
            num = num.replace(reg, '$1' + ',' + '$2');
        }
        return num;
    }
}

export {Ticket};