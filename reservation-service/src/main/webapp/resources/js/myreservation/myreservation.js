var MyReservation = (function() {
	var summaryBoard = '.summary_board';
	var summaryIndex = 0;
	function init() {
		bindEvents();
	}

	function bindEvents() {
		$(summaryBoard).on('click', 'li', clickSummary);
	}
	
	function clickSummary(e){
		$('.link_summary_board:eq('+summaryIndex+')').removeClass('on');
		summaryIndex = $(summaryBoard).find(e.currentTarget).index();
		$('.link_summary_board:eq('+summaryIndex+')').addClass('on');
		setReservationList();
	}
	
	function setReservationList(){
		console.log("aaa");
		if(summaryIndex === 0){
			$('.list_cards .card').removeClass('invisible');
		}else {
			$('.list_cards .card').addClass('invisible');
			$('.list_cards .card:eq('+summaryIndex+')').removeClass('invisible');
			if(summaryIndex === 1){
				$('.list_cards .card:eq(0)').removeClass('invisible');
			}
		}

	}
	
	return {
		init : init
	}
})();


$(function () {
	MyReservation.init();
});