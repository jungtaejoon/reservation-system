package categoryDaoTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import connect.reservation.config.RootApplicationContextConfig;
import connect.reservation.dao.CategoryDao;
import connect.reservation.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional  // Transactional이 있을 때와 없을 때 각각 실행해보고 그 때마다 msyql에서 결과를 select해본다.
public class CategoryDaoTest {
	@Autowired
	CategoryDao categoryDao;
	
	@Test
    public void shouldInsertAndSelect() {
        Category category = new Category("category test");
        int capegoryPk = categoryDao.insert(category);

        Category result = categoryDao.selectById(capegoryPk);

        // http://sejong-wiki.appspot.com/assertThat
        assertThat(result.getName(), is("category test")); // result의 name은 강경미 이다(is). 읽혀지는 코드로 테스트 코드가 작성된다.

    }
	
	@Test
	public void shouldUpdateById() {
		Category category = new Category("category test");
		int categoryPk = categoryDao.insert(category);
		
		Category newCategory = new Category("update");
		newCategory.setId(categoryPk);
		
		int affected = categoryDao.updateById(newCategory);
		assertThat(affected, is(1));
		
		category = categoryDao.selectById(categoryPk);
		assertThat(category.getName(), is("update"));
	}
	
	@Test
	public void shouldDeleteById() {
		Category category = new Category("category test");
		int categoryPk = categoryDao.insert(category);
		
		int beforeDelete = categoryDao.selectAllCount();
		
		int affected = categoryDao.deleteById(categoryPk);
		assertThat(affected, is(1));
		
		int afterDelete = categoryDao.selectAllCount();
		assertThat(beforeDelete - afterDelete, is(1));
	}
	
	@Test
	public void shouldDeleteAll() {
		Category category = new Category("category test");
		categoryDao.insert(category);
		
		Category category2 = new Category("category test");
		categoryDao.insert(category2);
		
		Category category3 = new Category("category test");
		categoryDao.insert(category3);
		
		int beforeDelete = categoryDao.selectAllCount();
		
		int affected = categoryDao.deleteAll();
		assertThat(affected, is(beforeDelete));
		
		int afterDelete = categoryDao.selectAllCount();
		assertThat(afterDelete, is(0));
	}
	
	@Test
	public void shouldSelectAll() {
		Category category = new Category("category test");
		categoryDao.insert(category);
		
		List<Category> list = new ArrayList<Category>();
		list = categoryDao.selectAll();
		
		int countCategory = categoryDao.selectAllCount();
		assertThat(countCategory, is(list.size()));
	}
}
