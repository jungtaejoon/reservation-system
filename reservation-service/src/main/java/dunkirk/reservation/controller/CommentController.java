package dunkirk.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dunkirk.reservation.service.CommentService;

@Controller
public class CommentController {
	
	private CommentService commentService;
	
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/comment-write")
	public String write(Model model, @RequestParam int reservationId){
		model.addAttribute("reservationId", reservationId);
		model.addAttribute("productName", commentService.getProductNameByReservationId(reservationId));
		return "reviewWrite";
	}

	@GetMapping("/comment-read")
	public String readHome(@RequestParam int productId) {
		return "review";
	}

}
