(function($) {

    function extend(superClass, def) {
        var extendClass = function extendClass() {
            // Call a parent constructor
            superClass.apply(this, arguments);

            // Call a child constructor
            if (typeof def.init === "function") {
                def.init.apply(this, arguments);
            }
        };

        var ExtProto = function() {};
        ExtProto.prototype = superClass.prototype;

        var extProto = new ExtProto();
        for (var i in def) {
            extProto[i] = def[i];
        }
        extProto.constructor = extendClass;
        extendClass.prototype = extProto;

        return extendClass;
    };





    // Counter Component
    var Counter = extend(eg.Component, {


        init : function(options) {
            this.options = {
                min : 0,
                max : 10,
            }

            this.options = $.extend({}, this.options, options);
           
        },


        _convertPriceRemoveComma : function(price) {
            if(typeof price !== 'string') price += '';
            return price.replace(/[^\d]+/g, '');
        },


        _convertPriceAddComma : function(price) {
            if(typeof price !== 'string') price += '';
            return price.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        },


        // RESERVE EE 'plus' callback
        _incrementHandler : function(param) {
            this._updateView(param, 'increment');
        },


        // RESERVE EE 'minus' callback
        _decrementHandler : function(param) {
            this._updateView(param, 'decrement');
        },


        _updateView : function(param, express) {
            this.options = $.extend({}, this.options, param.product);

            var options = this.options;
            var prices = options.prices;


            var $el = $(param.$elem[0]);
            var $counter = $el.find('input[type="tel"]');
            var $totalPrice = $el.find('.total_price');
            

            var priceType = $el.data('pricetype');
            var discountPrice = prices[priceType-1].discountPrice;
            var price = this._convertPriceRemoveComma(discountPrice);
            var count = this._updateCounter($counter, express);


            var $minusBtn = $counter.closest('.clearfix').find('.ico_minus3');
            var $plusBtn = $counter.closest('.clearfix').find('.ico_plus3');

            if(count == options.min) {
                $counter.addClass('disabled');
                $minusBtn.addClass('disabled');
            }

            if(count > options.min) {
                $counter.removeClass('disabled');
                $minusBtn.removeClass('disabled');
                $plusBtn.removeClass('disabled');
            }

            if(count == options.max) {
                $counter.addClass('disabled');
                $plusBtn.addClass('disabled');
            }

            (count <= options.max && count >= options.min)
                && this._updateTotalPrice(count, price, $totalPrice);
        },


        _updateCounter : function($counter, express) {
            var options = this.options;
            var count = $counter.val();

            (options.max > count) && (express === 'increment') && $counter.val(++count);
            (options.min < count) && (express === 'decrement') && $counter.val(--count);

            return count;
        },


        _updateTotalPrice : function(count, price, $totalPrice) {

            var totalPrice = count * price;
            $totalPrice.text(this._convertPriceAddComma(totalPrice));

        }
    });






    var BookingForm = extend(eg.Component, {

        init : function() {
            this.status = {
                total: 0,
            }
        },


        // RESERVE EE 'update' callback
        _updateTicketHandler : function(param) {
            this.options = $.extend({}, this.optiosn, param.product);
            var options = this.options;

            var $el = $(param.$elem[0]);
            var $wrapper = $el.closest('.section_booking_ticket').find('.qty');

            var total = 0;
            var arr = $wrapper.each( function( index, element ){
                var val = $(this).find('input[type="tel"]').val()*1;
                total += val;
            });

            var text = options.salesStart + '~' + options.salesEnd + ', 총 ' + total + '매';

            $('.inline_txt').text(text);
        },


        // RESERVE EE validation callback
        _validationHandler : function(param) {
            
            var emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            var telRegex = /^\d{11}$/;
            var isValidate = true;
            var $el = param.$elem[0];
            var $confirmBtn = $('.bk_btn_wrap');
            var $checkBox = $('#chk3');

            if($el.id === 'email') {

                if(param.value.length !== 0) {
                    if(!param.value.match(emailRegex))  {  
                        isValidate = false;
                    } else {
                        console.log('Email 형식에 맞춰 주세요');
                    }
                }
            } 
            
            else if ($el.id === 'tel') {
                if(param.value.length === 0) {
                    console.log("Tel은 필수 입력 사항입니다.");
                    isValidate = false;
                } else {
                    if(!param.value.match(telRegex))  {  
                        console.log('정확하게 입력해 주세요');
                        isValidate = false;
                    }
                }
            }

            else if ($el.id === 'name') {
                if(param.value.length === 0) {
                    console.log("name은 필수 입력 사항입니다.");
                    isValidate = false;
                }
            }

            isValidate && $checkBox.prop('checked') && $confirmBtn.removeClass('disable');
            (!isValidate || !$checkBox.prop('checked')) && $confirmBtn.addClass('disable');

        },


        _validationCheckBox : function() {
            var $confirmBtn = $('.bk_btn_wrap');
            $confirmBtn.toggleClass('disable');
        }

    });





    var Reserve = extend(eg.Component, {

        Template : {},
        product : {},
        options : {},


        init : function() {
            this.handlebarInit();
            this.getReservableProduct();
        },


        handlebarInit : function() {

            // Handlebars Convert Cost Helper
            Handlebars.registerHelper('getPrice', function(item) {
                if(item.priceType === 1) {
                    return item.adultCost = '성인(만 19~64세) ' + item.price + '원';
                }
                else if(item.priceType === 2) {
                    return item.teenagerCost = '<br> 청소년(만 13~18세) ' + item.price + '원';
                }
                else if(item.priceType === 3) {
                    return item.kizCost = '<br> 어린이(만 4~12세) ' + item.price + '원';
                }
                else {
                    return item.etcCost = '<br> 국가유공자, 장애인, 65세 이상 ' + item.price + '원';
                }
            });

            /** 
             * 상단 상품 영역
            */
            this.Template.image = Handlebars.compile($('#reserve-image-templ').html());
            this.Template.detail = Handlebars.compile($('#sotre-details-templ').html());

            /**
             * 상품 카운트 영역
             */
            this.Template.counter = Handlebars.compile($('#count-control-templ').html());
        },


        getReservableProduct : function() {
            var url = '/api' + window.location.pathname;
            var result = this.ajaxWrapper('GET', url, null);

            result.then(function(res) {
                var product = this.product = res.product;
                this.ProductInfoRendering(product)
            }.bind(this));
        },


        ProductInfoRendering : function(product) {
            var Templates = this.Template;
            
            this.product.salesStart = this.convertDateFormattoISO(product.salesStart);
            this.product.salesEnd = this.convertDateFormattoISO(product.salesEnd);
            this.product.minCost = this.getMinCost(product.prices).price;
            this.product.deadLineTime = this.getDeadLineTime(product.salesEnd);
            this.product.prices = this.getDiscountPriceRate(product.prices);
            this.product.ticketCount = 3000;

            $('.visual_img').append(Templates.image(this.product));
            $('.section_store_details').append(Templates.detail(this.product));
            $('.ticket_body').append(Templates.counter(this.product));
        },


        convertDateFormattoISO : function(date) {
            var isoDate = new Date(date);
            var dayLabel = ['(일)', '(월)', '(화)', '(수)', '(목)', '(금)', '(토)'];
            var label = dayLabel[isoDate.getDay()];
            var convertedDate = isoDate.toISOString().slice(0,10).replace(/-/g, ".").concat('.' + label);
            return convertedDate;
        },


        getDeadLineTime : function(endDate) {
            var isoDate = new Date(endDate);
            var deadLintTime = new Date(Date.parse(isoDate) - 1800);
            var result = deadLintTime.getHours() + ":" + deadLintTime.getMinutes();
            return '';
        },


        getMinCost : function(costs) {
            return costs.reduce(function(prev, curr) {
                return (prev.price < curr.price ? prev : curr);
            });
        },


        initOptionObject : function(costs) {
            costs.forEach(function(item) {
                if(item.priceType === 1) this.options.adultCost = item.price * 1
                else if(item.priceType === 2) this.options.teenagerCost = item.price * 1
                else if(item.priceType === 3) this.options.kizCost = item.price * 1
                else this.options.etcCost = item.price * 1
            }, this);
        },


        getDiscountPriceRate : function(costs) {
            return costs.map(function(item) {
                item.discountPrice = item.price - item.price * item.discountRate;
                item.discountRate *= 100;
                item.price = this.convertPriceAddComma(item.price);
                item.discountPrice = this.convertPriceAddComma(item.discountPrice);
                return item;
            }.bind(this));
        },


        convertPriceAddComma : function(price) {
            if(typeof price !== 'string') price += '';
            return price.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        },


        convertPriceRemoveComma : function(price) {
            if(typeof price !== 'string') price += '';
            return price.replace(/[^\d]+/g, '');
        },


        ajaxWrapper : function(method, url, data) {
            return $.ajax({
                contentType : 'application/json; charset=UTF-8',
                method : method,
                url : url,
                data : data,
                dataType : 'json',
            });
        },

    });


    /**
     * http://naver.github.io/egjs/latest/doc/eg.Component.html
     * Event Emitter로 Ticket Increment, Decrement 구현
     * 필요한건 .on(), .trigger()
     */

    var bookingForm = new BookingForm();
    var counter = new Counter();
    var reserve = new Reserve();

    reserve.on('increment', counter._incrementHandler.bind(counter));
    reserve.on('decrement', counter._decrementHandler.bind(counter));
    reserve.on('update', bookingForm._updateTicketHandler.bind(bookingForm));
    reserve.on('validation', bookingForm._validationHandler.bind(bookingForm));
    // reserve.on('isChecked', bookingForm._validationCheckBox.bind(bookingForm));
   


    $('.ticket_body').on('click', '.count_control .ico_plus3', function(e){
        e.preventDefault();
        
        var $wrapper = $(e.target).closest('.qty');
        var product = reserve.product;

        var triggerOptions = {
            $elem : $wrapper,
            product : product
        }
        
        reserve.trigger('increment', triggerOptions);
        reserve.trigger('update', triggerOptions);
    });


    $('.ticket_body').on('click', '.count_control .ico_minus3', function(e){
        e.preventDefault()

        var $wrapper = $(e.target).closest('.qty');
        var product = reserve.product;
        
        var triggerOptions = {
            $elem : $wrapper,
            product : product
        }
        
        reserve.trigger('decrement', triggerOptions);
        reserve.trigger('update', triggerOptions);
    });


    $('.inline_control').on('change paste keyup', 'input', function(e) {
        e.preventDefault();

        var triggerOptions = {
            $elem : $(e.target),
            value : $(e.target).val()
        }

        reserve.trigger('validation', triggerOptions);
    });


    $('.section_booking_agreement').on('click', 'input', function(e) {

        var triggerOptions = {
            $elem : $(e.target),
            value : $(e.target).val()
        }

        reserve.trigger('validation', triggerOptions);
    })
    
})($)