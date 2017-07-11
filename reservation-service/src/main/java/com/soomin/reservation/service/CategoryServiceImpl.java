package com.soomin.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soomin.reservation.dao.CategoryDao;
import com.soomin.reservation.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;

	@Override
	public int deleteCategory(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.delete(id);
	}

	@Override
	@Transactional(readOnly=false)
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		Long insert = categoryDao.insert(category);
		category.setId(insert);
		return category;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.update(category);
	}

	@Override
	public List<Category> viewCategory() {
		// TODO Auto-generated method stub
		return categoryDao.selectAll();
	}

}
