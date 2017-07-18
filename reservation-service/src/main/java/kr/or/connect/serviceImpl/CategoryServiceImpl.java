package kr.or.connect.serviceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import kr.or.connect.dao.*;
import kr.or.connect.domain.*;
import kr.or.connect.service.*;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public Category selectById(Long id) {
		return categoryDao.selectById(id);
	}

	@Override
	public Category insert(Category category) {
		return categoryDao.insert(category);
	}

	@Override
	public int delete(Long id) {
		return categoryDao.delete(id);
	}

}
