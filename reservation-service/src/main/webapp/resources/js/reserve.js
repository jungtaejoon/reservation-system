var totalCountInvalidFlag = false;

$("div.inline_control .tel").keyup("change", telValidate);
$("div.inline_control .email").keyup("change", emailValidate);

$(".agreement").on("click", function(){
	event.preventDefault();
	if($(this).index() == 0){
		var toggle = !$(this).find("#chk3").prop("checked");
		$(this).find("#chk3").prop("checked", toggle);	
		if(toggle && telValidate() && emailValidate() && totalCountInvalidFlag){
			$(".bk_btn_wrap").removeClass("disable");
		}else{
			$(".agreement").eq(0).find("#chk3").prop("checked", false);
			$(".bk_btn_wrap").addClass("disable");
		}
	}else{
		$(this).addClass("open");		
	}
});

// event emitter
class CountControl extends eg.Component {
	init() {
		this.on("minus", this.minus);
		this.on("plus", this.plus);
		this.option("cnt", 0);
	}
	
	minus() {
		this.option("cnt", this.option("cnt")-1);
	}
	
	plus() {
		this.option("cnt", this.option("cnt")+1);
	}
	
	tminus(){
		this.trigger("minus");
	}
	
	tplus(){
		this.trigger("plus");
	}
	
	getCnt(){
		return this.option("cnt");
	}
}

var countControl = new Array($("div.clearfix").length);
for(var i = 0; i < $("div.clearfix").length; i++){
	countControl[i] = new CountControl();
	countControl[i].init();
}

$(".clearfix .ico_minus3").on("click", function(){
	event.preventDefault();
	var index = $(".qty .ico_minus3").index($(this));
	if(countControl[index].getCnt() > 0){
		countControl[index].tminus();
		var num = countControl[index].getCnt();
		$(this).siblings(".count_control_input").attr("value", num);
		if(num <= 0){
			$(this).addClass("disabled");
			$(this).siblings(".count_control_input").addClass("disabled");
		}
		var productPrice = Number($(".qty").eq(index).find(".product_price .price").html().replace(",", ""));
		if((productPrice != 0) &&(num >= 0)){
			$(".qty").eq(index).find(".total_price").html(productPrice*num);
			if(num <= 0){
				$(".qty").eq(index).find(".individual_price").removeClass("on_color");
			}
		}
		totalCountChange("-");
	}
});

$(".clearfix .ico_plus3").on("click", function(){
	event.preventDefault();
	var index = $(".qty .ico_plus3").index($(this));
	countControl[index].tplus();
	var num = countControl[index].getCnt();
	$(this).siblings(".count_control_input").attr("value", num);
	if(num > 0){		
		$(this).siblings(".ico_minus3").removeClass("disabled");
		$(this).siblings(".count_control_input").removeClass("disabled");
	}
	var productPrice = Number($(".qty").eq(index).find(".product_price .price").html().replace(",", ""));
	if((productPrice != 0) &&(num > 0)){
		$(".qty").eq(index).find(".total_price").html(productPrice*num);
		$(".qty").eq(index).find(".individual_price").addClass("on_color");
	}
	totalCountChange("+");
});


// 예약하기버튼
$(".bk_btn_wrap").on("click", function(){
	if(!$(this).hasClass("disable")){
		var data = {};
		for(var i = 0; i < countControl.length; i++){
			if(i == 0){
				data.generalTicketCount = countControl[i].getCnt();
			}else if(i == 1){
				data.youthTicketCount = countControl[i].getCnt();
			}else{
				data.childTicketCount = countControl[i].getCnt();
			}
		}
		data.productId = $(".title").data("category");
		data.reservationName = $("div.inline_control input[name='name']").val();
		data.reservationTel = $("div.inline_control .tel").val();
		data.reservationEmail = $("div.inline_control .email").val();

		$.ajax({
			url : "/reserve",
			method : "post",
			data : data,
			success : function(e){
				if(e == 'success'){
					console.log("저장완료");
				}
			}
		});
	}
});

function telValidate(){
	var tel = $("div.inline_control .tel").val();
	var pattern = /^([0-9]){9,11}$/;
	var result = pattern.test(tel);
	if(!result){	
		$(".agreement").eq(0).find("#chk3").prop("checked", false);
		$(".bk_btn_wrap").addClass("disable");
	}
	return result;
}

function emailValidate(){
	var email = $("div.inline_control .email").val();
	var pattern = /^([\w\.\-]+)\@([\w]+)\.([\w]+)(([\w\.]+)?)$/;
	var result = pattern.test(email);
	if(!result){	
		$(".agreement").eq(0).find("#chk3").prop("checked", false);
		$(".bk_btn_wrap").addClass("disable");
	}
	return result;
}

function totalCountChange(p){
	var totalCount = Number($(".inline_txt span").text());
	if(p == '+')
		totalCount++;
	else if(p == '-')
		totalCount--;
	
	$(".inline_txt span").text(totalCount);
	if(totalCount <= 0){
		totalCountInvalidFlag = false;
		$(".agreement").eq(0).find("#chk3").prop("checked", false);
		$(".bk_btn_wrap").addClass("disable");
	}else{
		totalCountInvalidFlag = true;
	}
}