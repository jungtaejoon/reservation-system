package kr.or.connect.jy.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.jy.config.RootApplicationContextConfig;
import kr.or.connect.jy.dto.File;
import kr.or.connect.jy.dto.ProductDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class FileDaoTest {
	@Autowired
	FileDao fileDao;
	
	@Test
	public void shouldSelectById () {
		File file = new File(1, 1, "파일", "저장파일", 10, "타입", false);
		int filePk = fileDao.insert(file);
		
		File result = fileDao.selectById(filePk);
		
		assertThat(result.getFileName(), is("파일"));
	}
}
