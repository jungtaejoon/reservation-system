package dunkirk.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dunkirk.reservation.dao.CategoryDao;
import dunkirk.reservation.domain.Category;
import dunkirk.reservation.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	private CategoryDao categoryDao;
	
	
	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public List<Category> getList() {
		return categoryDao.getList();
	}

}
