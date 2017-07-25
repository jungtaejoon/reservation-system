<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">

<head>
	<script src="/resources/js/node_modules/jquery/dist/jquery.js"></script>
	<script src="/resources/js/handlebars-v4.0.10.js"></script>
	<script src="/resources/js/node_modules/@egjs/component/dist/component.js"></script>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>
    <div id="container">
        <!-- [D] 예약하기로 들어오면 header에 fade 클래스 추가로 숨김 -->
        <div class="header fade">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="/naver" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="/" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="/myreservation" class="btn_my"> <span title="내 예약">MY</span> </a>
            </header>
        </div>
        <div class="ct">
            <div class="ct_wrap">
                <div class="top_title">
                    <a href="/detail/${id}" class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i> </a>
                    <h2><span class="title">클림트 인사이드</span></h2>
                </div>
                <div class="group_visual">
                    <div class="container_visual" style="width: 414px;">
                        
                    </div>
                </div>
 				<div class="section_store_details">
 				</div>
                <div class="section_booking_ticket">
                    <div class="ticket_body">
                        
                    </div>
                </div>
                <div class="section_booking_form">
                    <div class="booking_form_wrap">
                        <div class="form_wrap">
                        </div>
                    </div>
                    <div class="section_booking_agreement">
                        <div class="agreement all"> <input type="checkbox" id="chk3" class="chk_agree"> <label for="chk3" class="label chk_txt_label"> <span>이용자 약관 전체동의</span> </label>
                            <div class="agreement_nessasary">
                                <span>필수동의</span> 
                            </div>
                        </div>
                        <!-- [D] 약관 보기 클릭 시 agreement에 open 클래스 추가 -->
                        <div class="agreement open"> <span class="chk_txt_span"> <i class="spr_book ico_arr_ipc2"></i> <span>개인정보 수집 및 이용 동의</span> </span>
                            <a href="#" class="btn_agreement"> <span class="btn_text">보기</span> <i class="fn fn-down2"></i> </a>
                            <div class="useragreement_details">&lt;개인정보 수집 및 이용 동의&gt;<br><br> 1. 수집항목 : [필수] 이름, 연락처, [선택] 이메일주소<br><br> 2. 수집 및 이용목적 : 사업자회원과 예약이용자의 원활한 거래 진행, 고객상담, 불만처리 등 민원 처리, 분쟁조정 해결을 위한 기록보존, 네이버 예약 이용 후 리뷰작성에 따른 네이버페이 포인트 지급 및 관련 안내<br><br> 3. 보관기간<br> - 회원탈퇴 등
                                개인정보 이용목적 달성 시까지 보관<br> - 단, 상법 및 ‘전자상거래 등에서의 소비자 보호에 관한 법률’ 등 관련 법령에 의하여 일정 기간 보관이 필요한 경우에는 해당 기간 동안 보관함<br><br> 4. 동의 거부권 등에 대한 고지: 정보주체는 개인정보의 수집 및 이용 동의를 거부할 권리가 있으나, 이 경우 상품 및 서비스 예약이 제한될 수 있습니다.<br></div>
                        </div>
                        <!-- [D] 약관 보기 클릭 시 agreement에 open 클래스 추가 -->
                        <div class="agreement open"> <span class="chk_txt_span"> <i class="spr_book ico_arr_ipc2"></i> <span>개인정보 제3자 제공 동의</span> </span>
                            <a href="#" class="btn_agreement"> <span class="btn_text">보기</span> <i class="fn fn-down2"></i> </a>
                            <div class="useragreement_details custom_details_wrap">
                                <div class="custom_details">&lt;개인정보 제3자 제공 동의&gt;<br><br> 1. 개인정보를 제공받는 자 : 미디어앤아트<br><br> 2. 제공하는 개인정보 항목 : [필수] 네이버 아이디, 이름, 연락처 [선택] 이메일 주소<br><br> 3. 개인정보를 제공받는 자의 이용목적 : 사업자회원과 예약이용자의 원활한 거래 진행, 고객상담, 불만처리 등 민원 처리, 서비스 이용에 따른 설문조사 및 혜택 제공, 분쟁조정
                                    해결을 위한 기록보존<br><br> 4. 개인정보를 제공받는 자의 개인정보 보유 및 이용기간 : 개인정보 이용목적 달성 시 까지 보관합니다.<br><br> 5. 동의 거부권 등에 대한 고지 : 정보주체는 개인정보 제공 동의를 거부할 권리가 있으나, 이 경우 상품 및 서비스 예약이 제한될 수 있습니다.<br></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box_bk_btn">
                    <!-- [D] 약관 전체 동의가 되면 disable 제거 -->
                    <div class="bk_btn_wrap disable"> <button type="button" class="bk_btn"> <i class="spr_book ico_naver_s"></i>  <span>예약하기</span> </button> </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div id="footer" class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>
    <script src="/resources/js/detail.js"></script>
    <script src="/resources/js/product.js"></script>
    <script>

	var ProductInfo = (function(){
		
		var id = '${id}';
		draw_detail_product = function(productDTO){
			var source = $("#detail-product-template").html();
			var template = Handlebars.compile(source);
			var str;
			str = template(productDTO);
			$('.section_store_details').append(str);
			$('span.title').html(productDTO.name);
		};
		get_product_info = function(callback){
			$.ajax({
				type : 'get',
				url : '/api/products/' + id,
				success : function(result) {
					callback(result);
				}
			});
		}
		
		return {
			get: function(){
				get_product_info(draw_detail_product)
			}
		};
	})();
	
	var Validate = (function (){
        var nf_tel = /^0(2|\d\d)-\d{3,4}-\d{4}$/;
        var nf_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        
        init = function(){
        	$('.chk_agree').on("click", function(){
        		reservation();
        	})
			$("input.tel").keyup(function(){
				if(nf_tel.test($("input.tel").val())){
					$("input.tel").css("background-color", "white");
				}else{
					$("input.tel").css("background-color", "pink");
				}
				reservation();
			});
			$("input.email").keyup(function(){
				if(nf_email.test($("input.email").val())){
					$("input.email").css("background-color", "white");
				}else{
					$("input.email").css("background-color", "pink");
				}
				reservation();
			});
        };
        reservation = function(){
			console.log(Ticket.total)
			var ticket = Ticket.total;
			var name = true;
			var agreement = $('.chk_agree').is(":checked");
			if((ticket>0) && name && nf_tel.test($("input.tel").val()) && nf_email.test($("input.email").val()) && agreement){
				$('div.bk_btn_wrap').removeClass('disable');
			}else{
				$('div.bk_btn_wrap').addClass('disable');
			}
		}
		return {
			init: init,
			reservation: reservation
		};
	})();
	
	var User =(function(){
		var productId = '${id}';
		draw_user = function(user){
			var source = $("#user-template").html();
			var template = Handlebars.compile(source);
			var str;
			str = template(user);
			$('.form_wrap').html(str);
			Validate.init();
		};
		draw_product_image = function(id){
			var source = $("#image-template").html();
			var template = Handlebars.compile(source);
			var str;
			str = template(id);
			$('.container_visual').html(str);
		};
		get_user_info = function(callback){
			$.ajax({
				type : 'get',
				url : '/api/users',
				success : function(result) {
					callback(result);
				}
			});
		};
		get_product_image = function(callback){
			$.ajax({
				type : 'get',
				url : '/api/products/' + productId + '/image',
				success : function(result) {
					callback(result);
				}
			});
		};
		return{
			get: function(){
				get_user_info(draw_user);
			},
			get_image: function(){
				get_product_image(draw_product_image)
			}
		};
	})();
	
	User.get();
	User.get_image();
    ProductInfo.get();
    
    function Ticket(index){
    	this.index = index;
    	this.count = 0;
    	Ticket.total = 0;
    }
    Ticket.prototype = new eg.Component();
    Ticket.prototype.constructor = Ticket;
	Ticket.prototype.post = function(){
		$("input.count_control_input:eq("+this.index+")").val(this.count);
    	$("span.total_price:eq("+this.index+")").html($("span.price:eq("+this.index+")").text() * this.count);
    	$("span.total_ticket").html(Ticket.total);
    	Validate.reservation();
	}
    Ticket.prototype.add = function(event){
    	event.preventDefault();
    	this.count++; 
    	Ticket.total++;
    	$("input.count_control_input:eq("+this.index+")").removeClass("disabled");
    	$("a.ico_minus3:eq("+this.index+")").removeClass("disabled");
    	this.post.bind(this)();
    }
    Ticket.prototype.sub = function(event){
    	event.preventDefault();
    	if(this.count == 1){
    		this.count = 0;
    		Ticket.total--;
    		$("input.count_control_input:eq("+this.index+")").addClass("disabled");
    		$("a.ico_minus3:eq("+this.index+")").addClass("disabled");
    	}else if(this.count <= 0){
    		this.count = 0;
    	}
    	else{
	    	this.count--; 
	    	Ticket.total--;
    	}
    	this.post.bind(this)();
	}
    Ticket.prototype.init = function(){
		$("a.ico_minus3:eq("+this.index+")").on("click", this.sub.bind(this));
		$("a.ico_plus3:eq("+this.index+")").on("click", this.add.bind(this)); 
    };
    
    var ticketArr = new Array();

    /* 가격 */
	function draw_price_view (price) {
		var str = '';
		var source = $("#price-template").html();
		// 핸들바 템플릿 컴파일
		var template = Handlebars.compile(source);
		for(var index in price){
			str += template(price[index]);
			ticketArr[index] = new Ticket(index);
		}
		$('.ticket_body').html(str);
		for(var i = 0; i<=index; i++){
			ticketArr[i].init();
		}
	};
	
	function get_price(callback) {
		$.ajax({
			type : 'get',
			url : '/api/products/${id}/price',
			success : function(result) {
				callback(result);
			}
		})
	};
	get_price(draw_price_view);
	
	/* $('.chk_agree').is(":checked");	 */
	$(".bk_btn_wrap").on("click", function(){
		var data = new Object();
		data.generalTicketCount = $("input.count_control_input:eq(0)").val() | null;  
		data.youthTicketCount = $("input.count_control_input:eq(1)").val() | null;
		data.childTicketCount = $("input.count_control_input:eq(2)").val() | null;
		data.reservationName = $("input.text").val();
		data.reservationTel = $("input.tel").val();
		data.reservationEmail = $("input.email").val();
		
		console.log(data);
		
		$.ajax({
			type:'post',
			url:'/api/products/${id}/reservation',
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify(data),			
			success:function() {
				console.log(data);
			}
		});
	})
	
	
	Handlebars.registerHelper('discount', function(price, discountRate){
        return price * (1 - discountRate);
    });
    Handlebars.registerHelper('ratio', function(discountRate){
        return discountRate * 100;
    });
    </script>
    <script id="price-template" type="text/x-handlebars-template">
		<div class="qty" >
			<div class="count_control">
			<!-- [D] 수량이 최소 값이 일때 ico_minus3, count_control_input에 disabled 각각 추가, 수량이 최대 값일 때는 ico_plus3에 disabled 추가 -->
				<div class="clearfix">
					<a href="#" class="btn_plus_minus spr_book2 ico_minus3 disabled" title="빼기"> </a> 
					<input type="tel" class="count_control_input disabled" value="0" readonly title="수량">
					<a href="#" class="btn_plus_minus spr_book2 ico_plus3" title="더하기"></a>
				</div>
			<!-- [D] 금액이 0 이상이면 individual_price에 on_color 추가 -->
			<div class="individual_price"><span class="total_price">0</span><span class="price_type">원</span></div>
			</div>
			<div class="qty_info_icon"> 
				<strong class="product_amount"> <span>{{priceType}}</span> </strong> 
				<strong class="product_price"> <span class="price">{{discount price discountRate}}</span> <span class="price_type">원</span> </strong> 
				<em class="product_dsc">{{price}} ({{ratio discountRate}}% 할인가)</em> 
			</div>
		</div>
	</script>
    <script id="detail-product-template" type="text/x-handlebars-template">
		<div class="store_details">
			<h3 class="in_tit">{{name}}</h3>
			<p class="dsc"> 장소 : placeLot({{placeStreet}})<br>
				기간 : {{displayStart}}~{{displayEnd}}
			</p>
			<h3 class="in_tit">관람시간</h3>
			<p class="dsc"> 화, 목, 금 일요일 {{observationTime}}(입장마감 05:30pm)<br>
				‘문화가 있는 날’ 매월 마지막 주 수요일은 오후 8시까지 연장
			</p>
			<h3 class="in_tit">요금</h3>
			<p class="dsc"> 성인(만 19~64세) 5,000원 / 청소년(만 13~18세) 4,000원
				<br> 어린이(만 4~12세) 3,000원 / 20인 이상 단체 20% 할인
				<br> 국가유공자, 장애인, 65세 이상 4,000원
			</p>
		</div>
	</script>
	<script id="user-template" type="text/x-handlebars-template">
    	<h3 class="out_tit">예매자 정보</h3>
    	<div class="agreement_nessasary help_txt"> <span class="spr_book ico_nessasary"></span> <span>필수입력</span> </div>
    	<form class="form_horizontal">
        	<div class="inline_form"> <label class="label" for="name"> <span class="spr_book ico_nessasary">필수</span> <span>예매자</span> </label>
            	<div class="inline_control"> <input type="text" name="name" id="name" class="text" value="{{username}}" maxlength="17"> </div>
        	</div>
        	<div class="inline_form"> <label class="label" for="tel"> <span class="spr_book ico_nessasary">필수</span> <span>연락처</span> </label>
            	<div class="inline_control"> <input type="tel" name="tel" id="tel" class="tel" value="{{tel}}" placeholder="휴대폰 입력 시 예매내역 문자발송"> </div>
        	</div>
        	<div class="inline_form"> <label class="label" for="email">  <span>이메일</span> </label>
            	<div class="inline_control"> <input type="email" name="email" id="email" class="email" value={{email}} maxlength="50"> </div>
        	</div>
        	<div class="inline_form last"> <label class="label" for="message">예매내용</label>
            	<div class="inline_control">
                	<p class="inline_txt selected">2017.2.17.(금)~2017.4.18.(화), 총 <span class="total_ticket">0</span>매</p>
            	</div>
        	</div>
    	</form>
	</script>
	<script id="image-template" type="text/x-handlebars-template">
	<ul class="visual_img">
    	<li class="item" style="width: 414px;"> <img alt="" class="img_thumb" src="/images/{{this}}">
			<span class="img_bg"></span>
			<div class="preview_txt">
				<h2 class="preview_txt_tit">클림트 인사이드</h2> 
				<em class="preview_txt_dsc">₩12,000 ~ </em>
				<em class="preview_txt_dsc">2017.2.17.(금)~2017.4.18.(화), 잔여티켓 2769매</em> 
			</div>
    	</li>
	</ul>
	</script>
</body>
</html>