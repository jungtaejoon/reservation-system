package com.juhyung.reservation.persistence;
import java.util.List;

import com.juhyung.reservation.domain.CategoryVO;

public interface CategoryDAO {
	
	public List<CategoryVO> selectListAll();
	public int insert(CategoryVO category);
	public int deleteById(Integer id);
	public CategoryVO selectById(Integer id);
	public int updateById(CategoryVO category);
}	