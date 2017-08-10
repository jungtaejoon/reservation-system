package dunkirk.reservation.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dunkirk.reservation.dao.FileDao;
import dunkirk.reservation.sql.FileSqls;

@Repository
public class FileDaoImpl implements FileDao{
	private NamedParameterJdbcTemplate jdbc;
	//RowMapper<>
	
	@Autowired
	public FileDaoImpl(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public String getSaveFileName(int id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		return jdbc.queryForObject(FileSqls.GET_SAVE_FILE_NAME, params, String.class);
	}

	@Override
	public List<Integer> getProductImageList(int productId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", productId);
		return jdbc.queryForList(FileSqls.GET_PRODUCT_IMAGE_LIST, params, Integer.class);
	}

	@Override
	public List<Integer> getProductNoticeImageList(int productId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", productId);
		return jdbc.queryForList(FileSqls.GET_PRODUCT_NOTICE_IMAGE_LIST, params, Integer.class);
	}

	@Override
	public int getProductInformationImage(int productId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", productId);
		try {
			return jdbc.queryForObject(FileSqls.GET_PRODUCT_INFORMATION_IMAGE, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
}
