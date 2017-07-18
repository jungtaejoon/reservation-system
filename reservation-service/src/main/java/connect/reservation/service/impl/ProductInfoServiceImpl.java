package connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import connect.reservation.dao.ProductInfoDao;
import connect.reservation.dto.ProductInfo;
import connect.reservation.service.ProductInfoService;

@Service
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	ProductInfoDao productInfoDao;
	
	
	@Override
	public int getProductCount() {
		return productInfoDao.getProductCount();
	}
	
	@Override
	public int getCategoryProductCount(int categoryId) {
		return productInfoDao.getCategoryProductCount(categoryId);
	}
	
	@Override
	public Map<String, Object> getMainInfo(int start) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("productList", productInfoDao.getMainInfo(start));
		map.put("productCount", productInfoDao.getProductCount());
	
		return map;
	}
	
	@Override
	public Map<String, Object> getCategoryInfo(int categoryId, int start) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("productList", productInfoDao.getCategoryInfo(categoryId, start));
		map.put("productCount", productInfoDao.getCategoryProductCount(categoryId));
	
		return map;
	}
	
}
