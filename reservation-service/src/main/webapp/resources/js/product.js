var ProductModule = (function(){

	var productAllCount;
	var showProductsDefaultCount = 4;//상품 전시 개수 기본값
	var $productdiv = $('.wrap_event_box');

	var $productLeftList = $('.wrap_event_box').find('ul.lst_event_box').eq(0);
	var $productRightList = $productLeftList.next();
	
	//핸들바 템플릿 가져오기
	var source = $("#product_template").html(); 

	//핸들바 템플릿 컴파일
	var product_template = Handlebars.compile(source); 
	
	return {
		selectProductAll : function(){
			var url ="/products";
			var categoryId = $(this).data('category');
			showProductsDefaultCount = 4;
			
			if(categoryId > 0) {
				url = "/products/"+ categoryId +"/categories";
			}
			
			$.ajax({
				type: "GET",
				url: url,
				success: function(productList){		
          
					//기존 상품 리스트 삭제
					$productdiv.find('li').remove();
					
					//리스트 개수
					productAllCount = productList.length;
					
					//리스트 저장
					$productdiv.data('productList', productList);

					ProductModule.loadProductsList(productList);
					ProductModule.productsCountHtml(productAllCount);
					
				}
			});
		},
		loadProductsList : function(productList){
			var half = showProductsDefaultCount/2;
			
			if(productAllCount < showProductsDefaultCount) {
				half = productAllCount/2;
			}
			
			for(var i=0; i<showProductsDefaultCount; i++){
				if( productAllCount <= i ) break;
				else if(i<half)	{
					$productLeftList.append(product_template(productList[i]));
				}
				else if(i>=half) {
					$productRightList.append(product_template(productList[i]));
				}
			}
		},
		productsCountHtml : function(productAllCount){
			var html = productAllCount + '개';
		    $('span.pink').text(html);
		},
		showMoreProducts : function(){
			var productMoreDefault = 10;//상품 증가 개수 기본값
			var allProduct = showProductsDefaultCount+productMoreDefault;//증가되어 보여질 모든 상품 수
			var half = showProductsDefaultCount + productMoreDefault/2;
				
			if(productMoreDefault > productAllCount-showProductsDefaultCount) {
				half = showProductsDefaultCount + ((productAllCount-showProductsDefaultCount)/2);
			}

			for(i=showProductsDefaultCount; i<allProduct; i++){
				
				if( productAllCount <= i ) break;
				else if(i<half)	$productLeftList.append(product_template($productdiv.data('productList')[i]));
				else if(i>=half) $productRightList.append(product_template($productdiv.data('productList')[i]));
				
			}
			
			showProductsDefaultCount +=10;
		},
		scrollAuto : function(){
			$(window).scroll(function() {
			    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	  	    	ProductModule.showMoreProducts(); 
			    }
			});
		}
		
	};
	
})();

ProductModule.selectProductAll();
ProductModule.scrollAuto();

$("ul.event_tab_lst").on('click', 'li.item', ProductModule.selectProductAll);
$("div.more").on('click', '.btn', ProductModule.showMoreProducts);
