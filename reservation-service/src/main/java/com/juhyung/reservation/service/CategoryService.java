package com.juhyung.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.CategoryVO;

@Service
public interface CategoryService {

	public List<CategoryVO> getCategoryListAll();
	public int create(CategoryVO category);
	public int removeById(Integer id);
	public int modifyById(CategoryVO category);
}
