package dunkirk.reservation.dao.impl;

import dunkirk.reservation.dao.CategoryDao;
import dunkirk.reservation.domain.Category;
import dunkirk.reservation.sql.CategorySqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> rowMapper = new BeanPropertyRowMapper(Category.class);

    @Autowired
    public CategoryDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Category> getList() {
        return jdbc.query(CategorySqls.GET_LIST, rowMapper);
    }

}
