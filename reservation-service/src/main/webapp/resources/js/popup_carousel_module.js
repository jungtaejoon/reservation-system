var Popcarousel = (function(){
		// private 변수, 함수 선언 	
		var	size;
		var	childCnt;
		var	cnt = 0;
		var item;

		function init(){

			this.append(this.children(".item")[0].outerHTML);
			this.append(this.children(".item")[1].outerHTML);
	
			size = this.outerWidth();
			childCnt= this.children().length-2;
			item = this.find(".item");
			this.css('width', childCnt*size);
		}
		
		function prevImg(){
			if(cnt <= 0){
				cnt = childCnt;
				item.animate({'left': -(cnt*size)+'px'}, 0);
			}
			cnt--;
			console.log('cnt = ' + cnt);
			item.animate({'left': -(cnt*size)+'px'}, 'normal');
		}
		
		function nextImg(){
			cnt++;
			item.animate({'left': -(cnt*size)+'px'}, 'normal');
			if(cnt == childCnt){
				cnt = 0;
				item.animate({'left': '0px'}, 0);
			}
		}
		return {
			init : init,
			prev : prevImg,
			next : nextImg
		}
	})();