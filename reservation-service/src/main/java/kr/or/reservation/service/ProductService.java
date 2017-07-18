package kr.or.reservation.service;

import java.util.List;

import kr.or.reservation.domain.Product;

public interface ProductService {
	
	public List<Product> getProductByCategory(int start,int categoryId);
	public int countProduct(int categoryId);
}
