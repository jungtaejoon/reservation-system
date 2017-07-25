var CategoryModule = (function(){
	//핸들바 템플릿 가져오기
	var source = $("#category_template").html(); 

	//핸들바 템플릿 컴파일
	var categoryTemplate = Handlebars.compile(source); 
	
	var categoryActive = function(){
		$('ul.tab_lst_min li a.active').removeClass('active');
		$(this).children().eq(0).addClass('active');
	};
	
	var loadCategoryAll = function(categoryList){
		var $categoryList = $('ul.tab_lst_min');
	    
	    var data = { categoryList };
	    
	    $categoryList.append(categoryTemplate(data));
	};
	
	var categoryInit = function(){
		$.ajax({
			type: "GET",
			url:"/categories",
			success: function(categoryList){
				CategoryModule.loadCategoryAll(categoryList);
			}
		});
	};
	
	return {
		categoryActive : categoryActive,
		loadCategoryAll : loadCategoryAll,
		categoryInit : categoryInit
	}
})();

CategoryModule.categoryInit();

$("ul.tab_lst_min").on('click',  'li.item', CategoryModule.categoryActive);








