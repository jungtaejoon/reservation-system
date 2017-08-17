import jQuery from "jquery";

window.$ = jQuery;

var Reserver = (function () {
    var validation = {
        name: false,
        email: false,
        tel: false,
        agreement: false,
        totalCount: false
    };
    var ticketArray;
    var totalCount = 0;

    function init(tickets) {
        ticketArray = tickets;
        bindEvents(tickets);
        nameCheck.apply($('#name').get(0));
        telCheck.apply($('#tel').get(0));
        emailCheck.apply($('#email').get(0));
        agreementCheck.apply($('#agreement').get(0));
    }

    function bindEvents(tickets) {
        $('#name').on('keyup', nameCheck);
        $('#tel').on('keyup', telCheck);
        $('#email').on('keyup', emailCheck);
        $('#chk3').on('click', agreementCheck);
        $('a.btn_agreement').on('click', toggleOpen);
        $(tickets).each(bindTicketsEvents);
        $('button.bk_btn').on('click', checkButton);
    }

    function bindTicketsEvents(i, v) {
        v.on('changeCount', changeTotalCount);
    }

    function changeTotalCount() {
        totalCount = ticketArray.reduce(addAllCount, 0);
        $('#total_count').text(totalCount);
        totalCountCheck();
    }

    function addAllCount(a, v) {
        return a + v.count;
    }

    function addAllTotalPrice(a, v) {
        return a + parseInt(v.totalPrice);
    }

    function toggleOpen() {
        $(this).find('i').toggleClass('fn-up2 fn-down2');
        $(this).closest('div.agreement').toggleClass('open');
    }

    function nameCheck() {
        if ($(this).val()) {
            validation['name'] = true;
        } else {
            validation['name'] = false;
        }
        checkAll();
    }

    function telCheck() {
        var regNum = /^[0-9]+$/;
        var regDash = /[\-]/gi;
        if (regNum.test($(this).val())) {
            var num = $(this).val();
            num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/, "$1-$2-$3");
            $(this).val(num);
        } else {
            var num = $(this).val();
            num = num.replace(regDash, '');
            num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/, "$1-$2-$3");
            $(this).val(num);
        }
        var regTel = /^\d{2,3}-\d{3,4}-\d{4}$/;
        validation['tel'] = regTel.test($(this).val());
        checkAll();
    }

    function emailCheck() {
        var reg = /^[\w]([-_\.]?[\w])*@[\w]([-_\.]?[\w])*\.[a-zA-Z]{2,3}$/i;
        validation['email'] = reg.test($(this).val());
        checkAll();
    }

    function agreementCheck() {
        validation['agreement'] = $(this).prop('checked');
        checkAll();
    }

    function totalCountCheck() {
        validation['totalCount'] = parseInt($('#total_count').text()) !== 0;
        checkAll();
    }

    function checkAll() {
        if (validation['agreement'] && validation['email'] && validation['tel'] && validation['name'] && validation['totalCount']) {
            $('div.bk_btn_wrap').removeClass('disable');
        } else {
            $('div.bk_btn_wrap').addClass('disable');
        }
    }

    function checkButton() {
        if($('div.bk_btn_wrap').hasClass('disable')) {
            return;
        } else {
            makeReservation();
        }
    }
    
    function makeReservation() {

        var productId = $('#container').data('product-id');
        var reservationName = $('#name').val();
        var reservationTel = $('#tel').val();
        var reservationEmail = $('#email').val();
        var reservationDate = $('#reservation_date').text();
        var generalTicketCount = ticketArray[0].count;
        var youthTicketCount = ticketArray[1].count;
        var childTicketCount = ticketArray[2].count;
        var totalPrice = ticketArray.reduce(addAllTotalPrice, 0);
        var obj = {
            productId: productId,
            generalTicketCount: generalTicketCount,
            youthTicketCount: youthTicketCount,
            childTicketCount: childTicketCount,
            reservationName: reservationName,
            reservationEmail: reservationEmail,
            reservationTel: reservationTel,
            reservationDate: reservationDate,
            totalPrice: totalPrice
        };

        $.ajax()
    }

    return {
        init: init
    }
})();

export {Reserver};