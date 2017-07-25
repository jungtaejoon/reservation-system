package kr.or.connect.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.DisplayInfoDao;
import kr.or.connect.jy.dao.ProductDetailDao;
import kr.or.connect.jy.dao.ProductImageDao;
import kr.or.connect.jy.dto.DisplayInfo;
import kr.or.connect.jy.dto.ProductDetail;
import kr.or.connect.jy.dto.ProductImageDTO;

@Service
public class ProductDetailService {
	@Autowired
	ProductImageDao productImageDao;

	@Autowired
	DisplayInfoDao displayInfoDao;

	@Autowired
	ProductDetailDao productDetailDao;

	public List<ProductImageDTO> selectByProductIdForDetail(Integer productId) {
		List<ProductImageDTO> productImageDTOs = productImageDao.selectByProductIdForDetail(productId);
		List<DisplayInfo> displayInfos = displayInfoDao.selectByProductId(productId);
		ProductImageDTO pi;
		if (displayInfos != null && productImageDTOs != null) {
			for (int i = 0; i < productImageDTOs.size(); i++) {
				pi = productImageDTOs.get(i);
				pi.setDisplayInfo(displayInfos.get(i));
				productImageDTOs.set(i, pi);
			}
		}
		return productImageDTOs;
	}

}
