			class ReserveCounter extends eg.Component {
				constructor(target)	{
					super();
					this.target = target;
				}
				minus(e) {
					var target = $(e.target).siblings('input');
					if(target.val() == 0) {return;}
					target.val(Number(target.val()) - 1);
					this.trigger('changeValue', target);
					if(target.val() == 0) {this.trigger('inputZero', target);}
				}
				plus(e) {
					var target = $(e.target).siblings('input');
					target.val(Number(target.val()) + 1);
					this.trigger('changeValue', target);
					if(target.val() == 1) {this.trigger('notZero', target)}
				}
				changeValue(target) {
					var price = target.closest('.qty').find('.price').html().replace(/,/g, '');
					var total = target.val() * price;
					var reg = /(^[+-]?\d+)(\d{3})/;
					total += '';
					total = total.replace(reg, '$1' + ',' + '$2');
					target.closest('.count_control').find('.total_price').html(total);
					var totalCount = 0;
					$.each($('.count_control_input'), function() {
						totalCount += Number($(this).val());
					});
					$('#total_count').html(totalCount);
					this.confirm.trigger('changeValue');
				}
				lock(target) {
					target.closest('.count_control').children('.individual_price').removeClass('on_color');
					target.addClass('disabled');
					target.siblings('.ico_minus3').addClass('disabled');
				}
				unlock(target) {
					target.closest('.count_control').children('.individual_price').addClass('on_color');
					target.parent().children().removeClass('disabled');
				}
				bindEvents() {
					$('.ico_minus3').on('click', this.minus.bind(this));
					$('.ico_plus3').on('click', this.plus.bind(this));
				}
				onTrigger() {
					this.on('inputZero', this.lock)
						.on('notZero', this.unlock)
						.on('changeValue', this.changeValue);
				}
				init(target) {
					this.bindEvents();
					this.onTrigger();
					this.confirm = new ReserveUserConfirmation(target);
					this.confirm.init();
				}
			}