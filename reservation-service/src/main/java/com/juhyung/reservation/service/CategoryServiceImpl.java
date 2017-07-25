package com.juhyung.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.CategoryVO;
import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.dto.ProductDTO;
import com.juhyung.reservation.persistence.CategoryDAO;
import com.juhyung.reservation.persistence.ProductDAO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryDAO categoryDao;
	private ProductDAO productDao;
	
	@Autowired
	public CategoryServiceImpl(CategoryDAO categoryDao, ProductDAO productDao) {
		this.categoryDao = categoryDao;
		this.productDao = productDao;
	}

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
	public int modifyById(CategoryVO category) {
		return categoryDao.updateById(category);
	}

	
	@Override
	public List<ProductDTO> getListProductByCategory(int id, PageCriteria pageCriteria) {
		return productDao.selectListByCategory(id, pageCriteria);
	}

	@Override
	public int getCountProductByCategory(int id) {
		return productDao.countOfSaleProductByCategoryId(id);
	}


}
