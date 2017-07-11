package kr.or.reservation.jdbc;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.reservation.config.RootApplicationContextConfig;
import kr.or.reservation.domain.Category;
import kr.or.reservation.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryTest {

	@Autowired
	CategoryService service;
	
	@Test
	public void insertAndSelect() {
		// input
		Category inputCategory = new Category("도서");
		Long id = service.insert(inputCategory);
		
		//when 
		Category getCategory = service.selectById(id);
		
		//than
		Assert.assertThat(id, is(getCategory.getId()));
		Assert.assertThat(inputCategory.getName(), is(getCategory.getName()));
	}
	
	
	@Test
	public void insertAndUpdate() {
		// input
		Category inputCategory = new Category("도서");
		Long id = service.insert(inputCategory);
		
		//when 
		Category updateCategory = new Category(id,"여행");
		int result = service.update(updateCategory);
		Category getCategory = service.selectById(id);
		
		//than
		Assert.assertThat(getCategory.getName(), is("여행"));
		Assert.assertThat(result, is(1));
	}
	
	@Test
	public void insertAndDelete() {
		// input
		Category inputCategory = new Category("도서");
		Long id = service.insert(inputCategory);
		
		//when 
		int result= service.deleteById(id);
		
		//than
		Assert.assertThat(result, is(1));
	}
	
	
	


}
