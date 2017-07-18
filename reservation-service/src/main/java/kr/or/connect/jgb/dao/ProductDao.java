package kr.or.connect.jgb.dao;

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

import kr.or.connect.jgb.domain.Product;
import kr.or.connect.jgb.domain.vo.ProductMainVO;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체
    private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.
    private RowMapper<ProductMainVO> mainRowMapper = BeanPropertyRowMapper.newInstance(ProductMainVO.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.

    // Spring은 생성자를 통하여 주입을 하게 된다.
    // DbConfig에서 bean으로 등록한 dataSource()를 찾아서 넣어준다. DataSource가 하나뿐이기 때문에
    // dataSource1로 해도 실행이 되지만 만약 또 다른 DataSource가 bean에 등록되면 변수 이름을 맞춰줘야 한다.
    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); // Datasource를 주입
        this.insertAction = new SimpleJdbcInsert(dataSource)  // Datasource를 주입
                .withTableName("product")   // table명을 지정
                .usingGeneratedKeyColumns("id"); // pk 칼럼을 지정
    }

    public int insert(Product product){
        SqlParameterSource params = new BeanPropertySqlParameterSource(product);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    public Product selectById(int id){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(ProductSqls.SELECT_BY_ID,params,rowMapper);
    }
    
    public int update(Product product){
        SqlParameterSource params = new BeanPropertySqlParameterSource(product);
        return jdbc.update(ProductSqls.UPDATE_BY_ID, params);
    }

    public int delete(int id){
        Map<String, ?> params = Collections.singletonMap("id", id);
        return jdbc.update(ProductSqls.DELETE_BY_ID, params);
    }
    
    public List<ProductMainVO> selectAll(int page) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("limit", 5);
    	params.put("offset", 5*(page-1));
    	
    	return jdbc.query(ProductSqls.SELECT_ALL,params,mainRowMapper);
    }
    
    public List<ProductMainVO> selectAllByCategory(int categoryId,int page){
    	Map<String, Object> params = new HashMap<>();
        params.put("category_id", categoryId);
        params.put("limit", 5);
    	params.put("offset", 5*(page-1));
    	return jdbc.query(ProductSqls.SELECT_ALL_BY_CATEGORY,params,mainRowMapper);
    }
}
