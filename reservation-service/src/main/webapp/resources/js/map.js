$(function(){
	var addr = $(".store_info .store_addr_wrap .store_addr:first").html();
	var myaddress = addr;// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
	naver.maps.Service.geocode({address: myaddress}, function(status, response) {
		if (status !== naver.maps.Service.Status.OK) {
			return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
		}
		var result = response.result;
		var point = result.items[0].point.x+","+result.items[0].point.y;
		//https://openapi.naver.com/v1/map/staticmap.bin?clientId=7HYSSZyvxLo0lyAcabtI&url=http://localhost:8080/&crs=EPSG:4326&center=127.0039365,37.5764761&level=12&w=300&h=300&baselayer=default&markers=127.0039365,37.5764761
		
		var mapurl = "https://openapi.naver.com/v1/map/staticmap.bin?clientId=7HYSSZyvxLo0lyAcabtI&url=http://localhost:8080/&crs=EPSG:4326&center="+point+"&level=12&w=340&h=150&baselayer=default&markers="+point;
		$(".detail_location .box_store_info .store_location .store_map").attr("src", mapurl);	
	
		$('.detail_location .box_store_info .store_location').attr("href", "http://map.naver.com/?lng="+result.items[0].point.x+"&pinTitle="+$(".store_name").html()+"&level=2&pinType=SITE&lat="+result.items[0].point.y+"&enc=utf8");
		
	});	
});

