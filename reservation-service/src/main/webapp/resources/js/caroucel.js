// slide 와 관련된 부분  [Caroucel]

/* 
		초기 앞 2개 img를 뒤에 붙여, 전체 길이를 구함 . 해당 길이로
	 	[예시]
	 	순환 로직을 작성. A B C D => A B C D A B 
					0 1 2 3    0 1 2 3 4 5
		실행 방법 
					0에서 왼쪽 클릭시, 4로 이동하여 왼쪽으로 이동.
					4에서 오른쪽 클릭시, 0으로 이동하여 오른쪽으로 이동 하는 로직 
*/

$(document).ready(function(){
	/*
	 * @{values}
	 * carc_setting : 동작에 필요한 변수들의 집합
	 * carc_event :  함수들의 집합
	 * init : 실행에 필요한 변수들 초기화 
	 */
	var $ul = $(".visual_img"),
	carc_setting = {},
	carc_event = {},
	init = {},
	slidAutoEvent = {};
	

	
	// Jquery에서 OuterHtml이 없기에, 구현 
	// 해당 함수는 초기 앞 2개의 li를 구할때 사용 .
	function OuterHtml(url){
		return url.clone().wrapAll("<div/>").parent().html();
	}
	
	
	carc_setting = {
			total_length : 0,
			current_length : 0,
			moveLength : 0,
			maxLength : 0,
			imgLength : 338
	};
	
	carc_event = {
		caroucelLeft : function LeftEvent(){
							if(carc_setting.current_length !== 0){
								// ul 의 자식중 current_length 번쨰 를 선택 .
								$ul.animate({"right": "-="+carc_setting.imgLength}, "slow");
								carc_setting.moveLength -= carc_setting.imgLength;
								carc_setting.current_length --;
						
							}else{
								$ul.animate({"right": carc_setting.imgLength*2}, 0);
								$ul.animate({"right": "-="+carc_setting.imgLength}, "slow");
								carc_setting.moveLength = carc_setting.imgLength;
								carc_setting.current_length = 1;
							}
						},
		caroucelRight : function RightEvent(event){	
							if(carc_setting.current_length === carc_setting.total_length -1  ){
								$ul.animate({"right": 0}, 0);
								$ul.animate({"right": "+="+carc_setting.imgLength}, "slow");
								
								carc_setting.moveLength = carc_setting.imgLength;
								carc_setting.current_length =1;
								
								// 처음으로 돌아가는 코드
							}else{
								// ul 의 자식중 current_length 번쨰 를 선택 .
								$ul.animate({"right": "+="+carc_setting.imgLength}, "slow");
								carc_setting.moveLength += carc_setting.imgLength;
								++carc_setting.current_length;
							}
						},
		
		caroucelLeftClick : function LeftClickEvent(event){
								carc_event.clear();
								carc_event.caroucelLeft();
							},
		
		caroucelRightClick : function LeftClickEvent(event){
								carc_event.clear();
								carc_event.caroucelRight();
							},
							
					clear : function clearfunc(){
						clearInterval(slidAutoEvent.autoSlid_ID);
						clearTimeout(slidAutoEvent.startAuto);
						slidAutoEvent.startAuto =  setTimeout(slidAutoEvent.autoSlide,2000); 	
					
					}
			
	}
	
	
	init = {
		init_first : '',
		init_secon : '',
		setMax : function setMaxFunc(){
				for(var i =0; i < $ul.children().length -1; ++i){
					carc_setting.maxLength += $ul.children().eq(i).width();
				}
			},
		addOuterHtml :function initFunc(){
				init.init_first = OuterHtml($ul.children().eq(0));
				init.init_secon = OuterHtml($ul.children().eq(1));
				$ul.append(init.init_first).append(init.init_secon);
				carc_setting.total_length = $ul.children().length - 1 ;
			}	
	}
	
	slidAutoEvent = {
			startAuto : 0,
			autoSlid_ID : 0,
			autoSlide : function setfuc(){
			 	slidAutoEvent.autoSlid_ID = setInterval(carc_event.caroucelRight, 2000);
			}
	}
	
	// 초기 이미지 2개 추가하는 부분과 변수들 초기화
	init.setMax();
	init.addOuterHtml();
	slidAutoEvent.autoSlide();

	 
	
	$(".prev_inn").on("click",carc_event.caroucelLeftClick);
	$(".nxt_inn").on("click",carc_event.caroucelRightClick);
	
});