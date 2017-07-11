package kr.or.connect.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<Category> getAllCategory() {
		return dao.selectAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Category addCategory(Category category) {
		Long insert = dao.insert(category);
		category.setId(insert);
		return category;
	}

	@Override
	public int delete(Long id) {
		return dao.delete(id);
	}

	@Override
	public int update(Category category) {
		return dao.update(category);
	}
}
