//category
	var CATEGORY = (function(){

		//private
		/* list */
		draw_view = function(categoryVO){
				var str = '<li class="item" data-category="0"> <a class="anchor active"> <span>전체</span> </a> </li>';
					var source = $("#category-template").html();
					//핸들바 템플릿 컴파일
					var template = Handlebars.compile(source);
				for ( var index in categoryVO) {
					str += template(categoryVO[index]);
				}
				$('#categoryList').html(str);
		};

		draw_admin_view = function (categoryVO) {
			var str = '<li class="item" data-category="0"> <a class="anchor active"> <span>전체</span> </a> </li>';
			for ( var index in categoryVO) {
				str += '<li class="item" data-category="' + categoryVO[index].id + '">' +
						'<span class="old-name">'+ categoryVO[index].name + '</span>' +
						'<input type="text" class="new-name" placeholder="NEW NAME"> ' +
						'<button value="수정" class="modify">MODIFY</button> ' +
						'<button value="삭제" class="destory"> REMOVE </button>' +
						'</li>';
			}
			$('#categoryList').append(str);
		};

		get_list = function (callback) {
			$.ajax({
				type : 'get',
				url : '/api/categories',
				success:function(result) {
					callback(result);
				}
			});
		};

		/* 삭제 부분 */
		remove_view = function (view, id) {
			view.remove();
		};

		remove = function (view, id, callback) {
			$.ajax({
				type:'delete',
				url:'/api/categories/' + id,
				success:function() {
					callback(view, id);
				}
			});
		};

		/* 수정 부분 */
		modify_view = function (view, newName, id) {
			view.find('.old-name').html(newName);
			view.find('.new-name').val("");
		};

		modify = function (view, id, name, callback) {
			$.ajax({
				type:'put',
				url:'/api/categories/' + id,
				contentType: "application/json; charset=utf-8",
				data:name,
				success:function() {
					callback(view, name);
				}
			});
		};
		/* 등록 부분 */
		register = function (view, name, callback){
			$.ajax({
				type:'post',
				url:'/api/categories',
				contentType: "application/json; charset=utf-8",
				data:name,
				success:function() {
					callback(name);
				}
			});
		};
		new_view = function (name){
			$('#categoryList').html("");
			get_list(draw_view);
		};

		//public
		return{
			get: function(){
				get_list(draw_view);
			},

			remove: function(event){
				var view = $(event.target).closest('.item');
				var id = view.data('category');
				remove(view, id, remove_view);
			},
			modify: function(event){
				var view = $(event.target).closest('.item');
				var newName = view.find('.new-name').val();
				var id = view.data('category');
				modify(view, id, newName);
			},
			register: function(event){
				var view = $(event.target).closest('#addCategory');
				var name = view.find('.name').val();
				register(view, name, new_view);
			}
		}
	})();
	CATEGORY.get();
