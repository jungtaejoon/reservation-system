/**
 * 
 */	
$(document).ready(function(){
		
		//  즉시 실행 함수, btn_my,  Eventbinding
		(function reservationCheck(){
			var session = '${session}';
			var $btn_my = $(".btn_my");
			var func ={};
			
			if(session){
				func = function reservationEvent(){
					location.href = '/my';
				}
			}else{
				func = function reservationEvent(){
					location.href = '/login';
				}
			}
			// 이벤트 등록
			$btn_my.on("click",func);
		})();
		
		function loopBoat() {  
		      $boat.animate({ 'bottom' : '15px'}, 500)
		        .animate({ 'bottom' : '25px'}, 500, loopBoat);
		    }
	});
