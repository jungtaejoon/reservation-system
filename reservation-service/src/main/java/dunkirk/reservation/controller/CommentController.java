package dunkirk.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
	
	@GetMapping("comment-write")
	public String write(@RequestParam int reservationId){
		return "reviewWrite";
	}

	@GetMapping("/comment-read")
	public String readHome(@RequestParam int productId) {
		return "review";
	}

}
