package com.soomin.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.soomin.reservation.config.RootApplicationContextConfig;
import com.soomin.reservation.domain.Category;
import com.soomin.reservation.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryServiceTest {
	@Autowired
	CategoryService categoryService;
	
	@Test
	public void shouldAddAndViewDelete() {
		Category category = new Category("연극");
		Category result = categoryService.addCategory(category);
		category = new Category("영화");
		result = categoryService.addCategory(category);
		
		List<Category> categories = categoryService.viewCategory();
		
		categories.forEach(item -> {
			System.out.println(item);
		});
		
		int deleteNum = categoryService.deleteCategory(result.getId());
		assertThat(deleteNum, is(1));
		
		categories = categoryService.viewCategory();
		
		categories.forEach(item -> {
			System.out.println(item);
		});
	}

}
