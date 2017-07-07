$(function() {

	// remove 클릭시 삭제
	var removefunc = function(){
		var $tr = $(this).parents("tr");
		var id = $tr.data("id"); 
		// data-value
		$.ajax({
			  method: "DELETE",
			  contentType: "application/json; charset=utf-8",
			  url: "/"+id
		}).done(function( msg ) {
		    $tr.remove();
		}); 
	};
	
	// 클릭시 해당 name이 input에 들어가고, 수정하기 버튼 보이도록
	var updateReady = function(){
		// click 된  tr을 통해 data-id 를 가져오고, name의 값을 input에 넣는다
		var $tr = $(this).parents("tr");
		var id = $tr.data("id"); 
		var text = $tr.find(".name").text().trim();
		$("#modify").css("display","block");
		$("#submit").css("display","none");
		$("input[name=name]").val(text);
		$("input[name=name]").data("id",id);
	
	};
	
	// 수정하기 a tag 클릭시 ajax로 전송하고 , reload
	var updateSend = function(){
		var name = $("input[name=name]").val();
		var id = $("input[name=name]").data("id");
		var category = new Object();
		category.id = id;
		category.name = name;
		
		$.ajax({
			  method: "PUT",
			  url: "/"+id,
			  contentType: "application/json; charset=utf-8",
	          dataType: "json",
			  data : JSON.stringify(category)
		}).done(function( msg ) {
		    alert("수정되었습니다.");
		    location.reload();
		}); 
	};
	
	// 이벤트 바인딩 
	$(document).on("click",".remove", removefunc);
	$(document).on("click",".update", updateReady);
	$("#modify").on("click",updateSend);
});