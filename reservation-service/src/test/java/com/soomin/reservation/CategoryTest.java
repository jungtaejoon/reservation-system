package com.soomin.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.soomin.reservation.config.RootApplicationContextConfig;
import com.soomin.reservation.dao.CategoryDao;
import com.soomin.reservation.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryTest {
	@Autowired
	CategoryDao categoryDao;

	@Test
	public void shouldInsertAndSelect() {
		Category category = new Category("연극");
		long categoryPk = categoryDao.insert(category);
		Category result = categoryDao.selectById(categoryPk);
		
		assertThat(result.getName(), is("연극"));
	}
	
	@Test
	public void shouldDelete() {
		Category category = new Category("연극");
		long categoryPk = categoryDao.insert(category);
		
		int deleteCount = categoryDao.delete(categoryPk);
		
		assertThat(deleteCount, is(1));
	}
	
	@Test
	public void shouldInsertAndUpdate() {
		Category category = new Category("연극");
		long categoryPk = categoryDao.insert(category);
		category.setId(categoryPk);
		category.setName("영화");
		int result = categoryDao.update(category);
		
		assertThat(result, is(1));
	}
}
