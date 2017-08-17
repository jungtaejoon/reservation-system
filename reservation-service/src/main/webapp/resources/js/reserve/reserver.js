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
    }

    function bindTicketsEvents(i, v) {
        v.on('changeCount', changeTotalCount);
    }

    function changeTotalCount() {
        totalCount = ticketArray.reduce(addAll, 0);
        $('#total_count').text(totalCount);
        totalCountCheck();
    }

    function addAll(a, v) {
        return a + v.count;
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

    return {
        init: init
    }
})();

export {Reserver};