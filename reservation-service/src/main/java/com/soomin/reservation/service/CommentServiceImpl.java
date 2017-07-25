package com.soomin.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.reservation.dao.CommentDao;
import com.soomin.reservation.dto.Comment;
import com.soomin.reservation.dto.CommentScore;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDao commentDao;
	
	@Override
	public CommentScore CountProductComment(long productId) {
		// TODO Auto-generated method stub
		CommentScore score = commentDao.CountByProductId(productId);
		score.setPercent((int)(score.getScore()/score.getCount()*100));
		return score;
	}

	@Override
	public List<Comment> GetProductComment(long productId) {
		// TODO Auto-generated method stub
		return commentDao.SelectByProductId(productId);
	}
	
}
