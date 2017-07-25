<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="/resources/css/style.css" rel="stylesheet">
    <style type="text/css">
		.invisible {
			display : none
		}
		.section_store_details .bk_more._close {
			display : none
		}
		.section_store_details.opened .bk_more._close {
			display : block
		}
		.section_store_details.opened .bk_more._open {
			display : none
		}
		#photoviewer {  
			position: fixed; 
			left:0;
			top:0;
			width: 100%;
			height: 100%;
			z-index:9000;  
			background-color:#000;  
			word-wrap: normal;
			display: none
		}
   		#layer{
   			position: fixed;
		    z-index: 8000;
			display: flex;
			width: 100%;
			height: 100%;
	    }
	    .sub_layer{
	   		position: fixed;
	   		width: 100%;
			height: 100%;
			z-index:6500;
			-ms-transform: translate(0px, 0px); /* IE 9 */
		    -webkit-transform: translate(0px, 0px); /* Safari */
		    transform: translate(0px, 0px);
	    }
	    .sub_layer.touch{
			-moz-transition: all 500ms ease;
		    -o-transition: all 500ms ease;
		    -webkit-transition: all 500ms ease;
		    transition: all 500ms ease
	    }
		div.wrapper{
			position: fixed;
			left: 50%;
			top: 50%;
			-ms-transform: translate(0px, 0px); /* IE 9 */
		    -webkit-transform: translate(0px, 0px); /* Safari */
		    transform: translate(0px, 0px);
		}
		.com_img_btn {
			position: fixed;
			width: 50px;
			height: 50px;
			top: 50%;
			margin-top: -25px;
			z-index: 6000;
			display : block
		}
		.btn_wrapper.invisible{
			display : none
		}
		.com_img_btn.nxt {
			right: 0
		}
		.com_img_btn.close {
			top: 0;
			margin-top: 0
		}
	</style>
</head>

