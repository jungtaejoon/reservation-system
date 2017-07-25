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
	public List<Product> getPromotion() {
		// TODO Auto-generated method stub
		return productDao.SelectPromotion();
	}

	@Override
	public Long countProduct(Long categoryId) {
		// TODO Auto-generated method stub
		if(categoryId==0) {
			return productDao.CountAll();
		}
		else if(categoryId>0){
			return productDao.CountByCategory(categoryId);
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<Product> getProduct(Long categoryId, Long offset) {
		// TODO Auto-generated method stub
		if(categoryId==0) {
			return productDao.SelectProductAll(offset*10);
		}
		else if(categoryId>0){
			return productDao.SelectProductByCategoryId(categoryId, offset*10);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Product> getDetailById(Long id) {
		// TODO Auto-generated method stub
		if(id>0) {
			return productDao.SelectProductById(id);
		}
		else {
			return null;
		}	
	}
}
