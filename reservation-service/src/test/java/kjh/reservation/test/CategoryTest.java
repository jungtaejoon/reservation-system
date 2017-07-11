package kjh.reservation.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kjh.reservation.config.RootApplicationContextConfig;
import kjh.reservation.dao.CategoryDao;
import kjh.reservation.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryTest {

	@Autowired
	CategoryDao categoryDao;

	@Test
	public void shouldInsertAndSelect() {
		Category category = new Category();
		category.setName("kang");
		Integer id = categoryDao.insert(category);

		Category result = categoryDao.selectById(id);
		assertThat(result.getName(), is("kang"));
	}

	@Test
	public void shouldUpdate() {
		Category category = new Category();
		category.setName("kang");
		Integer id = categoryDao.insert(category);

		Category category1 = new Category();
		category1.setName("kim");
		category1.setId(id);
		categoryDao.update(category1);

		Category result = categoryDao.selectById(id);
		assertThat(result.getName(), is("kim"));
	}

	@Test
	public void shouldDelete() {
		Category category = new Category();
		category.setName("kang");
		Integer id = categoryDao.insert(category);

		int affected = categoryDao.delete(id);

		assertThat(affected, is(1));

	}

}
