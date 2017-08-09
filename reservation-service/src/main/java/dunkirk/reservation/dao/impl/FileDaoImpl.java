package dunkirk.reservation.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dunkirk.reservation.dao.FileDao;
import dunkirk.reservation.sql.FIleSqls;

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
		return jdbc.queryForObject(FIleSqls.GET_SAVE_FILE_NAME, params, String.class);
	}
	
}
