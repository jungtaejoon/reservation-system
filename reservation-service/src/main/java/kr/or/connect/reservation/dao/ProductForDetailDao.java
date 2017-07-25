package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ImageForDetail;
import kr.or.connect.reservation.dto.ProductForDetail;


@Repository
public class ProductForDetailDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductForDetail> rowMapperInfo = BeanPropertyRowMapper.newInstance(ProductForDetail.class);
	private RowMapper<ImageForDetail> rowMapperImg = BeanPropertyRowMapper.newInstance(ImageForDetail.class);
	
	public ProductForDetailDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public ProductForDetail getInfo(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(ProductForDetailSqls.GET_INFO, params, rowMapperInfo);
	}
	
	public List<ImageForDetail> getImages(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(ProductForDetailSqls.GET_IMAGES, params, rowMapperImg );
	}
	
	public ImageForDetail getMainImage(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(ProductForDetailSqls.GET_MAIN_IMAGE, params, rowMapperImg);
	}
	
}
