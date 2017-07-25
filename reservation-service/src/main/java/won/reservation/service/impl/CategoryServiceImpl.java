package won.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.dao.CategoryDao;
import won.reservation.domain.Category;
import won.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao dao;
	
	@Autowired
	public CategoryServiceImpl(CategoryDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Category> get() {
		return dao.select();
	}
	
	@Override
	@Transactional(readOnly = true)	
	public Category get(int id) {
		if(id < 0) {
			return null;
		}
		return dao.selectById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int add(String name) {
		return dao.insert(name);
	}

	@Override
	public int modify(Category category) {
		return dao.update(category);
	}

	@Override
	public int remove(int id) {
		if(id < 0) {
			return 0;
		}
		return dao.delete(id);
	}
	
}
