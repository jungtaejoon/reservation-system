package kr.or.connect.reservation.config;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class SpringJdbcConnectTest {
	@Autowired
	DataSource dataSource;

	@Test
	public void connectionTest() throws Exception {
		Connection connection = dataSource.getConnection();
		Assert.assertNotNull(connection);
	}
}
