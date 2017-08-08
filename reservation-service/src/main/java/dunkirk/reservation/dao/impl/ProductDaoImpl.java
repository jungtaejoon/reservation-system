package dunkirk.reservation.dao.impl;

import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;

import dunkirk.reservation.dao.*;
import dunkirk.reservation.domain.*;
import dunkirk.reservation.sql.*;

public class ProductDaoImpl implements ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
	
	@Autowired
	public ProductDaoImpl(DataSource dataSource) {
		super();
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}



	@Override
	public List<Product> getList(int categoryId, int start) {
		return jdbc.query(ProductSqls.GET_LIST, rowMapper);
	}

}
