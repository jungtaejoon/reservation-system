package dunkirk.reservation.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dunkirk.reservation.dao.CategoryDao;
import dunkirk.reservation.domain.Category;
import dunkirk.reservation.sql.CategorySqls;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = new BeanPropertyRowMapper(Category.class);
	
	@Autowired
	public CategoryDaoImpl(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
							.withTableName("category")
							.usingGeneratedKeyColumns("id");	
	}
	
	@Override
	public List<Category> getList() {
		System.out.println("dao");
		return jdbc.query(CategorySqls.GET_LIST, rowMapper);
	}

}
