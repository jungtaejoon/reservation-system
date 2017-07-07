package kr.or.connect.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

/**
 * Created by 강경미 on 2017. 6. 3..
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
    @GetMapping
    public String index(Model model){
    	model.addAttribute("categories", categoryServiceImpl.getAll());
        return "index";
    }

}