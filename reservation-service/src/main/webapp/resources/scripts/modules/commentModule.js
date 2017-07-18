

const commentModule_ = (function(){
	var HOST = "http://localhost:8080";
	var productId;
	
	
	
	function getComment() {
		var url = HOST + "/api/comment/comments/" + productId;
		
		getCommentAjax = $.ajax({
			url: url,
			type: "GET",
			dataType: "json"
		})
		.done(
				showComment.bind(this)
		)
		.fail(function() {
			//console.log("error");
		});
		
	}
	
	function showComment(response) {

		var source = $("#list_short_review_template").html();
		var template = Handlebars.compile(source);
		var comments = new Array();
		
		var average = 0;
		
		$.each(response, function(index, element) {
			var t = new Date(element.modify_date);
			var date = t.getFullYear() + "-" + (t.getMonth()+1) + "-" + t.getDate();
			//console.log(date);
			element.modify_date = date;
			comments.push(element);
			//console.log(element);
			average += parseFloat(element.score);

		});
		var data = {
				"comments": comments,
				"count": comments.length		
		};
		//console.log(data);
		var html = template(data);
		
		$(".list_short_review").append(html);
		
		
		
		
		var source = $("#grade_area_template").html();
		var template = Handlebars.compile(source);
		
		average = (average / 3).toPrecision(2) ;
		var commentstat = {
				"average": average,
				"length" : comments.length
		};
		var data = { "commentstat" : commentstat };
		var html = template(data);
		
		//console.log(data);
		
		$(".grade_area").append(html);

	}
	
	function getVisual(commentId) {
		var url = HOST + "/api/comment/images/" + commentId;
		
		getVisualAjax = $.ajax({
			url: url,
			type: "GET",
			dataType: "json"
		})
		.done(
				showVisual.bind(this)
		)
		.fail(function() {
			//console.log("error");
		});
	}
	
	function showVisual(response) {
		
		var source = $("#container_popup_template").html();
		var template = Handlebars.compile(source);
		var data = {commentVisual: response};
		var html = template(data);
		$(".section_popup ul").append(html);
		
		$(".section_popup .figure_pagination .num.off span").html(response.length);	
//		visualModule.setVisualImgNum(response.length);			
//		visualModule.setPrintPosition( $(".section_popup .figure_pagination .num:first-child") );
//		
		if(response.length <= 1) {
			$(".section_popup .prev").css("visibility", "hidden");
			$(".section_popup .nxt").css("visibility", "hidden");
		} else {
			$(".section_popup .prev").css("visibility", "");
			$(".section_popup .nxt").css("visibility", "");
		}
		
	}
	
	return {
		setProductId: function(id) {
			productId = id;
		},
	
		load: function() {
			getComment();
			getVisual(11);
		}
	}
	
	
})();