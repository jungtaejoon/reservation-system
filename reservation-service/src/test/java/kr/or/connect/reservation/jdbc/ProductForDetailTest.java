package kr.or.connect.reservation.jdbc;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.RootApplicationContextConfig;
import kr.or.connect.reservation.dto.ImageForDetail;
import kr.or.connect.reservation.dto.ProductForDetail;
import kr.or.connect.reservation.service.ProductForDetailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class ProductForDetailTest {
	
	@Autowired
	private ProductForDetailService service;
	
	@Test
	public void shouldGetInfo() {
		ProductForDetail detail = service.getInfo(1);
		System.out.println(detail);
		
		assertNotNull(detail);
	}
	
	@Test
	public void shouldGetImages() {
		List<ImageForDetail> images = service.getImages(1);
		System.out.println(images);
		
		assertNotNull(images);
	}
	
}
