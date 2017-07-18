package com.juhyung.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.dto.ProductDTO;
import com.juhyung.reservation.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDao;
	
	@Override
	public List<ProductDTO> getListPage(PageCriteria pageCriteria) {
		return productDao.selectListPage(pageCriteria);
	}

	@Override
	public List<ProductVO> getListByCategory(Integer categoryId, PageCriteria pageCriteria) {
		return productDao.selectListByCategory(categoryId, pageCriteria);
	}

	@Override
	public ProductDTO detailProductById(Integer id) {
		return productDao.selectDetailProductById(id);
	}

	@Override
	public Integer getCountSaleProduct() {
		return productDao.countOfSaleProduct();
	}

	@Override
	public List<ProductVO> getListPromotion() {
		return productDao.selectLisPromotion();
	}

}
