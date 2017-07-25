package won.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.FileDao;
import won.reservation.domain.File;
import won.reservation.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	private FileDao dao;
	
	@Autowired
	public FileServiceImpl(FileDao dao) {
		this.dao = dao;
	}
	
	@Override
	public String get(Integer id) {
		return dao.selectById(id);
	}
	
	@Override
	public List<File> getProductImgs(Integer productId) {
		if(productId < 1 || productId == null) {
			return null;
		}
		return dao.selectByProductId(productId);
	}
	
	@Override
	public List<File> getProductDetailImgs(Integer productId) {
		if(productId < 1 || productId == null) {
			return null;
		}
		return dao.selectDetailByProductId(productId);
	}
	
	@Override
	public List<File> getReservationUserCommentImgs(Integer reservationUserCommentId) {
		if(reservationUserCommentId < 1 || reservationUserCommentId == null) {
			return null;
		}
		return dao.selectByReservationUserCommentId(reservationUserCommentId);
	}
	
}
