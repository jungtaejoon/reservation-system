<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/lib/handlebars.min.js"></script>
<script type="text/javascript" src="/resources/lib/jquery.min.js"></script>

<script id="entry-template3" type="text/x-handlebars-template">
<div class="entry">
  <h1>"{{title}}"</h1>
  <div class="body">
    asdf{{body}}asf
  </div>
</div>
</script>

  <script id="entry-template" type="text/x-handlebars-template">
    <li class="item">
     <a href="#" class="item_book">
      <div class="item_preview"> <img alt="{{name}}" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945"><span class="img_border"></span> </div>
       <div class="event_txt">
         <h4 class="event_txt_tit"> <span>{{name}}</span> <small class="sm">{{place}}</small> </h4>
         <p class="event_txt_dsc">{{desc}}</p>
       </div>
     </a>
    </li>
  </script>

 <script id="entry-template3" type="text/x-handlebars-template">
  <li class="item" data-category={{id}}>
   <a class="anchor"> <span>{{name}}</span> </a>
  </li>
 </script>

</head>
<body>

  <script type="text/javascript" >

  var string = 'c'

  var obj = {
    string: 'zero',
    yell: function() {
      console.log(this.string);
    }
  };

  var obj2 = {
    string: 'what?'
  };
obj.yell.apply();
//  obj.yell(); // 'zero';
//  obj.yell.call(); // 'what?'

  var Test2 =
{
	a : 13,
	init : function(){
		// 여기서는 this가 무조건 test
		$('#test').on('click',this.click.bind(this,4,2));
	},
	click:function(event,a){
	//this가 test가 된다.
	//a->1,b->2
	console.log(this.a);
  console.log(event);
  console.log(a);
}
};
$(function (){
var Test =
{
	a : 1,
	init : function(){
		$('#test').on('click',this.click);
	},
	click : function(){
	//this는 element임
	console.log($(this).text());
}
};

Test.init();
});
//Test2.init();

function deleteList(i) {
			  $.ajax({
			    url: "./categories/"+i,
			    type: "DELETE",
			    contentType:"application/json; charset=UTF-8",
			    success: deleteListdom()
			  });
			}

function deleteListdom(){
  $(this).closest("tr").remove();
  alert("카테고리 삭제를 완료하였습니다.");
}

function deleteList(i) {
			  $.ajax({
			    url: "./categories/"+i,
			    type: "DELETE",
			    contentType:"application/json; charset=UTF-8",
			    success: deleteListdom().bind(this,i)
			  });
}

        function deleteListdom(res,i)
        {
          $(this).closest("tr").remove();
          alert("카테고리 삭제를 완료하였습니다.");
        }
//////////////////////

var qa = 10;

var Test4 = {
 q : 1
}

var Test5 = {
q : 2
}

function test1()
{
console.log(this.qa);

}

test1();
//test.apply(Test4,[3,4]);
//test.apply(Test, [1,2]);  //1 리턴 apply는 함수의 매개변수에 배열로 넣을 수 있음.
//test.call(Test,1,2); //

//test.apply(Test2); //2 리턴
//test.call(Test2);

/*
$('<li class="item" ><a href="#" class="item_book"><div class="item_preview"> <img alt="" class="" src=""><span class="img_border"></span> </div><div class="event_txt"><h4 class="event_txt_tit"> <span></span> <small class="sm"></small> </h4><p class="event_txt_dsc"></p></div></a></li>').appendTo($element_ul);

$('<li class="item">'
+'<a href="#" class="item_book">'
+'<div class="item_preview"> <img alt="'+name+'" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945"><span class="img_border"></span> </div>'
+'<div class="event_txt">'
+'<h4 class="event_txt_tit"> <span>'+name+'</span> <small class="sm">'+place+'</small> </h4>'
+'<p class="event_txt_dsc">'+desc+'</p>'
+'</div>'
+'</a>'
+'</li>').appendTo($element_ul);
*/

var ab = 10;
var testt =
{
	ab : 1,
	init : function(fp){
		fp.call(this);
    fp();
	},
	some: function(){
		console.log(this.ab);
	}
};
testt.init(testt.some);
testt.some();

    var source   = $("#entry-template").html();
    var template = Handlebars.compile(source);

    var context = {title: "My New Post", body: "This is my first post!"};
    var html    = template(context);
    console.log(html);
  </script>

<div id = 'test'>tesat</div>



</body>




