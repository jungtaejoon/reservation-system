
package kgw.reservation.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kgw.reservation.dao.FileDao;
import kgw.reservation.dao.ProductDao;
import kgw.reservation.dao.UserCommentDao;
import kgw.reservation.dto.ProductInfo;

@Service
@Transactional(readOnly=true)
public class ProductService {
	private ProductDao productDao;
	
	@Autowired
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public Collection<ProductInfo> findAllLimit(Integer offset, Integer size) {
		return productDao.selectAllLimit(offset, size);
	}
	
	public Collection<ProductInfo> findByCategoryLimit(Integer categoryId, Integer offset, Integer size) {
		return productDao.selectByCategoryLimit(categoryId, offset, size);
	}
	
	public Collection<ProductInfo> findById(Integer id) {
		return productDao.selectById(id);
	}
	
	public Integer countAll() {
		return productDao.countAll();
	}
	
	public Integer countByCategory(Integer categoryId) {
		return productDao.countByCategory(categoryId);
	}
	
	
	
	
}