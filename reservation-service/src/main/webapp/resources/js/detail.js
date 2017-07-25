var Detail = (function(){
		var id = '${id}';	
		var sales_flag = false;
		
		draw_image = function(image){
			var source = $("#image-template").html();
			var template = Handlebars.compile(source);
			var str;
			var head;
			var tail;
			for (var index in image) {
				if(index == 0){
					tail = template(image[index]);
				}
				head = template(image[index]);
				str += head;
			}
			str = head + str + tail;
			$(".visual_img").append(str);
			$(".visual_img").css("left", "-414px");
		};
		draw_detail_product = function(detailProduct){
			var source = $("#detail-product-template").html();
			var template = Handlebars.compile(source);
			var str;
			str = template(detailProduct);
			$('.section_info').append(str);
		};
		get_detail_product = function (id, callback) {
			$.ajax({
				type : 'get',
				url : '/api/products/' + id,
				success : function(result) {
					sales_flag = result.sales_flag;
					callback(result);
					get_image_list(id, draw_image);
				}
			});
		};	
		get_image_list = function (id, callback) {
			$.ajax({
				type : 'get',
				url : '/api/products/' + id + '/images',
				success : function(result) {
					callback(result);
				}
			});
		};	
		return{
			get: function(id) {
				get_detail_product(id, draw_detail_product);
			},
			get_image: function(id) {
				get_image_list(id, draw_image);
			},
			get_id: function() {
				return id;
			},
			get_sales_flag: function(){
				return sales_flag;
			}
		}
	})();