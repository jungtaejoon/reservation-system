package connect.reservation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import connect.reservation.domain.Category;

public interface CategoryService {
	public Category get(int id);
    public Category addCategory(String categoryName);
    public int deleteById(int id);
    public int deleteAll();
    public int updateById(String newCategory, int id);
    public List<Category> getAll();
    public int getAllCount();
}
