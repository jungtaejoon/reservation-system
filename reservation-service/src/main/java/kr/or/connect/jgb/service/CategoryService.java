package kr.or.connect.jgb.service;

import java.util.List;

import kr.or.connect.jgb.domain.Category;

public interface CategoryService {
	public Category get(int id);
	public List<Category> getAll();
    public Category addCategory(Category category);
    public int delete(int id);
    public int update(Category category);
}
