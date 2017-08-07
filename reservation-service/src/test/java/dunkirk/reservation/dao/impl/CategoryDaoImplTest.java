package dunkirk.reservation.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dunkirk.reservation.config.RootApplicationContext;
import dunkirk.reservation.dao.CategoryDao;
import dunkirk.reservation.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContext.class)
@Transactional
public class CategoryDaoImplTest {


	@Autowired
	private CategoryDao categoryDao;

	// Q. 테스트유닛에서 생성자 주입이 안되는이유?
//	@Autowired
//	public CategoryDaoImplTest(CategoryDao categoryDao) {
//		this.categoryDao = categoryDao;
//	}

	@Test
	public void testGetList() {
		List<Category> list = categoryDao.getList();
		Assert.assertNotNull(list);
		Assert.assertTrue("전시".equals(list.get(0).getName()));
	}
	
}
