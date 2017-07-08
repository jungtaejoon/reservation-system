package hwj.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hwj.reservation.dao.CategoryDao;
import hwj.reservation.domain.Category;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao dao;
	
	public CategoryServiceImpl(CategoryDao dao){
		super();
		this.dao = dao;
	}
	
	@Override
	public List<Category> getAllList() {
		return this.dao.selectAllCategory();
	}

	@Override
	public Category getByName(String name) {
		return this.dao.selectByName(name);
	}

	@Override
	public Category getById(Integer id) {
		return this.dao.selectById(id);
	}

	@Override
	public boolean update(Category category) {
		int affected = dao.update(category);
		return affected !=0;
	}

	@Override
	public boolean deleteById(Integer id) {
		int affected = dao.deleteById(id);
		
		return affected ==1;
	}

	@Override
	public boolean deleteByName(String name) {
		int affected = dao.deleteByName(name);
		return affected ==1;
	}

	@Override
	@Transactional(readOnly=false)
	public Category create(Category category) {
		Integer id = dao.insert(category);
		category.setId(id);
		return category;
	}

}
