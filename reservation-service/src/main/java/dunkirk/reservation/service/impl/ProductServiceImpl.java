package dunkirk.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.ProductDao;
import dunkirk.reservation.domain.Product;
import dunkirk.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getList(int categoryId, int start) {
		return productDao.getList(categoryId, start);
	}

	
	
	

	
}
