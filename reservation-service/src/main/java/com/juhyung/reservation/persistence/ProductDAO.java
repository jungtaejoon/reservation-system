package com.juhyung.reservation.persistence;

import java.util.List;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.dto.ProductDTO;

public interface ProductDAO {
	
	public List<ProductDTO> selectListPage(PageCriteria pageCriteria);
	public List<ProductVO> selectListByCategory(Integer categoryId, PageCriteria pageCriteria);
	public ProductDTO selectDetailProductById(Integer id);
	public Integer countOfSaleProduct();
	public List<ProductVO> selectLisPromotion();
}
