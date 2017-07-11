package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.domain.Category;

public interface CategoryService {

	public List<Category> getAllCategory();

	public Category addCategory(Category category);

	public int delete(Long id);

	public int update(Category category);
}
