package com.juhyung.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.CategoryVO;
import com.juhyung.reservation.persistence.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDAO categoryDao;

	@Override
	public List<CategoryVO> getCategoryListAll() {
		return categoryDao.selectListAll();
	}

	@Override
	public int create(CategoryVO category) {
		return categoryDao.insert(category);
	}

	@Override
	public int removeById(Integer id) {
		return categoryDao.deleteById(id);
	}

	@Override
	public int modify(CategoryVO category) {
		return categoryDao.updateById(category);
	}


}
