package kr.or.connect.jgb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.jgb.dao.CategoryDao;
import kr.or.connect.jgb.domain.Category;
import kr.or.connect.jgb.service.CategoryService;


// 서비스에서 예외 사항 처리 해주는 것이 중요 ( null , attribute)
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
    CategoryDao categoryDao;
	
    @Override
    @Transactional(readOnly = true)
    public Category get(int id) {
        return categoryDao.selectById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Category addCategory(Category category){
    	int insert = categoryDao.insert(category);
        category.setId(insert);
        return category;
    }

    @Override
    public int delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

	@Override
	@Transactional(readOnly=true)
	public List<Category> getAll() {
		return categoryDao.selectAll();
	}

}
