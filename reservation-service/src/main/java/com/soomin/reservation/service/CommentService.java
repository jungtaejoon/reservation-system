package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.dto.Comment;
import com.soomin.reservation.dto.CommentScore;

public interface CommentService {
	public CommentScore CountProductComment(long productId);
	public List<Comment> GetProductComment(long productId);
}
