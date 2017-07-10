package kr.or.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
    @GetMapping(path = "/")
    public ModelAndView selectAll(Model model){
    	ModelAndView mav = new ModelAndView("mainpage");
    	return mav;
    }
  

}