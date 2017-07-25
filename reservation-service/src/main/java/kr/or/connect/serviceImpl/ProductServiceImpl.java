package kr.or.connect.serviceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import kr.or.connect.dao.*;
import kr.or.connect.domain.*;
import kr.or.connect.dto.*;
import kr.or.connect.service.*;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<ProductDisplayDto> getSales(Integer start) {
		return productDao.getSales(start);
	}
	
	@Override
	public Integer countSales() {
		return productDao.countSales();
	}

	@Override
	public List<ProductDisplayDto> getSalesByCategory(Long categoryId, Integer start) {
		return productDao.getSalesByCategory(categoryId, start);
	}

	@Override
	public int countSalesByCategory(Long categoryId) {
		return productDao.countSalesByCategory(categoryId);
	}

	@Override
	public ProductDetailDto getDetail(Long id) {
		return productDao.getDetail(id);
	}
	
	@Override
	public List<ProductPriceDto> getPrice(Long id) {
		return productDao.getPrice(id);
	}

	@Override
	public List<ProductImage> getImages(Long id) {
		return productDao.getImages(id);
	}

	@Override
	public ProductImage insertImage(ProductImage productImage) {
		return productDao.insertImage(productImage);
	}

}
