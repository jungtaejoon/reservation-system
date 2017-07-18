package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.domain.Product;

public interface ProductService {
	public List<Product> viewPromotion();
	public Long numberOfProduct(Long categoryId);
	public List<Product> viewProduct(Long categoryId, Long offset);
}
