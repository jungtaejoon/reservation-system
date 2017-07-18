package kr.or.reservation.jdbc;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.reservation.config.RootApplicationContextConfig;
import kr.or.reservation.domain.Product;
import kr.or.reservation.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class ProductTest {

	@Autowired
	ProductService productService; 
	
	Logger log = Logger.getLogger(this.getClass());
	   
	@Test
	public void SelectAll() {
		List<Product> list = productService.getProductByCategory(0,2);
		
		for(Product pro : list) {
			log.info(pro.toString()+"\n");
		}
	}
	
	@Test
	public void getCategoryCount() {
		int countAll = productService.countProduct(0);
		log.info(countAll);
		
	}
	

}
