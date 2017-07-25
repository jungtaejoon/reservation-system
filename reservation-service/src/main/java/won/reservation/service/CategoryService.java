package won.reservation.service;

import java.util.List;

import won.reservation.domain.Category;

public interface CategoryService {
	public List<Category> get();
	public Category get(int id);
	public int add(String name);
	public int modify(Category category);
	public int remove(int id);
}
