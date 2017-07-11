$list = $("#category_list");

function deleteData(){

	$parent = $(this).parent();
	var id = $parent.attr('id');
	var URL = "http://localhost:8080/api/categories/"+id;

	$.ajax({
		url : URL,
		contentType:"application/json",
		type: "delete",
		success : function(){
			$parent.remove();
		}
	});

}

function updateData(){

	$parent = $(this).parent();
	$input = $parent.find("input");
	var id = $parent.attr('id');
	var name = $input.val();
	var URL = "http://localhost:8080/api/categories/"+id;
	var data = {'id': id,'name':name};

	$.ajax({
		url : URL,
		contentType:"application/json",
		type: "put",
		data: JSON.stringify(data),
		success : function(){
			$parent.find("h3").text(name);
			$input.val("");
		}
	});

}

$list.on("click",".del",deleteData);
$list.on("click",".update",updateData);