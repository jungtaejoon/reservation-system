class ReserveUserConfirmation extends eg.Component {
				constructor(target) {
					super();
				    this.target = target;
				}
				toggleParent() {
					$(this).parent().toggleClass('open');
					$(this).children('i').toggleClass('fn-down2').toggleClass('fn-up2');
				}
				validate() {
					var pass = true;
					$.each(this.target.find('input'), function() {
						if(!$(this).val()) {pass = false;}
						if($(this).prop('id') === 'email') {
							var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
							if(!reg.test($(this).val())) {pass = false;}
						}
						if($(this).prop('id') === 'tel') {
							var regNum = /^[0-9]+$/;
							var regDash = /[\-]/gi;
							if(regNum.test($(this).val())) {
								var num = $(this).val();
								num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
								$(this).val(num);
							} else {
								var num = $(this).val();
								num = num.replace(regDash, '');
								num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
								$(this).val(num);
							}
							var regTel = /^\d{2,3}-\d{3,4}-\d{4}$/;
							if(!regTel.test($(this).val())) {pass = false;}
						}
						if($(this).prop('id') === 'chk3') {
							if(!$(this).prop('checked')) {pass = false;}
						}
					});
					if(Number(this.target.find('#total_count').html()) <= 0) {pass = false;}
					if(pass) {this.trigger('pass');}
					else {this.trigger('notPass')}
				}
				unlock() {
					this.target.parent().find('.bk_btn_wrap').removeClass('disable');
				}
				lock() {
					this.target.parent().find('.bk_btn_wrap').addClass('disable');
				}
				confirm() {
					if($(this).hasClass('disable')) {
						return;
					} else {
						console.log('confirmed');
					}
				}
				bindEvents() {
					$('.btn_agreement').on('click', this.toggleParent);
					$('#chk3').on('click', this.validate.bind(this));
					this.target.find('input').on('keyup', this.validate.bind(this));
					this.target.parent().find('.bk_btn_wrap').on('click', this.confirm);
				}
				onTrigger() {
					this.on('pass', this.unlock);
					this.on('notPass', this.lock);
					this.on('changeValue', this.validate);
				}
				init(target) {
					this.bindEvents();
					this.onTrigger();
				}
			}
			