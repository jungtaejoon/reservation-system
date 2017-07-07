package kr.or.connect.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	CategoryService categoryService;
	
    @GetMapping
    public String home(Model model){
    	model.addAttribute("categories", categoryService.getAll());
        return "category";
    }

}