<body>
    <div id="container" data-product-id="${productDetail.id }">
        <div class="ct main">
            <div>
                <div class="section_visual">
                    <header>
				        <h1 class="logo">
				            <a href="http://www.naver.com" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
				            <a href="/" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
				        </h1>
				        <a href="/my-reservation" class="btn_my"> <span title="내 예약">MY</span> </a>
                    </header>
                    <div class="pagination">
                        <div class="bg_pagination"></div>
                        <div class="figure_pagination">
                            <span class="num" id="slideNum">1</span>
                            <span class="num off">/ ${fn:length(images)} <span id="slideCounts"></span></span>
                        </div>
                    </div>
                    <div class="group_visual">
                        <div>
                            <div class="container_visual" style="width: 414px;">
                                <ul class="visual_img" id="slider">
                                	<c-rt:forEach var="image" items="${images}" varStatus="status">
	                                    <li class="item" style="width: 414px;"> <img alt="${productDetail.name }" class="img_thumb" src="/files/${image.fileId }"> <span class="img_bg"></span>
	                                        <div class="visual_txt">
	                                            <div class="visual_txt_inn">
	                                                <h2 class="visual_txt_tit"> <span>${productDetail.name }</span> </h2>
	                                                <p class="visual_txt_dsc"></p>
	                                            </div>
	                                        </div>
	                                    </li>
                                    </c-rt:forEach>
                                </ul>
                            </div>
                            <div class="prev">
                                <div class="prev_inn">
                                    <a id="btn_pre" class="btn_prev" title="이전">
                                        <i class="spr_book2 ico_arr6_lt"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="nxt">
                                <div class="nxt_inn">
                                    <a id="btn_nxt" class="btn_nxt" title="다음">
                                        <i class="spr_book2 ico_arr6_rt"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="group_btn_goto">
                        <a class="btn_goto_home" title="홈페이지" href="#" target="siteUrl"> <i class="fn fn-home1"></i> </a>
                        <a class="btn_goto_tel" title="전화" href="#"> <i class="fn fn-call1"></i> </a>
						<a class="btn_goto_mail" title="이메일" href="#"> <i class="fn fn-mail1"></i> </a>
                        <a href="#" class="btn_goto_path" title="길찾기"> <i class="fn fn-path-find1"></i> </a>
                        <a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
                    </div>
                </div>
                <div id="msg"></div>
                <div class="section_store_details">
                    <!-- [D] 펼쳐보기 클릭 시 store_details에 close3 제거 -->
                    <div class="store_details close3">
                        <p class="dsc">
                            ${productDetail.description }
                        </p>
                    </div>
                    <!-- [D] 토글 상황에 따라 bk_more에 display:none 추가 -->
                    <a class="bk_more _open"> <span class="bk_more_txt">펼쳐보기</span> <i class="fn fn-down2"></i> </a>
                    <a class="bk_more _close"> <span class="bk_more_txt">접기</span> <i class="fn fn-up2"></i> </a>
                </div>
                <div class="section_event">
                    <div class="event_info_box">
                        <div class="event_info_tit">
                            <h4 class="in_tit"> <i class="spr_book ico_evt"></i> <span>이벤트 정보</span> </h4>
                        </div>
                        <div class="event_info">
                            <div class="in_dsc">[네이버예약 특별할인]<br>${productDetail.event }</div>
                        </div>
                    </div>
                </div>
                <div class="section_btn" data-href="/reserve/${productDetail.id }"> <button type="button" class="bk_btn"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </button> </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area">
                                <!-- [D] 별점 graph_value는 퍼센트 환산하여 width 값을 넣어줌 -->
                                <span class="graph_mask"> <em class="graph_value" style="width: ${productDetail.avgScore / 5 * 100}%;"></em> </span>
                                <strong class="text_value"> <span>${productDetail.avgScore }</span> <em class="total">5.0</em> </strong>
                                <span class="join_count"><em class="green" id="score_counts" data-score-counts="${productDetail.commentCount }">${productDetail.commentCount }건</em> 등록</span>
                            </div>
                            <ul class="list_short_review" id="comments_box">
                            	<c-rt:forEach var="comment" items="${comments}" varStatus="status">
	                                <li class="list_item">
	                                    <div>
	                                        <div class="review_area">
	                                            <div class="thumb_area">
	                                                <a class="thumb" data-comment-id="${comment.id }" title="이미지 크게 보기"> 
	                                                	<img width="90" height="90" class="img_vertical_top" src="/files/${comment.fileId }" alt="리뷰이미지"> 
	                                                </a> 
	                                                <span class="img_count">${comment.imageCount }</span>
	                                            </div>
	                                            <h4 class="resoc_name">${productDetail.name }</h4>
	                                            <p class="review">${comment.comment }</p>
	                                        </div>
	                                        <div class="info_area">
	                                            <div class="review_info"> <span class="grade">${comment.score }</span> <span class="name">${comment.username }</span> <span class="date">${comment.createDate } 등록</span> </div>
	                                        </div>
	                                    </div>
	                                </li>
                                </c-rt:forEach>
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                    <a class="btn_review_more" href=""> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>
                <div class="section_info_tab">
                    <!-- [D] tab 선택 시 anchor에 active 추가 -->
                    <ul class="info_tab_lst">
                        <li class="item active _detail">
                            <a class="anchor active" id="detail_area_wrap"> <span>상세정보</span> </a>
                        </li>
                        <li class="item _path">
                            <a class="anchor" id="detail_location"> <span>오시는길</span> </a>
                        </li>
                    </ul>
                    <!-- [D] 상세정보 외 다른 탭 선택 시 detail_area_wrap에 hide 추가 -->
                    <div class="detail_area_wrap tab">
                        <div class="detail_area">
                            <div class="detail_info">
                                <h3 class="blind">상세정보</h3>
                                <ul class="detail_info_group">
                                    <li class="detail_info_lst">
                                        <strong class="in_tit">[소개]</strong>
                                        <p class="in_dsc">
                                        	${productDetail.content }
                                        </p>
                                    </li>
                                    <li class="detail_info_lst"> <strong class="in_tit">[공지사항]</strong>
                                        <ul class="in_img_group">
                                            <li class="in_img_lst"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170131_238/14858250829398Pnx6_JPEG/%B0%F8%C1%F6%BB%E7%C7%D7.jpg?type=a1000"> </li>
                                        </ul>
                                    </li>
                                    <li class="detail_info_lst"> <strong class="in_tit">[공연정보]</strong>
                                        <ul class="in_img_group">
                                            <li class="in_img_lst"> <img alt="" id="lazy_image" class="img_thumb" data-lazy-image="https://ssl.phinf.net/naverbooking/20170131_255/1485825099482NmYMe_JPEG/%B0%F8%BF%AC%C1%A4%BA%B8.jpg?type=a1000"> </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- [D] 오시는길 외 다른 탭 선택 시 detail_location에 hide 추가 -->
                    <div class="detail_location tab hide">
                        <div class="box_store_info no_topline">
                            <a class="store_location" title="지도웹으로 연결">
                                <div id="map" style="width:360px; height:150px;"></div>
                                <span class="img_border"></span>
                                <span class="btn_map"><i class="spr_book2 ico_mapview"></i></span>
                            </a>
                            <h3 class="store_name">엔에이치엔티켓링크(주)</h3>
                            <div class="store_info">
                                <div class="store_addr_wrap">
                                    <span class="fn fn-pin2"></span>
                                    <p class="store_addr store_addr_bold">${productDetail.placeStreet } </p>
                                    <p class="store_addr">
                                        <span class="addr_old">지번</span>
                                        <span class="addr_old_detail">${productDetail.placeLot } </span>
                                    </p>
                                    <p class="store_addr addr_detail">${productDetail.placeName }</p>
                                </div>
                                <div class="lst_store_info_wrap">
                                    <ul class="lst_store_info">
                                        <li class="item"> <span class="item_lt"> <i class="fn fn-call2"></i> <span class="sr_only">전화번호</span> </span> <span class="item_rt"> <a href="tel:${productDetail.tel }" class="store_tel">${productDetail.tel }</a></span> </li>
                                    </ul>
                                </div>
                            </div>
							<!-- [D] 모바일 브라우저에서 접근 시 column2 추가와 btn_navigation 요소 추가 -->
                            <div class="bottom_common_path column2">
                                <a class="btn_path"> <i class="fn fn-path-find2"></i> <span>길찾기</span> </a>
								<a class="btn_navigation before"> <i class="fn fn-navigation2"></i> <span>내비게이션</span> </a>
                            </div>
                        </div>
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
    <div id="photoviewer">
    	<div class="layer" id="layer"></div>
	</div>
	<script id="popup_layer_template" type="text/x-handlebars-template">
		{{#items}}
		<div class="sub_layer" style="transform: translateX({{tranx}}%)">
    		<div class="wrapper">
				<img src="/files/{{fileId}}">
    		</div>
			<div class="btn_wrapper">
	    		<button class="com_img_btn close">X</button>
    			<button class="com_img_btn prev"><</button><button class="com_img_btn nxt">></button>
			</div>
    	</div>
		{{/items}}
	</script>
    <script type="text/javascript" src="/node_modules/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="/node_modules/handlebars/dist/handlebars.min.js"></script>
	<script type="text/javascript" src="/resources/js/etcData.js"></script>
	<script type="text/javascript" src="/resources/js/slider.js"></script>
	<script type="text/javascript" src="/resources/js/thumbnail.js"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=GDP3lzLsmrfJxJO4e8eB&submodules=geocoder"></script>
    <script type="text/javascript">
    $(document).ready(function(){
		Slider.init(false);
		ThumbApp.init();
		$('.section_btn').on('click', function() {
			location.href = $(this).data('href');
		});
    	$('.group_visual').on('click', function() {
    		$('.visual_txt').addClass('invisible');
    	});
    	$('.bk_more').on('click', function() {
    		if($('.section_store_details').hasClass('opened')) {
    			$('.section_store_details').removeClass('opened');
    			$('.store_details').addClass('close3');
    		}
    		else {
    			$('.section_store_details').addClass('opened');
    			$('.store_details').removeClass('close3');
    		}
    	});
    	$('.anchor').on('click', function() {
    		if($(this).hasClass('active')) {return;}
    		else {
    			$('.anchor').removeClass('active');
    			$(this).addClass('active');
    			$('.section_info_tab div.tab').addClass('hide');
    			$('.' + $(this).attr('id')).removeClass('hide'); 
    		}
    	});
		$(window).scroll(function() {
			var maxHeight = $(document).height();
			var currentScroll = $(window).scrollTop() + $(window).height();
			var lazyTop = $('#lazy_image').offset().top;
			if(lazyTop - currentScroll < 60) {
				if($('#lazy_image').prop('src')) return;
				$('#lazy_image').attr('src', $('#lazy_image').data('lazy-image'));
			}
		});
		var map = new naver.maps.Map('map');
		var myaddress = '${productDetail.placeLot }' || '서울시';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
		naver.maps.Service.geocode({address: myaddress}, function(status, response) {
		    if (status !== naver.maps.Service.Status.OK) {
		        return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
		    }
		    var result = response.result;
		    // 검색 결과 갯수: result.total
		    // 첫번째 결과 결과 주소: result.items[0].address
		    // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
		    var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
		    map.setCenter(myaddr); // 검색된 좌표로 지도 이동
		    // 마커 표시
		    var marker = new naver.maps.Marker({
		      position: myaddr,
		      map: map
		    });
		    // 마커 클릭 이벤트 처리
		    naver.maps.Event.addListener(marker, "click", function(e) {
		      if (infowindow.getMap()) {
		          infowindow.close();
		      } else {
		          infowindow.open(map, marker);
		      }
		    });
		    // 마크 클릭시 인포윈도우 오픈
		    var infowindow = new naver.maps.InfoWindow({
		        content: '<h4> [네이버 개발자센터]</h4><a href="https://developers.naver.com" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
		    });
		    $('.store_location').on('click', function() {
		    	location.href = 'http://map.naver.com/?level=2&pinType=SITE&enc=utf8&lat=' + result.items[0].point.y + '&lng=' + result.items[0].point.x + '&pinTitle=${productDetail.placeName}';
		    });
		    $('.btn_path').on('click', function() {
		    	location.href = 'https://m.map.naver.com/directions/?ename=${productDetail.placeName}&ex=' + result.items[0].point.x + '&ey=' + result.items[0].point.y
		    });
		});
    });
    </script>
</body>

</html>
