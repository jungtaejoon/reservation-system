import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.transaction.annotation.*;

import kr.or.connect.config.*;
import kr.or.connect.dao.*;
import kr.or.connect.domain.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryTest {

	@Autowired
	CategoryDao categoryDao;

	@Test
	public void shouldInsertAndSelect() {
		Category category = new Category("카테고리");
		Long categoryPk = categoryDao.insert(category).getId();

		Category result = categoryDao.selectById(categoryPk);

		assertEquals(result.getName(), "카테고리");

	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	public void shouldDelete() {
		Category category = new Category("카테고리");
		Long categoryPk = categoryDao.insert(category).getId();
		categoryDao.delete(categoryPk);
		
		categoryDao.selectById(categoryPk);
		
	}

}
