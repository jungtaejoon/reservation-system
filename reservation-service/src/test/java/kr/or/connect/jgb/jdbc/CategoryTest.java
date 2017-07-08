package kr.or.connect.jgb.jdbc;

import kr.or.connect.jgb.config.RootApplicationContextConfig;
import kr.or.connect.jgb.dao.CategoryDao;
import kr.or.connect.jgb.domain.Category;

//import com.sun.tools.javac.comp.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional  // Transactional이 있을 때와 없을 때 각각 실행해보고 그 때마다 msyql에서 결과를 select해본다.
public class CategoryTest {
    @Autowired
    CategoryDao categoryDao;

    @Test
    public void shouldInsertAndSelect() {
        Category category = new Category("뮤지컬");
        Long categoryPk =categoryDao.insert(category);

        Category result = categoryDao.selectById(categoryPk);

        // http://sejong-wiki.appspot.com/assertThat
        assertThat(result.getName(), is("뮤지컬")); // result의 name은 강경미 이다(is). 읽혀지는 코드로 테스트 코드가 작성된다.
       
    }
    
    @Test
    public void selectAll() {
        Category category = new Category("뮤지컬");
        Long categoryPk =categoryDao.insert(category);
        
        Category category2 = new Category("합창");
        Long categoryPk2 =categoryDao.insert(category2);

        Category result = categoryDao.selectById(categoryPk);

        List<Category> categories = categoryDao.selectAll();
        
        for(int i=0;i<categories.size();i++) {
        	System.out.println(categories.get(i).getName());
        }
    }


//    @Test
//    public void shouldDelete() {
//        // given
//        Member member = new Member("강경미", "carami@nate.com", "1234");
//        Long memberPk = memberDao.insert(member);
//
//        // when
//        int deleteCount = memberDao.delete(memberPk);
//
//        // then
//        assertThat(deleteCount, is(1));
//    }
//
//    @Test
//    public void shouldUpdate() {
//
//        // given
//        Member member = new Member("강경미", "carami@nate.com", "1234");
//        Long memberPk = memberDao.insert(member);
//
//        // when
//        member.setId(memberPk);
//        member.setName("강경미2");
//        member.setEmail("carami2@nate.com");
//        int updateCount = memberDao.update(member);
//
//        // Then
//        Member result = memberDao.selectById(memberPk);
//        assertThat(result.getName(), is("강경미2"));
//        assertThat(result.getEmail(), is("carami2@nate.com"));
//    }
}
