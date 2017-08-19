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
        $('button.bk_btn').on('click', checkButton);
        $(tickets).each((i, v) => v.on('changeCount', changeTotalCount));
    }

    function changeTotalCount() {
        totalCount = ticketArray.reduce((a, v) => a + v.count, 0);
        $('#total_count').text(totalCount);
        totalCountCheck();
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
        var regTelNum = /(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/;
        var regTel = /^\d{2,3}-\d{3,4}-\d{4}$/;
        var num = $(this).val();
        if (regNum.test($(this).val())) {
            num = num.replace(regTelNum, "$1-$2-$3");
        } else {
            num = num.replace(regDash, '');
            num = num.replace(regTelNum, "$1-$2-$3");
        }
        $(this).val(num);
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
        if ($('div.bk_btn_wrap').hasClass('disable')) {
            return;
        } else {
            makeReservation();
        }
    }

    function makeReservation() {
        var obj = {
            productId: $('#container').data('product-id'),
            generalTicketCount: ticketArray[0].count,
            youthTicketCount: ticketArray[1].count,
            childTicketCount: ticketArray[2].count,
            reservationName: $('#name').val(),
            reservationEmail: $('#email').val(),
            reservationTel: $('#tel').val(),
            reservationDate: $('#reservation_date').text(),
            reservationType: 1,
            totalPrice: ticketArray.reduce((a, v) => a + parseInt(v.totalPrice), 0)
        };

        $.ajax({
            method: 'post',
            data: JSON.stringify(obj),
            contentType: 'application/json; charset=utf-8',
            url: '/reservations',
            success: response => {
                if (response === 1) {
                    location.href = '/my-reservation';
                } else {
                    alert('뭔가 잘못되었습니다. ^^;');
                }
            },
            error: (request, status, error) => {
                console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    }

    return {
        init: init
    }
})();

export {Reserver};