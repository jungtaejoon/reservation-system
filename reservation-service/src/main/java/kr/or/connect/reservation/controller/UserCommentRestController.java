package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.domain.UserComment;
import kr.or.connect.reservation.dto.ImageForDetail;
import kr.or.connect.reservation.service.UserCommentService;

@RestController
@RequestMapping("/api/comment")
public class UserCommentRestController {
	UserCommentService service;
	
	@Autowired
	public UserCommentRestController(UserCommentService service) {
		this.service = service;
	}
	
	@GetMapping("/comments/{productId}")
	public List<UserComment> getAll(@PathVariable Integer productId) {
		return service.getAll(productId);
	}
	
	@GetMapping("/images/{id}")
	public List<ImageForDetail> getImages(@PathVariable Integer id) {
		return service.getImages(id);
	}
}
