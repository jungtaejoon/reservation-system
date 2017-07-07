package kr.or.reservation.service;

import java.util.List;

import kr.or.reservation.domain.Category;

public interface CategoryService {
	
	public Long insert(Category category);
	public int update(Category category);
	public int deleteById(Long id);
	public Category selectById(Long id);
	public List<Category> selectforList();
	
}
