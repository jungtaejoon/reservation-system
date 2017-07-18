package kr.or.connect.reservation.jdbc;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.RootApplicationContextConfig;
import kr.or.connect.reservation.domain.ProductForMain;
import kr.or.connect.reservation.service.ProductForMainService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class ProductForMainTest {
	//@Autowired
	private Logger log = LoggerFactory.getLogger(ProductForMainTest.class);
	@Autowired
	private ProductForMainService service;
	
	
	@Test
    public void shouldGetAll() {
		List<ProductForMain> list = service.getAll(2,7);
		log.info(list.toString());
		System.out.println(list);
		
		assertNotNull(list);
		
    }
	
	@Test
    public void shouldGetByCategory() {
		List<ProductForMain> list = service.getByCategory(4,2,7);
		log.info(list.toString());
		System.out.println(list);
		assertNotNull(list);
		
    }
	
	@Test
    public void shouldCountAll() {
		Integer num = service.countAll();
		log.info(num.toString());
		System.out.println(num);
		assertNotNull(num);
		
    }
	
	@Test
    public void shouldCountByCategory() {
		Integer num = service.countByCategory(4);
		log.info(num.toString());
		System.out.println(num);
		assertNotNull(num);
		
    }
	
	@Test
    public void shouldGetVisual() {
		List<ProductForMain> list = service.getVisual();
		log.info(list.toString());
		System.out.println(list);
		
		assertNotNull(list);
		
    }

}
