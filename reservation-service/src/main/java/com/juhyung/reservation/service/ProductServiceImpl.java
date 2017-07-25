package com.juhyung.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.Price;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.domain.Reservation;
import com.juhyung.reservation.dto.DetailProduct;
import com.juhyung.reservation.dto.ProductDTO;
import com.juhyung.reservation.persistence.ImageDAO;
import com.juhyung.reservation.persistence.ProductDAO;
import com.juhyung.reservation.persistence.ReservationDAO;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductDAO productDao;
	private ImageDAO imageDao;
	private ReservationDAO reservationDao;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDao, ImageDAO imageDao, ReservationDAO reservationDao) {
		this.productDao = productDao;
		this.imageDao = imageDao;
		this.reservationDao = reservationDao; 
	}
	
	@Override
	public List<ProductDTO> getListPage(PageCriteria pageCriteria) {
		return productDao.selectListPage(pageCriteria);
	}

	@Override
	public List<ProductDTO> getListByCategory(Integer categoryId, PageCriteria pageCriteria) {
		return productDao.selectListByCategory(categoryId, pageCriteria);
	}


	@Override
	public Integer getCountSaleProduct() {
		return productDao.countOfSaleProduct();
	}
	
	@Override
	public Integer getCountSaleProductByCategory(int id) {
		return productDao.countOfSaleProductByCategoryId(id);
	}

	@Override
	public List<ProductVO> getListPromotion() {
		return productDao.selectListPromotion();
	}

	@Override
	public DetailProduct getDetailProductById(Integer id) {
		return productDao.selectDetailProductById(id);
	}

	//image
	@Override
	public List<Integer> getImagesByProduct(int id) {
		return imageDao.selectImagesByProductId(id);
	}

	@Override
	public List<Price> getPriceByProduct(int id) {
		return productDao.selectPriceInfoByProduct(id);
	}

	@Override
	public int getMainImageOfProduct(int id) {
		return imageDao.selectMainImageOfProduct(id);
	}
	
	//reservation
	@Override
	public int setReservation(Reservation reservation) {
		return reservationDao.insertReservation(reservation);
	}
}
