package com.juhyung.reservation.persistence;

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

import com.juhyung.reservation.domain.Image;
import com.juhyung.reservation.domain.ProductImage;

@Repository
public class ImageDAOImpl implements ImageDAO{

	private NamedParameterJdbcTemplate jdbc; 
    private RowMapper<Image> imageMapper = BeanPropertyRowMapper.newInstance(Image.class);
    private RowMapper<ProductImage> productImageMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private SimpleJdbcInsert insertImage;
	private SimpleJdbcInsert insertProductImage;
    
    public ImageDAOImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); 
        this.insertImage = new SimpleJdbcInsert(dataSource) 
                .withTableName("file")   
                .usingGeneratedKeyColumns("id");
        this.insertProductImage = new SimpleJdbcInsert(dataSource) 
                .withTableName("product_image")   
                .usingGeneratedKeyColumns("id");
    }
	
	@Override
	public int insertImage(Image image) {		
		SqlParameterSource params = new BeanPropertySqlParameterSource(image);
		return insertImage.executeAndReturnKey(params).intValue();
	}
	
	@Override
	public int insertImageProduct(ProductImage productImage) {		
		SqlParameterSource params = new BeanPropertySqlParameterSource(productImage);
		return insertProductImage.executeAndReturnKey(params).intValue();
	}
	
	@Override
	public List<Integer> selectImagesByProductId(int id) {
		Map<String, ?> params = Collections.singletonMap("product_id", id);
		return jdbc.queryForList(ImgaeSqls.SELECT_IMAGES_BY_PRODUCT_ID, params, Integer.class);
	}

	@Override
	public Integer selectMainImageOfProduct(Integer productId) {
		Map<String, ?> params = Collections.singletonMap("product_id", productId);
		return jdbc.queryForObject(ImgaeSqls.SELECT_MAIN_IMAGE_OF_PRODUCT, params, Integer.class);	
	}


	@Override
	public Image selectImageByFileId(Integer fileId) {
		Map<String, ?> params = Collections.singletonMap("file_id", fileId);
		return jdbc.queryForObject(ImgaeSqls.SELECT_IMAGE_BY_FILE, params, imageMapper);
	}

	@Override
	public List<Integer> selectFilesByCommentId(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	//comment - file(image)
//	@Override
//	public List<Integer> selectFilesByCommentId(int commentId) {
//		Map<String, ?> params = Collections.singletonMap("comment_id", commentId);
//		return jdbc.query(ImgaeSqls.SELECT_FILES_BY_COMMENT_ID, params, Integer.class);
//	}


}
