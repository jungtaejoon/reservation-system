package connect.reservation.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import connect.reservation.config.RootApplicationContextConfig;
import connect.reservation.dto.ProductInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional  // Transactional이 있을 때와 없을 때 각각 실행해보고 그 때마다 msyql에서 결과를 select해본다.
public class ProductInfoDaoTest {
	@Autowired
	ProductInfoDao productInfoDao;
	
	@Test
	public void shouldSelectAll() {		
/*		List<ProductInfo> list = new ArrayList<ProductInfo>();
		list = productInfoDao.getMainInfo(1, 3);
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
		assertThat(list.size(), is(3));*/
	}
	
	@Test
	public void shouldCountCategoryProduct() {
		int cnt = productInfoDao.getCategoryProductCount(1);
		
		assertNotNull(cnt);
	}
	
	@Test
	public void shouldSelectCategoryProduct() {
//		List<ProductInfo> list = new ArrayList<ProductInfo>();
//		list = productInfoDao.getCategoryInfo(1, 0, 2);
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		
//		assertThat(list.size(), is(2));
	}

}
