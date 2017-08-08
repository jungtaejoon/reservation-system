package dunkirk.reservation.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import dunkirk.reservation.dao.*;
import dunkirk.reservation.domain.*;
import dunkirk.reservation.service.*;

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
