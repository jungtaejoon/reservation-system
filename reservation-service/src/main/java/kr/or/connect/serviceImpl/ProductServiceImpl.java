package kr.or.connect.serviceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import kr.or.connect.dao.*;
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
	public List<ProductDisplayDto> getSales(Integer firstIndex) {
		return productDao.getSales(firstIndex);
	}
	
	@Override
	public Integer countSales() {
		return productDao.countSales();
	}

	@Override
	public List<ProductDisplayDto> getSalesByCategory(Long categoryId, Integer firstIndex) {
		return productDao.getSalesByCategory(categoryId, firstIndex);
	}

	@Override
	public int countSalesByCategory(Long categoryId) {
		return productDao.countSalesByCategory(categoryId);
	}

}
