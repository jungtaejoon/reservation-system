package kr.or.connect.jy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.CommentDao;
import kr.or.connect.jy.dao.ProductDao;
import kr.or.connect.jy.dto.CommentDTO;
import kr.or.connect.jy.dto.CommentImageDTO;
import kr.or.connect.jy.dto.Product;

@Service
public class CommentService {
	@Autowired
	CommentDao commentDao;

	@Autowired
	ProductDao productDao;

	public CommentService(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}

	public Map<String, Object> getUserCommentInfoMap(int productId) {
		Map<String, Object> userCommentInfoMap = new HashMap<>();
		Product product = productDao.selectById(productId);
		List<CommentDTO> comments = commentDao.selectCommentsByProductIdRecentLimit3(productId);
		userCommentInfoMap.put("product", product);
		userCommentInfoMap.put("comments", comments);
		userCommentInfoMap.put("totalCount", countByProductId(productId));
		userCommentInfoMap.put("totalScore", sumScoreByProductId(productId));

		return userCommentInfoMap;
	}

	public Integer countByProductId(int productId) {
		return commentDao.countCommentsByProductId(productId);
	}

	public Double sumScoreByProductId(int productId) {
		return commentDao.sumScoreByProductId(productId);
	}

	public List<CommentImageDTO> getCommentImages(int commentId) {
		return commentDao.selectImagesByUserCommentId(commentId);
	}
}
