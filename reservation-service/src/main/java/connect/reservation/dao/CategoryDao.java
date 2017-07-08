package connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import connect.reservation.domain.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체
    private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.
    
    // Spring은 생성자를 통하여 주입을 하게 된다.
    public CategoryDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); // Datasource를 주입
        this.insertAction = new SimpleJdbcInsert(dataSource)  // Datasource를 주입
                .withTableName("category")   // table명을 지정
                .usingGeneratedKeyColumns("id"); // pk 칼럼을 지정
    }
    
    public int insert(Category category){
        SqlParameterSource params = new BeanPropertySqlParameterSource(category); 
        return insertAction.executeAndReturnKey(params).intValue();	
    }
    
    public Category selectById(long id){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(CategorySqls.SELECT_BY_ID,params,rowMapper);	
    }
    
    public int updateById(Category category){
        SqlParameterSource params = new BeanPropertySqlParameterSource(category);
        return jdbc.update(CategorySqls.UPDATE_BY_ID, params);
    }

    public int deleteById(int id){
        Map<String, ?> params = Collections.singletonMap("id", id);
        return jdbc.update(CategorySqls.DELETE_BY_ID, params);
    }
    
    public int deleteAll() {
    	Map<String, Object> params = Collections.emptyMap();
    	return jdbc.update(CategorySqls.DELETE_ALL, params);
    }
    
    public List<Category> selectAll() {
    	Map<String, Object> params = Collections.emptyMap();
    	return jdbc.query(CategorySqls.SELECT_ALL, params, rowMapper);
    }
    
    public int selectAllCount() {
    	Map<String, Object> params = Collections.emptyMap();
    	return jdbc.queryForObject(CategorySqls.SELECT_ALL_COUNT, params, Integer.class);
    }
}
