package com.juhyung.resrvation.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.juhyung.reservation.config.RootApplicationContextConfig;
import com.juhyung.reservation.domain.CategoryVO;
import com.juhyung.reservation.persistence.CategoryDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class TestCategoryDAO {

	@Autowired
	private CategoryDAO categoryDao;
	private CategoryVO category;
	
	@Before
	public void setUp(){
		category = new CategoryVO();
	}
	
	@Test
	@Transactional
	public void testInsert(){
		category.setName("영화");
		int categoryId = categoryDao.insert(category);
		CategoryVO actual = categoryDao.selectById(categoryId);
		assertThat(categoryId, is(actual.getId()));
	}
	
	@Test
	public void testDelete(){
		category.setName("영화");
		int categoryId = categoryDao.insert(category);
        int deleteCount = categoryDao.deleteById(categoryId);
        assertThat(deleteCount, is(1));
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testSelectListAll(){
		int actualList, testList;
		actualList = categoryDao.selectListAll().size();
		
		category.setName("영화");
		categoryDao.insert(category);
		
		testList = categoryDao.selectListAll().size();
        assertThat(testList - actualList, is(1));
	}
}
