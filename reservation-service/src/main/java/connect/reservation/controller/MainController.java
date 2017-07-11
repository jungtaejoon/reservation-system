package connect.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import connect.reservation.domain.Category;
import connect.reservation.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin")
	public String index() {
		return "index";
	}
	
	//@RequestMapping("/", method=RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView mvMain() {
		ModelAndView model = new ModelAndView();
		
		List<Category> list = new ArrayList<Category>();
		list = categoryService.getAll();
		
		model.addObject("category", list);
		model.setViewName("mainpage");
		
		return model;
	}
	
//	@RequestMapping("/mvMyPage", method=RequestMethod.GET)
	@GetMapping("/mvMyPage")
	public String mvMyPage() {
		// 로그인을 하지 않은 유저는 로그인 페이지로
		// 로그인 한 후라면 "나의 예약 메인"페이지로 이동한다
		
		return "myreservation";
	}
}
