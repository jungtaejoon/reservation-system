package kgw.reservation.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kgw.reservation.dao.CategoryDao;
import kgw.reservation.domain.Category;

@Service
public class CategoryService {
	private CategoryDao categoryDao;
	
	@Autowired
	public CategoryService(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
    @Transactional(readOnly = false)
	public Category create (Category category) {
    		category.setId(categoryDao.insert(category));
    		return category;
	}
   
    public boolean delete(Long id) {
        return categoryDao.delete(id) == 1 ? true : false;
    }
    
    public boolean update(Category category) {
        return categoryDao.update(category) == 1 ? true : false;
    }
    
    public Category findById(Long id) {
    		return categoryDao.selectById(id);
    }
    
    public Collection<Category> find() {
    		return categoryDao.selectAll();
    }
}
