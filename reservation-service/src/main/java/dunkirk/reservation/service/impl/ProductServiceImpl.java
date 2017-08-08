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
		List<Product> list = new ArrayList<Product>();
		list = productDao.getList1();
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i).toString());
		
		return list;
	}

	
	
	

	
}
