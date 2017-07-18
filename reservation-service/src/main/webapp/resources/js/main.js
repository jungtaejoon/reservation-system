
var rolling = (function(){
    var promotionCount=0;
    var intervalId ;
    var timeoutId;
    var promotionSize=$(".visual_img > li") .size()-3;
    var rollingFlag = 0;

    function timeoutRolling(){
       clearInterval(intervalId);
       clearTimeout(timeoutId);

       timeoutId = setTimeout(function(){
           intervalId = setInterval(rolling.nxtRolling, 2000);
       }, 4000);
   }

    return {
        intervalRolling : function(){

            intervalId = setInterval(rolling.nxtRolling, 2000);

        },
        getRollingFlag : function(){
            return rollingFlag;
        },
        // rolling에 flag를 줘서 이벤트 발생 도중이면 이벤트를 스킵
        // animate에 callback함수 등록
         nxtRolling:function(a){
            rollingFlag=1;
        	if(promotionCount< promotionSize){

                $(".visual_img").animate({ "left": "-=338px" }, "slow",function(){
                  rollingFlag = 0;
                  promotionCount++;
                });

        	}else{
                $(".visual_img").css("left","0px");
                $(".visual_img").animate({ "left": "-=338px" }, "slow",function(){
                    rollingFlag = 0;
                    promotionCount = 0;
                });
            }

            timeoutRolling();

        },
         preRolling:function(){
            rollingFlag=1;
            if(promotionCount>0){
        		$(".visual_img").animate({ "left": "+=338px" }, "slow",function(){
                    rollingFlag=0;
                    promotionCount--;
                } );
        	}else{
                $(".visual_img").animate({ "left": "+=338px" }, "slow",function(){
                    $(".visual_img").css('left',-(338*(promotionSize+1)));
                    rollingFlag=0;
                    promotionCount = promotionSize;
                });
            }
            timeoutRolling();

        }

    }
})();

var product = (function () {
    var $left_box = $("#left_event_box");
    var $right_box = $("#right_event_box");
    var left = 1;
    var productCount=0;
    var productPage =1;
    var categoryId = 0;

    function makeItem(name,place_name,events){
    	var item = '<li class="item"><a href="/detail" class="item_book">'
    				+'<div class="item_preview"> <img alt="" class="img_thumb" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmmKoo3joGerzoJhHPURVvaBPD_BItngNY7FDyAxi8DS6EtwJH">'
    				+'<span class="img_border"></span> </div>'
    	            +'<div class="event_txt">'
    	            +'<h4 class="event_txt_tit"> <span>'+name
    	            +'</span> <small class="sm">'+place_name+'</small> </h4>'
    	            +'<p class="event_txt_dsc">'+events+'</p></div></a></li>';
    	return item;
    }

  return {
      productsByCategory : function(){
          if(categoryId){
              var URL = "http://localhost:8080/api/products/categories/"+categoryId+"/pages/"+productPage;
          }
          else{
              var URL = "http://localhost:8080/api/products/pages/"+productPage;
          }
          $.ajax({
              url : URL,
              contentType:"application/json",
              type: "get",
              success : function(data){
                  for(var i=0;i<data.length;i++){
                      if(left){
      					$left_box.append(makeItem(data[i].name,data[i].placeName,data[i].event));
                          left =0;
      				}
      				else{
      					$right_box.append(makeItem(data[i].name,data[i].placeName,data[i].event));
                          left =1;
      				}
                  }
              }
          });
      },
      categoryShow : function(){
          left =1;
          productPage = 1;
          categoryId = $(this).data("category");
      	$(".event_tab_lst.tab_lst_min").find(".active").toggleClass("active");
      	$(this).children().toggleClass("active");
          $left_box.empty();
          $right_box.empty();

          product.productsByCategory();
      },
      loadProductScroll : function (){
          var maxHeight = $(document).height();
          var currentScroll = $(window).scrollTop() + $(window).height();

          if (maxHeight <= currentScroll + 100) {
              productPage++;
              product.productsByCategory();
          }
      },
      loadCategory:function(){
      	$list = $(".event_tab_lst.tab_lst_min");

      	var URL = "http://localhost:8080/api/categories";

      	$.ajax({
      		url : URL,
      		contentType:"application/json",
      		type: "get",
      		success : function(data){
      			for(var i=0;i<data.length;i++){
      				$list.append('<li class="item" data-category="'+data[i].id+'"><a class="anchor"> <span>'+data[i].name+'</span> </a></li>');
      			}
      		}
      	});
      }
  };

})();

$(document).ready(function() {
    $(".visual_img").css("left","-338px");

	product.productsByCategory();

	product.loadCategory();

    $(document).scroll(product.loadProductScroll);

});

$(".event_tab_lst.tab_lst_min").on("click","li",product.categoryShow);
rolling.intervalRolling();

$(".btn_pre_e").on("click",function(){
  if(!rolling.getRollingFlag()){
      rolling.preRolling();
  }
});
$(".btn_nxt_e,.nxt_fix").on("click",function(){
  if(!rolling.getRollingFlag()){
      rolling.nxtRolling();
  }
});
