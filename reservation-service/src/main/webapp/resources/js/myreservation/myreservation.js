import jQuery from "jquery";

window.$ = jQuery;

var MyReservation = (function() {
	var summaryBoard = '.summary_board';
	var summaryIndex = 0;
	var id;
	function init() {
		bindEvents();
	}

	function bindEvents() {
		$(summaryBoard).on('click', 'li', clickSummary);
		$('.booking_cancel.cancel').on('click', clickReservationiCancle);
		$('.booking_cancel.used').on('click', clickCommentWrite);
		$('.pop_bottom_btnarea').on('click', '.btn_green', clickPopUpBtnYes);
		$('.pop_bottom_btnarea').on('click', '.btn_gray', clickPopUpBtnNo);
		$('.popup_btn_close').on('click', clickPopUpBtnNo);
	}

	function clickSummary(e) {
		$('.link_summary_board:eq(' + summaryIndex + ')').removeClass('on');
		summaryIndex = $(summaryBoard).find(e.currentTarget).index();
		$('.link_summary_board:eq(' + summaryIndex + ')').addClass('on');
		setReservationList();
	}

	function setReservationList() {
		if (summaryIndex === 0) {
			$('.list_cards .card').removeClass('invisible');
		} else {
			$('.list_cards .card').addClass('invisible');
			$('.list_cards .card:eq(' + summaryIndex + ')').removeClass('invisible');
			if (summaryIndex === 1) {
				$('.list_cards .card:eq(0)').removeClass('invisible');
			}
		}
	}
	
	function clickReservationiCancle(e){
		id = $(this).data('reservation-id');
		$('.popup_booking_wrapper').removeClass('invisible');
		$('.pop_tit span').text($(this).closest('.card_detail').find('.tit').text());
		$('.pop_tit .sm').text($(this).closest('.card_detail').find('.item_reservation_date').text());
	}
	
	function clickCommentWrite(){
		location.href = '/comment-write?reservationId='+$(this).data('reservation-id');
	}
	
	function clickPopUpBtnYes(){
		$.ajax({
			method:'delete',
			url :'/reservations/'+id,
			success : function(res){
				location.href = '/my-reservation';
			}
		});
	}
	
	function clickPopUpBtnNo(){
		$('.popup_booking_wrapper').addClass('invisible');
	}

	return {
		init : init
	}
})();

$(function() {
	MyReservation.init();
});