var Detail = (function() {
	function init() {
		bindEvents();
	}
	function bindEvents() {
		$('.section_store_details').on('click', '.bk_more', toggleMoreButton);
		$('.info_tab_lst .item').on('click', 'a.anchor', toggleTab);
	}
	function toggleMoreButton() {
		$('.store_details').toggleClass('close3');
		$('.bk_more').toggleClass('invisible');
	}
	function toggleTab(e) {
		if(!$(e.currentTarget).hasClass('active')) {
			$('.info_tab_lst a').toggleClass('active');
			$('div.detail_common').toggleClass('hide');
		}
	}
	return {
		init: init
	}
})();
$(function() {
	Detail.init();
});




