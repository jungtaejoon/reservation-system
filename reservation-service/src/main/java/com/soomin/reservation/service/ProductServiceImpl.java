package com.soomin.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.reservation.dao.ProductDao;
import com.soomin.reservation.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> viewPromotion() {
		// TODO Auto-generated method stub
		return productDao.SelectPromotion();
	}

	@Override
	public Long numberOfProduct(Long categoryId) {
		// TODO Auto-generated method stub
		if(categoryId==0) {
			return productDao.CountAll();
		}
		else {
			return productDao.CountByCategory(categoryId);
		}
		
	}

	@Override
	public List<Product> viewProduct(Long categoryId, Long offset) {
		// TODO Auto-generated method stub
		if(categoryId==0) {
			return productDao.SelectProductAll(offset*10);
		}
		else {
			return productDao.SelectProductByCategoryId(categoryId, offset*10);
		}
	}
}
