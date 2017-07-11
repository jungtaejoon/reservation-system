package kr.or.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.reservation.dao.CategoryDao;
import kr.or.reservation.domain.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    CategoryDao categorydao;
	
	@Override
	public Long insert(Category category) {
		// TODO Auto-generated method stub
		return categorydao.insert(category);
	}

	@Override
	public int update(Category category) {
		return categorydao.updateById(category);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return categorydao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Category selectById(Long id) {
		return categorydao.selectById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> selectforList() {
		// TODO Auto-generated method stub
		return categorydao.selectforList();
	}

}
