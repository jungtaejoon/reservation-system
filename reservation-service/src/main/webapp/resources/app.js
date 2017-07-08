(function (window) {
	'use strict';

		function deleteItem(item) {
			var id = item.attr("id");
			$.ajax( {
				url: '/categorys/rest/remove/'+id,
				datatype: 'json',
				headers: {
					'content-Type': 'application/json'
				},
				type: 'DELETE',
				success: function() {
					console.log(id);
					item.parent().parent().remove();
				}
			})
		}
		
		$(".table").on("click", ".delete", function() {
			deleteItem($(this));
		});



})(window);
