package kr.or.connect.reservation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ProductForMainDao;
import kr.or.connect.reservation.domain.ProductForMain;

@Service
public class ProductForMainService {
	private Logger log = LoggerFactory.getLogger(ProductForMainService.class);
	private ProductForMainDao dao;
	
	@Autowired
	public ProductForMainService (ProductForMainDao dao) {
		this.dao = dao;
	}
	
	public List<ProductForMain> getAll(Integer start, Integer count) {
		log.info("ProductForMain - getAll()");
		return dao.getAll(start, count);
	}
	
	public List<ProductForMain> getByCategory(Integer categoryId, Integer start, Integer count) {
		log.info("ProductForMain - getByCategory()");
		return dao.getByCategory(categoryId, start, count);
	}
	
	public Integer countAll() {
		log.info("ProductForMain - countAll()");
		return dao.countAll();
	}
	
	public Integer countByCategory(Integer categoryId) {
		log.info("ProductForMain - countByCategory()");
		return dao.countByCategory(categoryId);
	}
	
	public List<ProductForMain> getVisual() {
		log.info("ProductForMain - getVisual()");
		return dao.getVisual();
	}
}
