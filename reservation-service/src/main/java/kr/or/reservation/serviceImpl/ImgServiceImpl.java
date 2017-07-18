package kr.or.reservation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.reservation.dao.ImgDao;
import kr.or.reservation.domain.Img;
import kr.or.reservation.service.ImgService;

@Service
public class ImgServiceImpl implements ImgService {

	ImgDao imgDao;
	
	@Autowired
	public ImgServiceImpl(ImgDao imgDao) {
		this.imgDao = imgDao;
	}
	
	@Override
	public List<Img> selectList(int id) {
		// TODO Auto-generated method stub
		return imgDao.selectList(id);
	}
	
	@Override
	public Img selectOne(long fileId) {
		return imgDao.selectOne(fileId);
	}

}
