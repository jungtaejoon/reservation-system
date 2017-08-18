package dunkirk.reservation.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import dunkirk.reservation.dao.*;
import dunkirk.reservation.dto.*;
import dunkirk.reservation.service.*;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}
	
	@Override
	public List<CommentForDetailDto> getListByProduct(int page, int limit, int productId) {
		return commentDao.getListByProduct(page, limit, productId);
	}

	@Override
	public List<Integer> getImageIdList(int id) {
		return commentDao.getImageIdList(id);
	}

	@Override
	public String getProductNameByReservationId(int reservationId) {
		return commentDao.getProductNameByReservationId(reservationId);
	}
}
