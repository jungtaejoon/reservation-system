package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CommentDAO;
import kr.or.connect.reservation.domain.File;
import kr.or.connect.reservation.domain.ReservationUserComment;

@Service
public class CommentService {

	@Autowired
	private CommentDAO dao;
	
	@Transactional(readOnly = true)
	public List<ReservationUserComment> selectComments(int id) {
		return dao.selectComments(id);
	}

	@Transactional(readOnly = true)
	public File selectCommentImage(int id) {
		return dao.selectCommentImage(id);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> selectCommentsCount(int id) {
		Map<String, Object> map = dao.selectCommentsCount(id); 
		double percent = Double.parseDouble(String.valueOf(map.get("avg")))/5.0 * 100;//평점 계산
		
		map.put("percent", percent);
		
		return map;
	}

}