<script type="text/javascript" >
$(function () {

    var num = 1;
    var slide_width = $('.visual_img > li').outerWidth();
    var slide_count = $('.visual_img > li').length;
    var auto = true;
    var event_num = 0;
    var cur_display_num = 0;
    var cat_num = 0;
    var SETTIMEOUT;
    var SETINTERVAL;
    var isLogin = 'as';
    var source   = $("#entry-template").html();
    var template = Handlebars.compile(source);

    if(auto) SETINTERVAL = setInterval(autoRightMove, 2000);

    getList();
    getMorelistAll(0);

        $(document).on('click',".nxt_e" ,function() {

          clearInterval(SETINTERVAL);
          clearTimeout(SETTIMEOUT);
          SETTIMEOUT = setTimeout(goInterval,4000);

             if(num!=slide_count)
             {
              $( ".visual_img" ).animate({ "left": "-="+slide_width+"px" }, "slow" );
              num++;
             }
          });

        $(document).on('click', ".prev_e" ,function() {

          clearInterval(SETINTERVAL);
          clearTimeout(SETTIMEOUT);
          SETTIMEOUT = setTimeout(goInterval,4000);

            if(num!=1)
            {
             $( ".visual_img" ).animate({ "left": "+="+slide_width+"px" }, "slow" );
             num--;
            }
          });

         $(document).on('mouseenter', ".movebtn" ,function() {

               if(!auto) return false;
               clearInterval(SETINTERVAL);

               auto = false;

                if(SETTIMEOUT==null){
                 SETTIMEOUT = setTimeout(goInterval,4000);
                }

           });

          function goInterval(){

            clearTimeout(SETTIMEOUT);
            SETTIMEOUT = null;
            SETINTERVAL = setInterval(autoRightMove, 2000);
            auto = true;
          }

          function autoRightMove(){

              if(num>slide_count-1){

                num = 0;
              }

              $( ".visual_img" ).animate({'left': -(num*slide_width)+'px' },'normal');

              num++;
          }

           $(document).on('click','.more',function(){

             if(cat_num==0){

               getMorelistAll(cur_display_num);
             }else{

               getMorelistCategory(cur_display_num,cat_num);
             }

/*
             var category = $('.lst_event_box').eq(0).find('.event_txt_tit').eq(0).text(); // 현재 공연 정보 카테고리
             category = category.split(' ');
             category = category[1];
             //console.log(category);

             var cat = $('.section_event_tab ul li').find('.active').text(); // 선택한 카테고리
             cat = cat.split(' ');
             cat = cat[1];

             if(category == cat)
             console.log("same");
             else {
               console.log("dif");
             }

             var d = $('.section_event_tab ul li').find('.last').text();
             console.log(d);
*/

/*
$('<li class="item" data-category='+id+'>'
+'<a class="anchor"> <span>'+name+'</span> </a>'
+ "</li>").appendTo($element_ul);
*/
           });



    $(document).on('click', ".section_event_tab ul li" ,function(){

      $('.section_event_tab ul li').children().removeClass('active'); //

      $(this).children().addClass('anchor active'); //
/*
      $('.lst_event_box li').removeClass('item');
      $('.lst_event_box li').addClass('dimm_dark');
*/
      $('.lst_event_box li').remove();

      cur_display_num = 0;

      cat_num = $(this).data('category');

      if(cat_num == 0){

        getMorelistAll(cur_display_num);
      }else{

        getMorelistCategory(cur_display_num,cat_num);
      }

    });

    function getList(){

      $.ajax({
       url: "./categories",
       type: "GET",
       contentType:"application/json; charset=UTF-8",
       dataType:"json",
       success: function(data) {
          for(var i = 0 ; i < data.length-1 ; i++)
            addElementLi(data[i].name,data[i].id);

            addElementLiLast(data[data.length-1].name,data[data.length-1].id);
       }
      });
     }

     function addElementLi(name,id) {

        $(".section_event_tab ul").show();
        var $element_ul = parent.$(".section_event_tab ul");
        $('<li class="item" data-category='+id+'>'
        +'<a class="anchor"> <span>'+name+'</span> </a>'
        + "</li>").appendTo($element_ul);
        }

      function addElementLiLast(name,id) {

        $(".section_event_tab ul").show();
        var $element_ul = parent.$(".section_event_tab ul");
        $('<li class="item" data-category='+id+'>'
        +'<a class="anchor last"> <span>'+name+'</span> </a>'
        + "</li>").appendTo($element_ul);
        }

      function getMorelistCategory(start,id){

        $.ajax({
         url: "./products/"+start+"/"+id,
         type: "GET",
         contentType:"application/json; charset=UTF-8",
         dataType:"json",
         success: function(data){

           for(var i in data.product){
             if(i%2==0){
              leftUlAddLi(data.product[i].name,data.product[i].place_name,data.product[i].description);
             }
             else {
              rightUlAddLi(data.product[i].name,data.product[i].place_name,data.product[i].description);
             }
           }

           cur_display_num+= 10;
           event_num = data.count;
           showProductNum(event_num);
         }
        });
      }

      function getMorelistAll(start){

        $.ajax({
         url: "./products/"+start,
         type: "GET",
         contentType:"application/json; charset=UTF-8",
         dataType:"json",
         success: function(data){

           for(var i in data.product){

             if(i%2==0){

              leftUlAddLi(data.product[i].name,data.product[i].place_name,data.product[i].description);
             }else {

              rightUlAddLi(data.product[i].name,data.product[i].place_name,data.product[i].description);
             }
           }

           cur_display_num+= 10;
           event_num = data.count;
           showProductNum(event_num);

         }
        });
      }

      function showProductNum(num){

        $('.pink').text(num+'개');
      }

      function rightUlAddLi(name,place,desc){

        var context = {name: name , place: place, desc: desc};
        var html    = template(context);

        $("#right_ul").show();
        var $element_ul = parent.$("#right_ul");

        $(html).appendTo($element_ul);

      }

      function leftUlAddLi(name,place,desc){

        var context = {name: name , place: place, desc: desc};
        var html    = template(context);

        $("#left_ul").show();
        var $element_ul = parent.$("#left_ul");

        $(html).appendTo($element_ul);

      }

  });
</script>

</html>
