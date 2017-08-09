package dunkirk.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.CategoryDao;
import dunkirk.reservation.domain.Category;
import dunkirk.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryDao categoryDao;
	
	
	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public List<Category> getList() {
		List<Category> list = categoryDao.getList();
		for(Category c : list) {
			System.out.println(c.getProductCount());
		}
		return categoryDao.getList();
	}

}
