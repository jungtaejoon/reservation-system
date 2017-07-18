package kr.or.reservation.restController;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.reservation.domain.Product;
import kr.or.reservation.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class RestProductController {

	@Autowired
	ProductService productService;
	
	Logger log = Logger.getLogger(this.getClass());
	
	//@RequestParam(defaultValue = "0", name = "startPoint") int startPoint
	
	
	// get Query 에 대하여       
	// 그냥 쿼리를 쓰는 방향으로 ....  ~ 
	@GetMapping
	@RequestMapping("/category/{categoryId}/start/{start}")
	public List<Product> selectAll(@PathVariable(name = "categoryId") int categoryId,
			@PathVariable(name = "start") int start){
		List<Product> list = productService.getProductByCategory(start,categoryId);
		return list;
	}

	@GetMapping
	@RequestMapping("/counter/{categoryId}")
	public int countProduct(@PathVariable(name= "categoryId") int categoryId){
    	return productService.countProduct(categoryId);
	}
	
	@GetMapping
	@RequestMapping("/counter")
	public int countProductAll(){
    	return productService.countProduct(0);
	}
	
	

	
	/*
	// 컨트롤러 하나로 url 2개를 받아 처리하려 했지만 java.lang.String cannot be cast to java.lang.Long 
	 // error로 실패 
	@GetMapping
	@RequestMapping(value = {"/counter/{category}","/counter"})
	public int countProductByCategory(@PathVariable Map<String, Integer> map){
		int categoryId = 0;
		if (map.containsKey("category")) {
			categoryId = map.get("category").intValue();
	    } 
		return productService.countProduct(categoryId);
	}
	
	// 이렇게 따로 분리할것인가 ?
	@GetMapping
	@RequestMapping("/counter")
	public int countProductAll(){
    	return productService.countProduct(0);
	}
	*
	*
	*/

}
