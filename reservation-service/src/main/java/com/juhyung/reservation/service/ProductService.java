package com.juhyung.reservation.service;

import java.util.List;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.Price;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.domain.Reservation;
import com.juhyung.reservation.dto.DetailProduct;
import com.juhyung.reservation.dto.ProductDTO;

public interface ProductService {

	public List<ProductDTO> getListPage(PageCriteria pageCriteria);
	public List<ProductDTO> getListByCategory(Integer categoryId, PageCriteria pageCriteria);
	public Integer getCountSaleProduct();
	public Integer getCountSaleProductByCategory(int id);
	public List<ProductVO> getListPromotion();
	public DetailProduct getDetailProductById(Integer id);
	
	//image
	public List<Integer> getImagesByProduct(int id);
	
	public List<Price> getPriceByProduct(int id);
	public int getMainImageOfProduct(int id);
	
	//reservation
	public int setReservation(Reservation reservation);
}
