<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
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
                    <a class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a class="btn_my"> <span title="내 예약">MY</span> </a>
            </header>
        </div>
        <hr>
        <div class="event">
            <div class="section_visual">
                <div class="group_visual">
                    <div class="container_visual">
                        <div class="prev_e">
                            <div class="prev_inn">
                                <a class="btn_pre_e" title="이전"> <i class="spr_book_event spr_event_pre">이전</i> </a>
                            </div>
                        </div>
                        <div class="nxt_e">
                            <div class="nxt_inn">
                                <a class="btn_nxt_e" title="다음"> <i class="spr_book_event spr_event_nxt">다음</i> </a>
                            </div>
                        </div>
                        <div>
                            <div class="container_visual">
                                <!-- [D] 이전,다음 버튼을 클릭할때마다 캐러셀 형태로 순환 됨 --->
                                <ul class="visual_img">
                                    <li class="item" style="background-image: url(http://naverbooking.phinf.naver.net/20170209_66/1486628146913la6nC_JPEG/image.jpg); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit"></h4>
                                                <p class="event_txt_adr"></p>
                                                <p class="event_txt_dsc"></p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="item" style="background-image: url(http://naverbooking.phinf.naver.net/20170119_48/1484802596907hmVDm_JPEG/image.jpg); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit">뮤지컬-김종욱찾기 네이버 예약</h4>
                                                <p class="event_txt_adr">대학로 쁘띠첼씨어터</p>
                                                <p class="event_txt_dsc">네이버 예매시, 손크림/발크림(중 래덤)을 드립니다</p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="item" style="background-image: url(http://naverbooking.phinf.naver.net/20170209_66/1486628146913la6nC_JPEG/image.jpg); width: 338px;">
                                        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                            <div class="event_txt">
                                                <h4 class="event_txt_tit"></h4>
                                                <p class="event_txt_adr"></p>
                                                <p class="event_txt_dsc"></p>
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
                <ul class="event_tab_lst tab_lst_min">
                    <li class="item" data-category="0">
                        <a class="anchor active"> <span>전체</span> </a>
                    </li>
                	<script id="category_list_template"  type="text/x-handlebars-template">
						{{#items}}
	                    <li class="item" data-category="{{id}}">
	                        <a class="anchor {{#if @last}}last{{/if}}"> <span>{{name}}</span> </a>
	                    </li>
						{{/items}}
                	</script>
                </ul>
            </div>
            <div class="section_event_lst">
                <p class="event_lst_txt">바로 예매 가능한 전시, 공연, 행사가 <span class="pink">40개</span> 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box left_box">
                    	<script id="product_list_template" type="text/x-handlebars-template">
                    	<li class="item">
                            <a class="item_book">
                                <div class="item_preview"> <img alt="뮤지컬 드림걸즈(DREAMGIRLS) 최초 내한" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945">                                    <span class="img_border"></span> </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>뮤지컬 드림걸즈(DREAMGIRLS) 최초 내한</span> <small class="sm">샤롯데 씨어터</small> </h4>
                                    <p class="event_txt_dsc">뮤지컬 드림걸즈(DREAMGIRLS) 최초 내한! 1981년 미국 브로드웨이 초연 당시 전미(全美) 흥행 돌풍 2006년 비욘세, 제이미 폭스, 제니퍼 허드슨 등 초호화 캐스팅 영화로 재탄생 2009년 브로드웨이와 국내 제작진이 힘을 합쳐 세계 최초로 선보인 월드 프리미어 2017년 뮤지컬 드림걸즈 최초 내한 드림걸즈의 진가를 느낄 수 있는 최고의 무대가 온다! 오리지널 소울에 압도
                                        당하다! &lt;드림걸즈&gt;의 실제 주인공들인 &lt;슈프림스(Supremes)&gt;의 본 고장 최고의 팀이 뭉쳤다 파워풀한 가창력과 최고의 기량을 지닌 미국 브로드웨이 배우들이 최초로 내한! ＇Listen＇, ＇One Night Only＇, ＇Move＇, ＇To The Bad Side＇ 등 환상적인 뮤지컬 넘버를 오리지널 흑인 R&amp;B, 소울, 그루브로 선보이며
                                        관객의 눈과 귀를 사로잡는다! 당신의 놓치면 안 될 가장 화려한 꿈의 무대 드림걸즈! ALL 아프리칸 아메리칸 캐스트가 전하는 음악의 진수! 브로드웨이의 새로운 트렌드의 중심, 차원이 다른 사운드! 주역부터 앙상블까지 브로드웨이 아프리칸 아메리칸(African-American) 배우로 구성! 진정한 R&amp;B 오리지널 소울을 그대로 전하는 2017년 최고의 기대작!
                                    </p>
                                </div>
                            </a>
                        </li>
                    	</script>
                        
                    </ul>
                    <ul class="lst_event_box right_box">
                    </ul>
                    <!-- 더보기 -->
                    <div class="more">
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
</body>
<script type="text/javascript" src="/resources/js/node_modules/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/node_modules/handlebars/dist/handlebars.min.js"></script>
<script type="text/javascript" src="/resources/js/cashedAjax.js"></script>
<script type="text/javascript" src="/resources/js/mainpage/mainpage.js"></script>
</html>
