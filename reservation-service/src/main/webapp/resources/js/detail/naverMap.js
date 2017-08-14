var NaverMap = (function(){
    var map = new naver.maps.Map('map');
    var myaddress;
    var pointX;
    var pointY;
    function init(){
    	myaddress = $('.store_addr.store_addr_bold').text();
    	getPosition();
    }
    function getPosition(){   	
	    naver.maps.Service.geocode({address: myaddress}, function(status, response) {
	        if (status !== naver.maps.Service.Status.OK) {
	            return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
	        }
	        var result = response.result;
	        var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
	        pointX = result.items[0].point.x;
	        pointY = result.items[0].point.y;
	        drawMap();
	    });
    }
    function drawMap(){
    	var mapSrc = 'https://openapi.naver.com/v1/map/staticmap.bin?clientId=eGDuy2NMeDv1C1QCsPGF&url=http://localhost:8080&crs=EPSG:4326&center='+pointX+','+pointY+'&level=11&w=300&h=250&baselayer=default&markers='+pointX+','+pointY;
        $('.store_map').attr('src',mapSrc);
        
        var mapUrl = "http://map.naver.com/?lng="+pointX+"&pinTitle="+$('.addr_detail').text()+"&level=2&pinType=SITE&lat="+pointY+"&enc=utf8";
        $('.store_location').attr('href', mapUrl);
    }
	return {
		init: init
	}
})();