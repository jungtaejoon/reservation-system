(function(AutoSlidingModule){
	var $group_visual = $('div.group_visual');
	
	var $btn_pre = $group_visual.find('a.btn_prev');
	var $btn_nxt = $group_visual.find('a.btn_nxt');
	
    var $sliding_ul = $('ul.visual_img');	// 프로모션 영역 ul
	
	if(AutoSlidingModule !== undefined){
		AutoSlidingModule.init(false);
		
		$btn_pre.on("click", function(event){
			if(!$sliding_ul.hasClass("active")){
				AutoSlidingModule.prevSliding();
			}
		});

		// 오토 슬라이딩을 멈추고 우측으로 슬라이딩
		$btn_nxt.on("click", function(event){
			if(!$sliding_ul.hasClass("active")){
				AutoSlidingModule.nextSliding();
			}
		});
	}
})(AutoSlidingModule);