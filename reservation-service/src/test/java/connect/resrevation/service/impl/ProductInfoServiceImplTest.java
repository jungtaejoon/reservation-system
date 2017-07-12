package connect.resrevation.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import connect.reservation.config.RootApplicationContextConfig;
import connect.reservation.dto.ProductInfo;
import connect.reservation.service.ProductInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional  // Transactional이 있을 때와 없을 때 각각 실행해보고 그 때마다 msyql에서 결과를 select해본다.
public class ProductInfoServiceImplTest {
	@Autowired
	ProductInfoService productInfoService;
	
	@Test
	public void shouldSelectAll() {		
/*		List<ProductInfo> list = new ArrayList<ProductInfo>();
		list = productInfoService.getMainInfo(1, 3);
		
		assertThat(list.size(), is(3));*/
	}
	
	@Test
	public void shouldSelectCategoryProductCount() {		
		int cnt = productInfoService.getCategoryProductCount(1);
		
		assertNotNull(cnt);
	}
}
