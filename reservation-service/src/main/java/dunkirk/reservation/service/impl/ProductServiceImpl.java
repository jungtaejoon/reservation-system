package dunkirk.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.*;
import dunkirk.reservation.service.*;
import durkirk.reservation.dto.*;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<ProductForMainDto> getList(int categoryId, int start) {
		return productDao.getList(categoryId, start);
	}

	
	
	

	
}
