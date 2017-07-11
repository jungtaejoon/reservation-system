package kr.or.connect.reservation.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.config.RootApplicationContextConfig;
import kr.or.connect.reservation.domain.Category;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryDaoTest {

	@Autowired
	CategoryDao dao;

	@Test
	public void shouldInsertAndSelectTest() {
		Category cate = new Category();
		cate.setName("test");
		
		long returnKey = dao.insert(cate);
		Category result = dao.selectById(returnKey);

		assertThat(result.getName(), is("test"));
	}

	@Test
	public void shouldDeleteByIdTest() {
		Category cate = new Category();
		cate.setName("test");
		
		long returnKey = dao.insert(cate);
		int deleteCount = dao.delete(returnKey);
		
		assertThat(deleteCount, is(1));
	}
	
	@Test
    public void shouldUpdateByIdTest() {
		Category cate = new Category();
		cate.setName("test");
		
		long returnKey = dao.insert(cate);

        // when
		cate.setId(returnKey);
        cate.setName("yaha");
        int updateCount = dao.update(cate);

        // Then
        Category result = dao.selectById(returnKey);
        assertThat(updateCount, is(1));
        assertThat(result.getName(), is("yaha"));
    }

}
