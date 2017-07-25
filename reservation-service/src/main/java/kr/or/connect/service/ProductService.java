package kr.or.connect.service;

import java.util.*;

import kr.or.connect.domain.*;
import kr.or.connect.dto.*;

public interface ProductService {
	List<ProductDisplayDto> getSales(Integer start);
	Integer countSales();
	List<ProductDisplayDto> getSalesByCategory(Long categoryId, Integer start);
	int countSalesByCategory(Long categoryId);
	ProductDetailDto getDetail(Long id);
	List<ProductImage> getImages(Long id);
	ProductImage insertImage(ProductImage productImage);
	List<ProductPriceDto> getPrice(Long id);
}
