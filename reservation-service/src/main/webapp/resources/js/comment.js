var CommentModule = (function(){

	var source = $("#comment_template").html(); 
	var comment_template = Handlebars.compile(source); 
	
	var $commentList = $('.short_review_area').find('ul.list_short_review');
	
	var init = function(){
		CommentModule.selectCommentAll();
	}
	
	var selectCommentAll = function(){
		var id = $('div#container').data('product-id');
		
		$.ajax({
			type: "GET",
			url: "/comment/" +id,
			success: function(result){
				var $grade = $('div.grade_area');
				$grade.find('em.graph_value').css('width', result.percent+'%');
				$grade.find('strong.text_value span').text(result.avg);
				$grade.find('em.green').text(result.count);
				
				if(result.count <= 3) $('a.btn_review_more').hide();
				
				$.map(result.commentList, function(comment){
					$commentList.append(comment_template(comment));
				});
				
			}
		});
	}
	
	return {
		init : init,
		selectCommentAll : selectCommentAll
	};
	
})();


var layerPopupModule = (function(){
	
	var init = function(){
		$('.list_short_review').on('click', 'a.thumb', layerPopupModule.layerPopup);
	}
	
	var layerPopup = function(){
		
	    var $el = $('div.pop-layer');        		//레이어의 id를 $el 변수에 저장
	    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

	    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

	    var $elWidth = ~~($el.outerWidth()),
	        $elHeight = ~~($el.outerHeight()),
	        docWidth = $(document).width(),
	        docHeight = $(document).height();

	    // 화면의 중앙에 레이어를 띄운다.
	    if ($elHeight < docHeight || $elWidth < docWidth) {
	        $el.css({
	            marginTop: -$elHeight /2,
	            marginLeft: -$elWidth/2
	        })
	    } else {
	        $el.css({top: 0, left: 0});
	    }

	    $el.find('a.btn-layerClose').click(function(){
	        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
	        return false;
	    });

	    $('.layer .dimBg').click(function(){
	        $('.dim-layer').fadeOut();
	        return false;
	    });

	}
	
	return {
		init : init,
		layerPopup : layerPopup
	};
})();

$(function(){
	CommentModule.init();
	layerPopupModule.init();
});


