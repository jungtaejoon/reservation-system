package kr.or.connect.service;

import java.util.*;

import kr.or.connect.dto.*;

public interface ProductService {
	List<ProductDisplayDto> getSales(Integer firstIndex);
	Integer countSales();
	List<ProductDisplayDto> getSalesByCategory(Long categoryId, Integer firstIndex);
	int countSalesByCategory(Long categoryId);
}
