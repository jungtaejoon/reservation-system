package com.soomin.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.reservation.dao.CommentDao;
import com.soomin.reservation.dao.DisplayInfoDao;
import com.soomin.reservation.dao.ProductDao;
import com.soomin.reservation.dao.ProductDetailDao;
import com.soomin.reservation.dao.ProductImageDao;
import com.soomin.reservation.dto.ProductInfo;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{
	@Autowired
	ProductDao productDao;
	@Autowired
	ProductDetailDao productDetailDao;
	@Autowired
	ProductImageDao productImageDao;
	@Autowired
	DisplayInfoDao displayInfoDao;
	@Autowired
	CommentDao commentDao;
	
	@Override
	public ProductInfo getProductInfo(long id) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProduct(productDao.SelectProductById(id).get(0));
		productInfo.setDetail(productDetailDao.SelectProductDetailById(id).get(0));
		productInfo.setDisplay_info(displayInfoDao.SelectInfoById(id).get(0));
		productInfo.setImages(productImageDao.selectRepresentByProductId(id));
		productInfo.setComment_score(commentDao.CountByProductId(id));
		productInfo.setCount_images(productImageDao.countByProductId(id));
		
		return productInfo;
	}
}
