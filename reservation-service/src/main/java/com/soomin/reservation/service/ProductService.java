package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.domain.Product;

public interface ProductService {
	public List<Product> getPromotion();
	public Long countProduct(Long categoryId);
	public List<Product> getProduct(Long categoryId, Long offset);
	public List<Product> getDetailById(Long id);
}
