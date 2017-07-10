var count=0;
var interverId;
var timeoutId;
var size=$(".visual_img > li") .size()-1;

$(document).ready(function() {
      
	load_category();
	
	interverId = setInterval("rolling()", 2000);
 
	$(".btn_pre_e").on("click",pre_rolling);
	$(".btn_nxt_e").on("click",nxt_rolling);
	
	$(".event_tab_lst.tab_lst_min").on("click","li",category_show);
	
});

function load_category(){
	$list = $(".event_tab_lst.tab_lst_min");
	
	var URL = "http://localhost:8080/api/categories";

	$.ajax({
		url : URL,
		contentType:"application/json",
		type: "get",
		success : function(data){
			for(var i=0;i<data.length;i++){
				$list.append('<li class="item" data-category="'+data[i].id+'"><a class="anchor"> <span>'+data[i].name+'</span> </a></li>');
			}

			

		}
	});

	return false;
}
	



function rolling(){
	
	if(count < size){
		count++;
		$(".visual_img").animate({ "left": "-=338px" }, "slow" );
	}
	else{
		var value = 338*size + "px";
		value = "+="+value;
		$(".visual_img").animate({ "left": value }, "slow" );
		count = 0;
	}
}

function nxt_rolling(){
	if(count< size){
		$(".visual_img").animate({ "left": "-=338px" }, "slow" );
		count++;
	}
	clearInterval(interverId);
	clearTimeout(timeoutId);
	timeoutId = setTimeout("timeout_rolling()", 4000);
	
}

function pre_rolling(){
	if(count>0){
		$(".visual_img").animate({ "left": "+=338px" }, "slow" );
		count--;
	}
	clearInterval(interverId);
	clearTimeout(timeoutId);
	timeoutId = setTimeout("timeout_rolling()", 4000);
}

function timeout_rolling(){
	interverId = setInterval("rolling()", 2000);
}

function category_show(){
	$(".event_tab_lst.tab_lst_min").find(".active").toggleClass("active");
	$(this).children().toggleClass("active");
}
