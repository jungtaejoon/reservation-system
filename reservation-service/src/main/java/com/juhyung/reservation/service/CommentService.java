package com.juhyung.reservation.service;

import java.util.List;

import com.juhyung.reservation.domain.Comment;
import com.juhyung.reservation.domain.PageCriteria;

public interface CommentService {
	
	public List<Comment> getCommentByProduct(int id);
	public List<Comment> getSampleComment(int id, PageCriteria pageCriteria);
	public int getCountComments(int id);
	public Double getAverageComments(int id);
}
