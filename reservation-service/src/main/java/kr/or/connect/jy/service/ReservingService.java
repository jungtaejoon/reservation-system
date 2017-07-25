package kr.or.connect.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.ProductDTOForReserveDao;
import kr.or.connect.jy.dao.ProductPriceDao;
import kr.or.connect.jy.dto.ProductDTOForReserve;
import kr.or.connect.jy.dto.ProductPrice;

@Service
public class ReservingService {
	@Autowired
	ProductPriceDao productPriceDao;
	
	@Autowired
	ProductDTOForReserveDao productForReserveDao;
	
	public ProductDTOForReserve selectDTOForReserveByProductId(int productId) {
		List<ProductPrice> productPrices = productPriceDao.selectByProductId(productId);
		ProductDTOForReserve productForReserve = productForReserveDao.selectByProductId(productId);
		productForReserve.setProductPrices(productPrices);
		return productForReserve;
	}
}
