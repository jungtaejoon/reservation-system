package won.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.dao.DisplayInfoDao;
import won.reservation.dao.FileDao;
import won.reservation.dao.ProductDao;
import won.reservation.domain.Product;
import won.reservation.dto.ProductDetailInfo;
import won.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDao dao;	
	private FileDao fileDao;	
	private DisplayInfoDao displayInfoDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao dao, FileDao fileDao, DisplayInfoDao displayInfoDao) {
		this.dao = dao;
		this.fileDao = fileDao;
		this.displayInfoDao = displayInfoDao;
	}
	
	@Override
	public List<Product> get() {
		return dao.select();
	}
	
	@Override
	public ProductDetailInfo getProduct(Integer productId) {
		if(productId < 1 || productId == null) {
			return null;
		}
		ProductDetailInfo product = dao.select(productId);
		product.setProductImg(fileDao.selectByProductId(productId));
		product.setDisplayInfo(displayInfoDao.select(productId));
		return product;
	}

	@Override
	public int add(Product product) {
		return dao.insert(product);
	}

	@Override
	public int modify(Product product) {
		return dao.update(product);
	}

	@Override
	@Transactional
	public int remove(int id) {
		if(id < 1) {
			return 0;
		}
		return dao.delete(id);
	}

	@Override
	public int getCount(Integer categoryId) {
		if(categoryId != null) {
			return dao.getCount(categoryId);
		}
		return dao.getCount();
	}
	
	@Override
	public Map<String, Object> getProductInfo(Integer start) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", dao.selectInfo(start));
		map.put("cnt", dao.getCount());
		return map;
	}
	
	@Override
	public Map<String, Object> getProductInfoCategory(Integer categoryId, Integer start){
		Map<String, Object> map = new HashMap<>();
		map.put("list", dao.selectInfo(categoryId, start));
		map.put("cnt", dao.getCount(categoryId));
		return map;
	}

}
