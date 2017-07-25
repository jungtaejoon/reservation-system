package com.juhyung.reservation.persistence;

import java.util.List;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.Price;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.dto.DetailProduct;
import com.juhyung.reservation.dto.ProductDTO;

public interface ProductDAO {
	
	public List<ProductDTO> selectListPage(PageCriteria pageCriteria);
	public List<ProductDTO> selectListByCategory(Integer categoryId, PageCriteria pageCriteria);
	public Integer countOfSaleProduct();
	public Integer countOfSaleProductByCategoryId(int id);
	public List<ProductVO> selectListPromotion();
	public DetailProduct selectDetailProductById(int id);
	
	public List<Price> selectPriceInfoByProduct(int id);
}
