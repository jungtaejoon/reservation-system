
	var COMMENT = (function(){
		var count = 0;
		var score = 0;
		
		draw_comment = function(comments, view){
			var source = $("#comment-template").html();
			var template = Handlebars.compile(source);
			var str="";
			for(var index in comments) {
				str += template(comments[index]);
			}
			$(view).append(str);
		};
		draw_count = function(count){
			$('em.green').append(count +"건");
		};
		draw_score = function(score){
			$('em.graph_value').css("width", score*20 + "%");
			$('strong.text_value > span').append(score);
		};
		
		get_comment_list = function (id, view, callback) {
			$.ajax({
				type : 'get',
				url : '/api/comments/' + id,
				success : function(result) {
					callback(result, view);
				}
			});
		};
		get_sample_comment_list = function (id, view, callback) {
			$.ajax({
				type : 'get',
				url : '/api/comments/sample/' + id,
				success : function(result) {
					callback(result, view);
				}
			});
		};
		get_count_comment = function (callback) {
			$.ajax({
				type : 'get',
				url : '/api/comments/count/' + id,
				success : function(result) {
					callback(result);
					if(result > 3){
						$('.btn_review_more').removeClass('invisible');
					}
				}
			});
		};
		get_average_score_comment = function (callback) {
			$.ajax({
				type : 'get',
				url : '/api/comments/score/' + id,
				success : function(result) {
					callback(result);
				}
			});
		};
		return{
			get: function(id, view){
				get_comment_list(id, view, draw_comment);
			},
			get_sample: function(id, view){
				get_sample_comment_list(id, view, draw_comment);
			},
			get_count: function(id){
				get_count_comment(draw_count);
			},
			get_average_score: function(id){
				get_average_score_comment(draw_score);
			}
			
		}
	
	})();