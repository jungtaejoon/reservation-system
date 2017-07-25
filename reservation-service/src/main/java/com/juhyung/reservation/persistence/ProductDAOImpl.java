package com.juhyung.reservation.persistence;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.Price;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.dto.DetailProduct;
import com.juhyung.reservation.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO{

	private NamedParameterJdbcTemplate jdbc; 
    private RowMapper<ProductVO> rowMapperVO = BeanPropertyRowMapper.newInstance(ProductVO.class); 
    private RowMapper<ProductDTO> rowMapperDTO = BeanPropertyRowMapper.newInstance(ProductDTO.class);
    private RowMapper<DetailProduct> detailRowMapper = BeanPropertyRowMapper.newInstance(DetailProduct.class);
    private RowMapper<Price> priceRowMapper = BeanPropertyRowMapper.newInstance(Price.class);
    
    public ProductDAOImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); 
    }
    
	@Override
	public List<ProductDTO> selectListPage(PageCriteria pageCriteria) {
		Map<String, Object> params = new HashMap<>();
        params.put("page", pageCriteria.getPage());
        params.put("perNum", pageCriteria.getPerNum());
		return jdbc.query(ProductSqls.SELECT_LIST_PAGE, params, rowMapperDTO);
	}

	@Override
	public List<ProductDTO> selectListByCategory(Integer categoryId, PageCriteria pageCriteria) {
		Map<String, Object> params = new HashMap<>();
        params.put("page", pageCriteria.getPage());
        params.put("perNum", pageCriteria.getPerNum());
        params.put("category_id", categoryId);
		return jdbc.query(ProductSqls.SELECT_LIST_BY_CATEGORY, params, rowMapperDTO);
	}

	@Override
	public Integer countOfSaleProduct() {
		Map<String, ?> params = Collections.emptyMap();
		return jdbc.queryForObject(ProductSqls.SELECT_COUNT_OF_SALE_PRODUCT, params, Integer.class);
	}

	@Override
	public Integer countOfSaleProductByCategoryId(int id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(ProductSqls.SELECT_COUNT_OF_SALE_PRODUCT_BY_CATEGORY, params, Integer.class);
	}
	
	@Override
	public List<ProductVO> selectListPromotion() {
		return jdbc.query(ProductSqls.SELECT_LIST_PROMOTION, rowMapperVO);
	}

	@Override
	public DetailProduct selectDetailProductById(int id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(ProductSqls.SELECT_DETAIL_PRODUCT_BY_ID, params, detailRowMapper);
	}

	@Override
	public List<Price> selectPriceInfoByProduct(int id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.query(ProductSqls.SELECT_PRICE_BY_PRODUCT, params, priceRowMapper);
	}

}
