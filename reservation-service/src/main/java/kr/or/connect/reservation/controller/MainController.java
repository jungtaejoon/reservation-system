package kr.or.connect.reservation.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.reservation.dto.User;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String mainpage(){
    	
        return "mainpage";
     
    }
    
    @GetMapping("login")
    public String login(HttpServletRequest request) {
    	
    	 HttpSession session = request.getSession();
    	 
    	 if(session.getAttribute("loginIsOk")!=null)
    	 {
    		 
    	     session.removeAttribute("loginIsOk"); // 일단 자동으로 로그아웃 되도록 구현하였습니다.
    	     
    	     return "myreservation";
    	     
    	 }
    	 else
    	 {
    		 return "loginform";
    	 }

   }
    
    @GetMapping("loginform")
    public String loginform(HttpServletRequest request) {
       
    	   HttpSession session = request.getSession();
       
       User user = new User();
       
       user.setIslogin(1);
    	
    	 if(session.getAttribute("loginIsOk")==null)
    	 {
    		 
    		 session.setAttribute("loginIsOk", user);
    		 
    	 }
       
    	   return "mainpage";
   }
    
    @GetMapping("index")
    public String index(){
        return "index";
    }
    
    @GetMapping("test")
    public String test(){
        return "test2";
    }
}
