package com.juhyung.resrvation.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juhyung.reservation.config.RootApplicationContextConfig;
import com.juhyung.reservation.persistence.ImageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class TestImage {

	@Autowired
	private ImageDAO imageDao;
	
	@Test
	public void testGetImage(){
//		System.out.println(imageDao.selectImageByImageId(imageDao.selectImageIdByProduct(1)).toString());
	}
	
}
