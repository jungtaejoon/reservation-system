package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.domain.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	

    @Transactional(readOnly = true)
    public Category get(Long id) {
        return categoryDao.selectById(id);
    }
	

    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return categoryDao.selectAll();
    }


    @Transactional(readOnly = false)
    public Category addCategory(Category category){
        Long insert = categoryDao.insert(category);
        category.setId(insert);
        return category;
    }


    public int delete(Long id) {
        return categoryDao.delete(id);
    }


    public int update(Category category) {
        return categoryDao.update(category);
    }
}
