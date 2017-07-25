<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<script src="/resources/js/node_modules/jquery/dist/jquery.js"></script>
	<script src="/resources/js/handlebars-v4.0.10.js"></script>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>
    <div id="container">
        <div class="header">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="/naver" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="/" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="/myreservation" class="btn_my"> <span title="내 예약">MY</span> </a>
            </header>
        </div>
        <hr>
        <div class="event">
            <div class="section_visual">
                <div class="group_visual">
                    <div class="container_visual">
                        <div class="prev_e">
                            <div class="prev_inn">
                                <a href="#" class="btn_pre_e" title="이전"> <i class="spr_book_event spr_event_pre">이전</i> </a>
                            </div>
                        </div>
                        <div class="nxt_e">
                            <div class="nxt_inn">
                                <a href="#" class="btn_nxt_e" title="다음"> <i class="spr_book_event spr_event_nxt">다음</i> </a>
                            </div>
                        </div>
                        <div>
                            <div class="container_visual">
                                <!-- [D] 이전,다음 버튼을 클릭할때마다 캐러셀 형태로 순환 됨 --->
                                 <ul class="visual_img">
                                 <!-- 3'으로서 순환을 위한 임시 promotion -->
			                         <li class="item" style="background-image: url(/images/3); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit">윈스턴</h4>
                                                <p class="event_txt_adr">분노</p>
                                                <p class="event_txt_dsc">오! 안녕하세요!</p>>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="item" style="background-image: url(/images/1); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit">강아지</h4>
                                                <p class="event_txt_adr">귀여워</p>
                                                <p class="event_txt_dsc">메롱~</p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="item" style="background-image: url(/images/2); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit">뮤지컬-김종욱찾기 네이버 예약</h4>
                                                <p class="event_txt_adr">대학로 쁘띠첼씨어터</p>
                                                <p class="event_txt_dsc">네이버 예매시, 손크림/발크림(중 래덤)을 드립니다</p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="item" style="background-image: url(/images/3); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit">윈스턴</h4>
                                                <p class="event_txt_adr">분노</p>
                                                <p class="event_txt_dsc">오! 안녕하세요!</p>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- 1'으로서 순환을 위한 임시 promotion -->
									<li class="item" style="background-image: url(/images/1); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit">강아지</h4>
                                                <p class="event_txt_adr">귀여워</p>
                                                <p class="event_txt_dsc">메롱~</p>>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <span class="nxt_fix"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section_event_tab">
                <ul class="event_tab_lst tab_lst_min" id ='categoryList'>
                </ul>
            </div>
            <div class="section_event_lst">
                <p class="event_lst_txt">바로 예매 가능한 전시, 공연, 행사가 <span class="pink" id='countSaleProduct'></span>있습니다.</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box" id='productLeftList'>
                       <!--  -->
                    </ul>
                    <ul class="lst_event_box" id='productRightList'>
                       <!--  -->
                    </ul>
                    <!-- 더보기 -->
                    <div class="more" id="more">
                        <button class="btn"><span>더보기</span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>

    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"> </script>
    <script src="/resources/js/category.js"></script>
    <script src="/resources/js/product.js"></script>
	<script src="/resources/js/background.js"></script>
    <script>
    Product.get();
    
    $(function(){
		$(document).on("click", "div.more", function(){
			Product.click_more();
		});
	
		$(document).scroll(function(){
			if($(window).scrollTop() >= $(document).height() - $(window).height()){
				Product.click_more();
			}
		})

		UTIL.set_number_of_img(3-1);
		$(".visual_img").css("left", "-338px");
		UTIL.set_size(338);
		UTIL.start();
		$(document).on("click", "a.anchor", Product.move);
		$(document).on("click", "a.btn_pre_e", UTIL.previous);
		$(document).on("click", "a.btn_nxt_e", UTIL.next);
    });
</script>
<script id="product-template" type="text/x-handlebars-template">
	<li class="item">
		<a href="/detail/{{id}}" class="item_book">
			<div class="item_preview">
				<img alt={{name}} class="img_thumb"
				src="/images/{{fileId}}">
				<span class="img_border"></span>
			</div>
			<div class="event_txt">
				<h4 class="event_txt_tit">
				<span> {{event}} </span>
					<small class="sm"> {{placeName}} {{placeLot}} {{placeStreet}}
					</small>
				</h4>
				<p class="event_txt_dsc"> {{description}} </p>
			</div>
		</a>
	</li>
</script>

<script id="category-template" type="text/x-handlebars-template">
	<li class="item" data-category="{{id}}">
		<a class="anchor"> <span> {{name}} </span> </a>
	</li>
</script>

</body>
</html>

<!-- item에 active옵션 주기-->

