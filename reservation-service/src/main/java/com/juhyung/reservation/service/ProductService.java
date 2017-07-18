package com.juhyung.reservation.service;

import java.util.List;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.dto.ProductDTO;

public interface ProductService {

	public List<ProductDTO> getListPage(PageCriteria pageCriteria);
	public List<ProductVO> getListByCategory(Integer categoryId, PageCriteria pageCriteria);
	public ProductDTO detailProductById(Integer id);
	public Integer getCountSaleProduct();
	public List<ProductVO> getListPromotion();
}
