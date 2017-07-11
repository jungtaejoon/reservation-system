(function (window){
	var apiURL = '/category/api';
	var URL = '/category';
	
	function CategoryObj(id, name){
		this.id = id;
		this.name = name;
	}
	//update event handler
	$('.category-List').on("click", ".modify", function(event){
		var id = $(this).get(0).id;
		var name = $('.mod_name'+id).val();
		var updateUrl = apiURL+'/'+id;
		var category = new CategoryObj(id, name);
		//console.log(category);
		if(category.name==""||category.name.length<2){
			alert("수정할 이름을 최소 2자 입력해주세요");
		}
		if(category.name!=""&& category["name"].length>=2){
			var jsonData = JSON.stringify(category);
			doUpdate(updateUrl, category, jsonData);
		}
	})
	
	//update function
	function doUpdate(updateUrl, category, jsonData){
		$.ajax({
			method:"PUT",
			url:updateUrl,
			data:jsonData,
			headers:{
					"Content-Type":"application/json"
			},
			success:function(){
				$('.display'+category["id"]).text(category["name"]);
			}
		});
	}
	//delete event handler
	$('.category-List').on("click", ".delete", function(event){
		//alert("delete button clicked ");
		var deleteId = $(this).get(0).id;
		var deleteUrl = apiURL+'/'+deleteId;
		 doDelete(deleteUrl, deleteId);
	})

	//delete function
	function doDelete(deleteUrl, id){
		 $.ajax({
			type:'DELETE',
			url:deleteUrl,
			success: function(){
				console.log("delete success");
				$('.'+id).remove();
			}
		});
	 
	}
})(window);