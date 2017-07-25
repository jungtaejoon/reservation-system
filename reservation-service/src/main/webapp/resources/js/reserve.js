$(function(){
    RESERVE.init();
});

var RESERVE = (function($, doc){
    var baseURI = window.location.origin;
    var pathName = window.location.pathname;
    var ticketArr = [];
    var productArr = [];

    var init = function(){
        var promise = $.ajax(baseURI + "/api" + pathName, {
            type: "GET"
        });
        promise.then(attachTemplate);
        promise.then(ticketInit);
        promise.then(addTicketEvents);
    };

    var addTicketEvents = function(){
        $('.qty').each(function(index){
            $(this).find('a.btn_plus_minus:eq(0)').on("click", function(evt){
                evt.preventDefault();
                ticketArr[index].trigger("ticketDown");
            });
            $(this).find('a.btn_plus_minus:eq(1)').on("click", function(evt){
                evt.preventDefault();
                ticketArr[index].trigger("ticketUp");
            });
        });
    }

    var attachTemplate = function(data){
        $('.ct_wrap').html(Handlebars.templates['reserving'](data));
        productArr = data.productPrices;
    };

    function Ticket(element, type, price, discount){
        this.$container = $(element);
        this.count = 0;
        this.totalPrice = 0;
        this.price = price || 10000;
        this.type = type || 1;
        this.discount = discount || 0;
    }

    Ticket.prototype = new eg.Component();
    Ticket.prototype.constructor = Ticket;
    Ticket.prototype.up = function(){
        this.count++;
        this.totalPrice += this.price*(1-this.discount);
    };
    Ticket.prototype.down = function(){
        this.count--;
        this.totalPrice -= this.price*(1-this.discount);
    };
    Ticket.prototype.update = function(){
        this.$container.find('.count_control_input').val(this.count);
        this.$container.find('.total_price').text(this.totalPrice);
    }

    var ticketInit = function(){
        $('.qty').each(function(index){
            var pp = productArr[index];
            ticketArr[index] = new Ticket(this, pp.priceType, pp.price, pp.discountRate);
        });

        function upCallback(e){
            this.up();
            this.update();
        };

        function downCallback(e){
            this.down();
            this.update();
        }

        ticketArr[0].on("ticketUp", upCallback);
        ticketArr[0].on("ticketDown", downCallback);

    }

    return {
        init: init
    }

})(jQuery, document);