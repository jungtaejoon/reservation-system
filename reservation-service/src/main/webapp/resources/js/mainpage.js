(function () {

    var num = 1;
    var slide_width = $('.visual_img > li').outerWidth();
    var slide_count = $('.visual_img > li').length;
    var auto = true;
    var event_num = 0;
    var cur_display_num = 0;
    var cat_num = 0;
    var SETTIMEOUT;
    var SETINTERVAL;
    var source;
    var template;

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

           soruce = $("#category-template").html();
           template = Handlebars.compile(soruce);

          for(var i = 0 ; i < data.length-1 ; i++)
            addElementLi(data[i].name,data[i].id);

           soruce = $("#category-last-template").html();
           template = Handlebars.compile(soruce);

            addElementLiLast(data[data.length-1].name,data[data.length-1].id);
       }
      });
     }

     function addElementLi(name,id) {

        var context = {name: name , id: id};
        var html    = template(context);

        $(".section_event_tab ul").show();
        var $element_ul = parent.$(".section_event_tab ul");

        $(html).appendTo($element_ul);

        }

      function addElementLiLast(name,id) {

        var context = {name: name , id: id};
        var html    = template(context);

        $(".section_event_tab ul").show();
        var $element_ul = parent.$(".section_event_tab ul");

        $(html).appendTo($element_ul);

        }

      function getMorelistCategory(start,id){

        $.ajax({
         url: "./products/"+start+"/"+id,
         type: "GET",
         contentType:"application/json; charset=UTF-8",
         dataType:"json",
         success: function(data){

           source = $("#entry-template").html();
           template = Handlebars.compile(source);

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

           source = $("#entry-template").html();
           template = Handlebars.compile(source);

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

  })();
