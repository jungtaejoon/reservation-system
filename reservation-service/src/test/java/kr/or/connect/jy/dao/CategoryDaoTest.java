package kr.or.connect.jy.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.jy.config.RootApplicationContextConfig;
import kr.or.connect.jy.dto.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryDaoTest {
	@Autowired
	CategoryDao categoryDao;
	
	@Test
	public void shouldInsertAndSelect() {
		Category category = new Category("스포츠");
		Integer categoryPk = categoryDao.insert(category);
		
		Category result = categoryDao.selectById(categoryPk);
		
		assertThat(result.getName(), is("스포츠"));
	}
	
	@Test
	public void shouldSelectAll() {
		LinkedList<String> names = new LinkedList<>();
		names.add("스포츠");
		names.add("영화");
		
		Category category = new Category("스포츠");
		categoryDao.insert(category);
		category = new Category("영화");
		categoryDao.insert(category);
		
		Collection<Category> results = categoryDao.selectAll();
		results.forEach(
			item -> {
				assertThat(item.getName(), is(names.pop()));
			}
		);
	}
	
    @Test
    public void shouldUpdate() {
    	Category category = new Category("대박");
    	Integer categoryPk = categoryDao.insert(category);
    	
    	category.setId(categoryPk);
    	category.setName("사건");
    	
    	int updateCount = categoryDao.update(category);
    	
    	Category result = categoryDao.selectById(categoryPk);
    	assertThat(result.getName(), is("사건"));
    	
    }

    @Test
    public void shouldDelete() {
    	Category category = new Category("삭제");
    	Integer categoryPk = categoryDao.insert(category);
    	
    	int deleteCount = categoryDao.delete(categoryPk);
    	
    	assertThat(deleteCount, is(1));
    }
}
