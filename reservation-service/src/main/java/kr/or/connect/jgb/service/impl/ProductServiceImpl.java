package kr.or.connect.jgb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jgb.dao.ProductDao;
import kr.or.connect.jgb.domain.Product;
import kr.or.connect.jgb.domain.vo.ProductMainVO;
import kr.or.connect.jgb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    ProductDao productDao;

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductMainVO> getAllByCategory(int categoryId,int page) {
		// TODO Auto-generated method stub
		return productDao.selectAllByCategory(categoryId,page);
	}

	@Override
	public List<ProductMainVO> getAll(int page) {
		// TODO Auto-generated method stub
		return productDao.selectAll(page);
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}
	




}
