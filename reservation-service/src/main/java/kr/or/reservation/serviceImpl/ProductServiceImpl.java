package kr.or.reservation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.reservation.dao.ProductDao;
import kr.or.reservation.domain.Product;
import kr.or.reservation.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	// 수정 할것.  분리 안하고 메서드가 한가지 기능만 하도록.  
	
	// 얘는 2가지 기능을 하고있음 
	@Override
	@Transactional(readOnly = true)
	public List<Product> getProductByCategory(int start, int categoryId) {
		// TODO Auto-generated method stub
		if(categoryId ==0) {
			return productDao.selectAll(start);
		}
		return productDao.selectByCategory(start,categoryId);
	}

	@Override
	@Transactional(readOnly = true)
	public int countProduct(int categoryId) {
		if(categoryId == 0) {
			return productDao.countCategoryAll();
		}else {
			return productDao.countCategory(categoryId);
		}
	}

}
