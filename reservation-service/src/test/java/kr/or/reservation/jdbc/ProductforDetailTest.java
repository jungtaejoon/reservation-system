package kr.or.reservation.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.reservation.config.RootApplicationContextConfig;
import kr.or.reservation.dao.ProductForDetailDao;
import kr.or.reservation.domain.ProductForDetail;
import kr.or.reservation.service.ProductForDetailService;

import static org.hamcrest.CoreMatchers.is;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class ProductforDetailTest {

	@Autowired
	ProductForDetailDao dao ;
	
	@Autowired
	ProductForDetailService service ;
	
	Logger log = Logger.getLogger(this.getClass());
	
	// dao test 
	@Test
	public void SelectOne() {
		// config
		int id  = 1 ;
		//ProductForDetail detail =dao.selectOne(id);
		ProductForDetail detail =service.selectOne(id);
		
		// test 
		Assert.assertThat(id, is(detail.getId()));
		log.info(detail);
	}
	
	@Test
	public void saleTimeTest() {
		ProductForDetail detail = dao.selectOne(2);
		 Timestamp t1 = new Timestamp(System.currentTimeMillis());
		 if(detail.getSalesEnd().getTime() - t1.getTime()  < 0) {
			 log.info("test");
		 }else {
			 
		 }
		 
	}
	
	

}
