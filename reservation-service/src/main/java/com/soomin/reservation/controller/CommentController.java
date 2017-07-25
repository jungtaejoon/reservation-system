package com.soomin.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soomin.reservation.dto.Comment;
import com.soomin.reservation.dto.CommentScore;
import com.soomin.reservation.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@GetMapping("/products/{id}")
	public List<Comment> getComments(@PathVariable long id){
		return commentService.GetProductComment(id);
	}
	
	@GetMapping("/products/count/{id}")
	public CommentScore getCount(@PathVariable long id) {
		return commentService.CountProductComment(id);
	}

}
