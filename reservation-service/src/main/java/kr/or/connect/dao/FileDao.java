package kr.or.connect.dao;

import java.util.*;

import javax.sql.*;

import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.stereotype.*;

import kr.or.connect.domain.*;

@Repository
public class FileDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<FileDomain> rowMapper = BeanPropertyRowMapper.newInstance(FileDomain.class);
	
	public FileDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("file").usingGeneratedKeyColumns("id");
	}

	public FileDomain insert(FileDomain file) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(file);
		file.setId(insertAction.executeAndReturnKey(params).longValue());
		return file;
	}

	public FileDomain getFile(Long fileId) {
		Map<String, Long> params = new HashMap<>();
		params.put("fileId", fileId);
		try {
			return jdbc.queryForObject(FileSqls.SELECT_BY_ID, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
