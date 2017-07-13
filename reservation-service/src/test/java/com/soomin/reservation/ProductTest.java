package com.soomin.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.soomin.reservation.config.RootApplicationContextConfig;
import com.soomin.reservation.dao.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class ProductTest {
	@Autowired
	ProductDao productDao;

	@Test
	public void shouldCountTest() {
		int countProduct = productDao.CountProduct();
		
		assertThat(countProduct, is(2));
	}
}
