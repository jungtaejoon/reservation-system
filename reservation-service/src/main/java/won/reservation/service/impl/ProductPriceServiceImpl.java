package won.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.ProductPriceDao;
import won.reservation.domain.ProductPrice;
import won.reservation.service.ProductPriceService;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	private ProductPriceDao dao;
	
	@Autowired
	public ProductPriceServiceImpl(ProductPriceDao dao) {
		this.dao = dao;
	}
		
	@Override
	public List<ProductPrice> get(Integer productId) {
		return dao.select(productId);
	}
	
}
