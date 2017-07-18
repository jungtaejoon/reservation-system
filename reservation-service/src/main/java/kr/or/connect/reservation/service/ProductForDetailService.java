package kr.or.connect.reservation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ProductForDetailDao;
import kr.or.connect.reservation.dto.ImageForDetail;
import kr.or.connect.reservation.dto.ProductForDetail;

@Service
public class ProductForDetailService {
	
	private ProductForDetailDao dao;
	
	@Autowired
	public ProductForDetailService(ProductForDetailDao dao) {
		this.dao = dao;
	}
	
	public ProductForDetail getInfo(Integer id) {
		return dao.getInfo(id);
	}
	
	public List<ImageForDetail> getImages(Integer id) {
		return dao.getImages(id);
	}
}
