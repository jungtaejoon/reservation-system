(function(AutoSlidingModule){
    var $promotion_area = $('div.container_visual');

    var $btn_pre = $promotion_area.find('.btn_pre_e');
    var $btn_nxt = $promotion_area.find('.btn_nxt_e');

    var $sliding_ul = $('ul.visual_img');	// 프로모션 영역 ul

    if(AutoSlidingModule !== undefined){
        AutoSlidingModule.init(true);

        $btn_pre.on("mouseenter", AutoSlidingModule.pauseSliding);
        $btn_nxt.on("mouseenter", AutoSlidingModule.pauseSliding);

        // 오토 슬라이딩을 멈추고 좌측으로 슬라이딩
        $btn_pre.on("click", function(event){
            if(!$sliding_ul.hasClass("active")){
                AutoSlidingModule.pauseSliding;
                AutoSlidingModule.prevSliding();
            }
        });

        // 오토 슬라이딩을 멈추고 우측으로 슬라이딩
        $btn_nxt.on("click", function(event){
            if(!$sliding_ul.hasClass("active")){
                AutoSlidingModule.pauseSliding;
                AutoSlidingModule.nextSliding();
            }
        });
    }
})(AUTO_SLIDNG_MODULE);