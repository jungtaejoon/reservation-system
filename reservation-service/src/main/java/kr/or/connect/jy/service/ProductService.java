package kr.or.connect.jy.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.ProductDao;
import kr.or.connect.jy.dto.Product;
import kr.or.connect.jy.dto.ProductDTO;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public Collection<ProductDTO> selectByCategoryId(Integer categoryId) {
		return productDao.selectByCategoryId(categoryId);
	}

	public Collection<ProductDTO> selectAll() {
		return productDao.selectAll();
	}

	public Integer countAll() {
		return productDao.countAll();
	}

	public Integer countByCategoryId(Integer categoryId) {
		return productDao.countByCategoryId(categoryId);
	}

	public Collection<ProductDTO> selectByCategoryIdFromLast(Integer categoryId, Integer lastProductId) {
		return productDao.selectByCategoryIdFromLast(categoryId, lastProductId);
	}

	public Collection<ProductDTO> selectFromLast(Integer lastProductId) {
		return productDao.selectFromLast(lastProductId);
	}
	
}
