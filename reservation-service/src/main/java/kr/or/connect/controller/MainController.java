package kr.or.connect.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 강경미 on 2017. 6. 3..
 */
@Controller
@RequestMapping("/")
public class MainController {
	
    @GetMapping
    public String index(Model model){
        return "index";
    }

}