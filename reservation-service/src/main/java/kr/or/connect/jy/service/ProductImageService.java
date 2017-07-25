package kr.or.connect.jy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.ProductImageDao;
import kr.or.connect.jy.dto.ProductImage;

@Service
public class ProductImageService {
	@Autowired
	private ProductImageDao productImageDao;

	public int insert(ProductImage productImage) {
		return productImageDao.insert(productImage);
	}

}
