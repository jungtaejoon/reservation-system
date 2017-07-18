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
import kr.or.connect.jy.dto.Product;
import kr.or.connect.jy.dto.ProductDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class ProductDaoTest {
	@Autowired
	ProductDao productDao;

	@Test
	public void shouldSelectAll() {
		LinkedList<Integer> ids = new LinkedList<>();
		for (int i = 1; i <= 12; i++) {
			ids.add(i);
		}
		Collection<ProductDTO> results = productDao.selectAll();
		results.forEach(item -> {
			assertThat(item.getId(), is(ids.pop()));
		});
	}
	
	@Test
	public void shouldSelectByCategoryId () {
		LinkedList<Integer> ids = new LinkedList<>();
		for (int i = 5; i <= 10; i++) {
			ids.add(i);
		}
		Collection<ProductDTO> results = productDao.selectByCategoryId(3);
		results.forEach(item -> {
			assertThat(item.getId(), is(ids.pop()));
		});
	}
}
