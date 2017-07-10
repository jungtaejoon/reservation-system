$(function() {

	// remove 클릭시 삭제
	var removefunc = function(){
		var $tr = $(this).parents("tr");
		var id = $tr.data("id"); 
		
		// message
		var success = function() { $tr.remove(); }
		var fail = function(){ alert("삭제에 실패하엿습니다.")};
		
		// Delete ajax
		$.ajax({
			  method: "DELETE",
			  contentType: "application/json; charset=utf-8",
			  url: "/categorys/"+id
		}).then(success , fail);
		
	};
	
	// 클릭시 해당 name이 input에 들어가고, 수정하기 버튼 보이도록
	var updateReady = function(){
		// click 된  tr을 통해 data-id 를 가져오고, name의 값을 input에 넣는다
		var $tr = $(this).parents("tr");
		var $name = $("input[name=name]");
		var id = $tr.data("id"); 
		var text = $tr.find(".name").text().trim();
		
		// 버튼 none,  a tag block
		$("#modify").css("display","block");
		$("#submit").css("display","none");
		// input[name=name] text 설정 및 data 설정
		$name.val(text);
		$name.data("id",id);
			
	};
	
	// 수정하기 a tag 클릭시 ajax로 전송하고 , reload
	var updateSend = function(){
		
		var name = $("input[name=name]").val();
		var id = $("input[name=name]").data("id");
		
		// put에 담을 객체 생성 
		var category = new Object();
		category.id = id;
		category.name = name;
		
		// message
		var success = function() {
		    alert("수정되었습니다.");
		    location.reload();
		};
		
		var fail = function(){ alert("수정에 실패하엿습니다.")};
		
		//  Put ajax
		$.ajax({
			  method: "PUT",
			  url: "/categorys/"+id,
			  contentType: "application/json; charset=utf-8",
	          dataType: "json",
			  data : JSON.stringify(category)
		}).then(success , fail); 
	};
	
	// 이벤트 바인딩 
	$(document).on("click",".remove", removefunc);
	$(document).on("click",".update", updateReady);
	$(document).on("click","#modify",updateSend);
	
});