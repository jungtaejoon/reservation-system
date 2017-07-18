package kgw.reservation.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kgw.reservation.dto.ProductInfo;
import kgw.reservation.sql.ProductSqls;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ProductInfo> rowMapper = BeanPropertyRowMapper.newInstance(ProductInfo.class);
    
    @Autowired
	public ProductDao (DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
    
    public Collection<ProductInfo> selectAllLimit (Integer offset, Integer size) {
		Map<String, Object> params = new HashMap<>();
		params.put("offset", offset);
		params.put("size", size);
		try {
    			return jdbc.query(ProductSqls.SELECT_ALL_LIMIT, params, rowMapper);
		} catch(DataAccessException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public Integer countAll () {
    		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(ProductSqls.COUNT_ALL, params, Integer.class);
    }
    
    public Collection<ProductInfo> selectByCategoryLimit (Integer categoryId, Integer offset, Integer size) {
		Map<String, Object> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("offset", offset);
		params.put("size", size);
		
		try {
    			return jdbc.query(ProductSqls.SELECT_BY_CATEGORY_LIMIT, params, rowMapper);
		} catch(DataAccessException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public Integer countByCategory (Integer categoryId) {
    		Map<String, Object> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(ProductSqls.COUNT_BY_CATEGORY, params, Integer.class); 
    }
    
    public Collection<ProductInfo> selectById (Integer id) {
    		Map<String, Object> params = Collections.singletonMap("id", id);
    		try {
    			return jdbc.query(ProductSqls.SELECT_BY_ID, params, rowMapper);
    		} catch(DataAccessException e) {
    			e.printStackTrace();
    			return null;
    		}	
    }
    
}
