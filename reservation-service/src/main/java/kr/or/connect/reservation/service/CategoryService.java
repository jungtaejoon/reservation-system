package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDAO;
import kr.or.connect.reservation.domain.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO dao;

	@Transactional(readOnly = true)
	public List<Category> selectCategoriesAll() {
		return dao.selectCategoriesAll();
	}

	@Transactional(readOnly = false)
	public Long insertCategory(Category category) {
		return dao.insertCategory(category);
	}

	@Transactional(readOnly = false)
	public void deleteCategory(int id) {
		dao.deleteCategory(id);
	}

	@Transactional(readOnly = false)
	public void updateCategory(int id, Category category) {
		category.setId(id);
		
		dao.updateCategory(category);
	}

}
