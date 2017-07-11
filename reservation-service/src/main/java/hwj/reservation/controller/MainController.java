package hwj.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hwj.reservation.domain.Category;
import hwj.reservation.service.CategoryService;

@Controller
@RequestMapping("/category")
public class MainController {
	 @Autowired
	 CategoryService categoryService;
	 private final Logger log = LoggerFactory.getLogger(MainController.class);

	@GetMapping
	public String readList(HttpServletRequest request){
		List<Category> cList = categoryService.getAllList();
		
		if(cList ==null){
			log.info("empty List");
		}else{
			log.info("cList");
		}
		 request.setAttribute("categoryList", cList);;
		
		 return "/index";
	}	
}
