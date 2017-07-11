package hwj.reservation.service;

import java.util.List;

import hwj.reservation.domain.Category;

public interface CategoryService {
	public Category create(Category category);
	public List<Category> getAllList();
	public Category getByName(String name);
	public Category getById(Integer id);
	public boolean update(Category category);
	public boolean deleteById(Integer id);
	public boolean deleteByName(String name);
	
}
