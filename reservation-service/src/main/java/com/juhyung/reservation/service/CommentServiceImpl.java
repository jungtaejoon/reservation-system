package com.juhyung.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.Comment;
import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.persistence.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public List<Comment> getCommentByProduct(int id) {
		return commentDao.selectCommentByProductId(id);
	}

	@Override
	public List<Comment> getSampleComment(int id, PageCriteria pageCriteria) {
		return commentDao.selectSampleCommnet(id, pageCriteria);
		}
	
	@Override
	public int getCountComments(int id) {
		return commentDao.selectCountComments(id);
	}

	@Override
	public Double getAverageComments(int id) {
		return commentDao.selectAverageScore(id);
	}
}
