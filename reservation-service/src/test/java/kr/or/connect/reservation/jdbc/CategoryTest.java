package kr.or.connect.reservation.jdbc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.config.RootApplicationContextConfig;
import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.domain.Category;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryTest {

	@Autowired
    CategoryDao categoryDao;

    @Test
    public void shouldInsertAndSelect() {
        Category category = new Category("영화");
        Long categoryPk = categoryDao.insert(category);

        Category result = categoryDao.selectById(categoryPk);
        
        System.out.println(result.getName());

        // http://sejong-wiki.appspot.com/assertThat
        assertThat(result.getName(), is("영화")); // result의 name은 강경미 이다(is). 읽혀지는 코드로 테스트 코드가 작성된다.
    }
    
    @Test
    public void shouldSelectAll() {
    	List<Category> categorys = categoryDao.selectAll();
    	
    	for(Category category: categorys) {
    		 System.out.println(category.getName());
    		 assertNotNull(category);
    	}
    }
    
    @Test
    public void shouldUpdate() {
        Category category = new Category("여행");
        Long categoryPk = categoryDao.insert(category);

        Category result = categoryDao.selectById(categoryPk);
        
        result.setName("공연");
        int i = categoryDao.update(result);
        
        System.out.println(result.getName());

        // http://sejong-wiki.appspot.com/assertThat
        assertThat(result.getName(), is("공연")); // result의 name은 강경미 이다(is). 읽혀지는 코드로 테스트 코드가 작성된다.
        assertThat(i, is(1));
    }
    
    @Test
    public void shouldDelete() {
        Category category = new Category("여행");
        Long categoryPk = categoryDao.insert(category);
        int i = categoryDao.delete(categoryPk);
        
        // http://sejong-wiki.appspot.com/assertThat
        // result의 name은 강경미 이다(is). 읽혀지는 코드로 테스트 코드가 작성된다.
        assertThat(i, is(1));
        
    }
}
