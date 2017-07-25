package com.juhyung.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.CategoryVO;
import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.dto.ProductDTO;

@Service
public interface CategoryService {

	public List<CategoryVO> getCategoryListAll();
	public int create(CategoryVO category);
	public int removeById(Integer id);
	public int modifyById(CategoryVO category);
	
	//product
	public List<ProductDTO> getListProductByCategory(int id, PageCriteria pageCriteria);
	public int getCountProductByCategory(int id);
}
