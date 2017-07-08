package connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import connect.reservation.dao.CategoryDao;
import connect.reservation.domain.Category;
import connect.reservation.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public Category get(int id) {
		return categoryDao.selectById(id);
	}
	
	@Override
	@Transactional(readOnly = false)
	public Category addCategory(String newCategory) {
		Category category = new Category(newCategory);

		int insert = categoryDao.insert(category);
		category.setId(insert);
		return category;
	}

	@Override
	public int deleteById(int id) {
		return categoryDao.deleteById(id);
	}
	
	@Override
	public int deleteAll() {
		return categoryDao.deleteAll();
	}
	
	@Override
	public int updateById(HttpServletRequest request) {
		String updateCate = request.getParameter("newCategory");
		int updateId = Integer.parseInt(request.getParameter("cateId"));
		Category category = new Category(updateCate);
		category.setId(updateId);
		
		return categoryDao.updateById(category);
	}
	
	@Override
	public ModelAndView getAll() {
		ModelAndView model = new ModelAndView();
		
		List<Category> list = new ArrayList<Category>();
		list = categoryDao.selectAll();
		
		model.addObject("category", list);
		model.setViewName("category");
		
		return model;
	}
	
	@Override
	public int getAllCount() {
		return categoryDao.selectAllCount();
	}
}
