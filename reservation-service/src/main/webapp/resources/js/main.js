$(document).ready(function() {
	setRolling = setInterval(bannerRolling_nxt, 2000);
	manageCategory();
});
var setRolling;
var timeCheck=null;

var test = function autoRolling() {
	setRolling = setInterval(bannerRolling_nxt, 2000);
}

var cnt = 0;
var size = $('.banner_list').outerWidth();
var len = $('.banner_list').length;
//var len = $('.visual_img').children().length-2;

$('.visual_img').css('width', len*size);

function bannerRolling_nxt() { // 오른쪽
	cnt++;
	if(cnt > len){
		cnt = 1;
	}
	var move = cnt%len;
	$('.banner_list').animate({'left': -(move*size)+'px'}, 'normal');
	

/*	cnt++;
	$('.banner_list').animate({'left': -(cnt*size)+'px'}, 'normal');
	if(cnt == 2) {
		cnt = 0;
		$('.banner_list').animate({'left': 0+'px'}, 0);
	}*/
};

function bannerRolling_pre() {// 왼쪽
	cnt--;
	if(cnt <= 0){
		cnt = 3;
	}
	var move = cnt%len;
	$('.banner_list').animate({'left': -(move*size)+'px'}, 'normal');
	
/*	cnt--;
	var move = cnt%len;
	//if(move < 0) move *= -1;
	if(cnt == 0) {
		cnt = len-1;
	}
	else {
		$('.banner_list').animate({'left': +(cnt*size)+'px'}, 'normal');
	}*/
}
$('.btnBanner ').bind('click', function() {
	var element = $(this).children();
	var btn = element.attr('class')
	
	clearEvent();
	
	if(btn == 'nxt_inn') {
		bannerRolling_nxt();
	}
	else {
		bannerRolling_pre();
	}
	timeCheck = setTimeout(test, 4000);
});

function clearEvent() {
	clearInterval(setRolling);
	clearTimeout(timeCheck);
}



function manageCategory() {
	$('.cate_list:last').find('a').addClass('last');
	$('.cate_list:first').find('a').addClass('active');
}

$('.cate_list').click(function(){
	addActiveClass($(this));
//	chooseCategory($(this).getAttribute('data-category'));
});

function addActiveClass(obj) {
	// e, obj 차이?
	var element = obj.find('a'); 
	element.addClass('active');
	
	obj.siblings().find('a').removeClass('active');
	
	if(element.hasClass('last')){
		element.removeClass('last')
	}
	else {
		$('.cate_list:last').find('a').addClass('last');
	}
};

function chooseCategory(cateId) {
	alert(cateId);
};






/*function deleteCategory(cateId) {
	$.ajax({
	    url : "/admin/deleteCategory/"+cateId,
	    type : "POST",
	    data : "cateId="+cateId,
	    success: function(data) {
	    	location.reload();
	    },
	    error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"error:"+error);
		}
	 
	}) 
};

function updateCategory(id, name) {
	$("#cateId").val(id);
	$("#newCategory").val(name);

	$("#btnSubmit").css("display", "none");
	$("#btnUpdate").css("display", "inline");
};*/