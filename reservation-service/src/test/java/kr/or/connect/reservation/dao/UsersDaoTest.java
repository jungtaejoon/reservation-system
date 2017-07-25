package kr.or.connect.reservation.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.config.RootApplicationContextConfig;
import kr.or.connect.reservation.domain.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class UsersDaoTest {

	@Autowired
	UsersDao dao;

	@Test
	public void shouldUsersTest() {
		Users user = new Users();
		user.setSnsId("1234");
		
		long returnKey = dao.insert(user);
		Long result = dao.selectUserIdBySnsId("1234");
		
		assertThat(returnKey, is(result));
	}
}
