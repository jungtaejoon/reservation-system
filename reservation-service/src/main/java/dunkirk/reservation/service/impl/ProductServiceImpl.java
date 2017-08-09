package dunkirk.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.ProductDao;
import dunkirk.reservation.service.ProductService;
import durkirk.reservation.dto.ProductForMainDto;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<ProductForMainDto> getList(int categoryId, int page) {
		return productDao.getList(categoryId, page);
	}

}
