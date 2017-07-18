package kr.or.connect.jy.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.CategoryDao;
import kr.or.connect.jy.dto.Category;
import kr.or.connect.jy.dto.Product;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	public CategoryService(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	public Collection<Category> selectAll(){
		return categoryDao.selectAll();
	}
	
	public Integer insert(Category category) {
		return categoryDao.insert(category);
	}
	
	public Integer delete(Integer id) {
		return categoryDao.delete(id);
	}

	public Integer update(Category category) {
		return categoryDao.update(category);
	}
}
