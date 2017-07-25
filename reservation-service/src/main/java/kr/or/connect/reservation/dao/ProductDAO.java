package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import kr.or.connect.reservation.domain.File;
import kr.or.connect.reservation.dto.ProductDTO;

@Repository
public class ProductDAO {

	private NamedParameterJdbcTemplate jdbc;

	private RowMapper<ProductDTO> productDTORowMapper = BeanPropertyRowMapper.newInstance(ProductDTO.class);
	private RowMapper<File> fileRowMapper = BeanPropertyRowMapper.newInstance(File.class);
	
	public ProductDAO(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductDTO> selectProductsAll() {
		try {

			return jdbc.query(ProductSqls.SELECT_ALL, productDTORowMapper);

		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<ProductDTO> selectProductByCategoryId(int categoryId) {
		Map<String, Object> params = new HashMap<>();
		params.put("categoryId", categoryId);
		try {
			return jdbc.query(ProductSqls.SELECT_BY_CATEGORY_ID,params,productDTORowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public File selectProductMainImage(int id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		try {
			return jdbc.queryForObject(ProductSqls.SELECT_MAIN_IMAGE_BY_PRODUCT_ID,params,fileRowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public ProductDTO selectProductById(int id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		try {
			return jdbc.queryForObject(ProductSqls.SELECT_BY_ID,params,productDTORowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<ProductDTO> selectProductImageIdByProductId(int id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		try {
			return jdbc.query(ProductSqls.SELECT_IMAGE_ID_BY_PRODUCT_ID,params,productDTORowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public File selectProductSubImage(int id, int imageId) {
		Map<String, Object> params = new HashMap<>();
		params.put("imageId", imageId);
		params.put("id", id);
		try {
			return jdbc.queryForObject(ProductSqls.SELLECT_SUB_IMAGE_BY_PRODUCT_ID,params,fileRowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
