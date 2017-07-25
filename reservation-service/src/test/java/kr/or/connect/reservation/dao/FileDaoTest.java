package kr.or.connect.reservation.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.config.RootApplicationContextConfig;
import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.domain.FileDomain;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class FileDaoTest {

	@Autowired
	FileDao dao;

	@Test
	public void shouldselectFileTest() {
		
		FileDomain file = new FileDomain();
		file.setContentType("contentType");
		file.setFileName("fileName");
		file.setSaveFileName("saveFileName");
		file.setUserId(1);
		file.setDeleteFlag(0);
		file.setFileLength(123);
		
		long returnKey = dao.insert(file);
		FileDomain result = dao.selectById(returnKey);
		
		assertNotNull(result);
		assertThat(returnKey, is(result.getId()));
		
	}

	@Test
	public void shouldinsertFileTest() {
		FileDomain file = new FileDomain();
		file.setContentType("contentType");
		file.setFileName("fileName");
		file.setSaveFileName("saveFileName");
		file.setUserId(1);
		file.setDeleteFlag(0);
		file.setFileLength(123);
		
		long returnKey = dao.insert(file);
		FileDomain result = dao.selectById(returnKey);

		assertThat(result.getFileName(), is("fileName"));
	}
}
