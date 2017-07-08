package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.domain.Category;

public interface CategoryService {
	public int deleteCategory(Long id);
	public Category addCategory(Category category);
	public List<Category> viewCategory();
	public int updateCategory(Category category);
}
