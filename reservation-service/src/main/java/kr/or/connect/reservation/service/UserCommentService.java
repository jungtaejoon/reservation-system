package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.UserCommentDao;
import kr.or.connect.reservation.domain.UserComment;
import kr.or.connect.reservation.dto.ImageForDetail;

@Service
public class UserCommentService {
	private UserCommentDao dao;

	@Autowired
	public UserCommentService(UserCommentDao dao) {
		this.dao = dao;
	}
	
	public List<UserComment> getAll(Integer productId) {
		return dao.getAll(productId);
	}
	
	public List<ImageForDetail> getImages(Integer id) {
		return dao.getImages(id);
	}
}
