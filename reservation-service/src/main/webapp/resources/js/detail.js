var $btn_prev = $('.btn_prev');
var $btn_nxt = $('.btn_nxt');
var $btn_detail = $('._detail');
var $btn_path = $('._path');
var $btn_more_open = $('._open');
var $btn_more_close = $('._close');

var ImageSlide = (function(){
	var $productImages = $(".visual_img");
	var movePx = 414;
	var count = 1;
	var imageCount = $(".figure_pagination>.off>span").text();
	console.log(imageCount);

	function prevSlide(){
		var lastList = $productImages.find('>.item:last-child').clone(true);
		lastList.prependTo($productImages);
		$productImages.css("left", "-"+movePx+"px");
		$productImages.find(">.item:last-child").remove();
		$productImages.animate({left: '0'}, "slow");
		count--;
		imageNumber(count);
	};
	function nxtSlide(){
		var firstList = $productImages.find(">.item:first-child").clone(true);
		firstList.appendTo($productImages);
		$productImages.find(">.item:first-child").remove();
		$productImages.css("left", "0");
		$productImages.animate({left: "-"+movePx+"px"}, "slow");
		count++;
		imageNumber(count);
	};
	function imageNumber(count){
		console.log(count);
		$(".figure_pagination>.num:first-child").text(count%imageCount+1);
	};

	return {
		btnPrevEventListener : function(){
			prevSlide();
		},
		btnNxtEventListener : function(){
			nxtSlide();
		}
	};
})();

var BtnMore = (function(){
  var $store_details = $('.store_details');

  return {
    moreOpen : function(){
      $store_details.removeClass("close3");
      $btn_more_close.css("display", "block");
      $btn_more_open.css("display", "none");
    },
    moreClose : function(){
      $store_details.addClass("close3");
      $btn_more_open.css("display", "block");
      $btn_more_close.css("display", "none");
    }
  }
})();

var DetailArea = (function(){
  var $detail_area_wrap = $('.detail_area_wrap');
  var $detail_location = $('.detail_location');

  return {
    btnDetail : function(event){
			event.preventDefault();
      $btn_path.find(">.anchor").removeClass("active");
      $btn_detail.find(">.anchor").addClass("active");
      $detail_area_wrap.removeClass("hide");
      $detail_location.addClass("hide");
    },
    btnPath : function(event){
			event.preventDefault();
      $btn_detail.find(">.anchor").removeClass("active");
      $btn_path.find(">.anchor").addClass("active");
      $detail_area_wrap.addClass("hide");
      $detail_location.removeClass("hide");
    }
  }
})();

var GetFromServer = (function(){
	var product_id = window.location.pathname.split("/")[2];
	var source = $("#comment-list").html();
	var template = Handlebars.compile(source);
	var html="";

	function getComments(){
		$.ajax({
			url : "/api/comments/products/" + product_id,
			method : "get",
			processData : true,
			contentType : "application/json; charset=UTF-8",
			success : function(data){
				count=0;
				score=0;
				for(var i in data){
					html += template(data[i]);
				}
				$(".list_short_review").append(html);
			}
		});
	}

	return {
		getComments : function(){
			getComments();
		}
	}
})();

$(document).ready(function (){
	GetFromServer.getComments();

	$btn_prev.on("click", ImageSlide.btnPrevEventListener);
	$btn_nxt.on("click", ImageSlide.btnNxtEventListener);

	$btn_more_open.on("click", BtnMore.moreOpen);
	$btn_more_close.on("click", BtnMore.moreClose);

	$btn_detail.on("click", DetailArea.btnDetail);
	$btn_path.on("click", DetailArea.btnPath);

});
