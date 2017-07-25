package kr.or.connect.serviceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import kr.or.connect.dao.*;
import kr.or.connect.dto.*;
import kr.or.connect.service.*;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}

	@Override
	public List<CommentDto> selectByProduct(Long productId, Integer start, Integer amount) {
		return commentDao.selectByProduct(productId, start, amount);
	}

	@Override
	public List<Long> getImages(Long id) {
		return commentDao.getImages(id);
	}

	@Override
	public int getImageCounts(Long id) {
		return commentDao.getImageCounts(id);
	}

}
