package com.juhyung.reservation.persistence;

import java.util.List;

import com.juhyung.reservation.domain.Image;
import com.juhyung.reservation.domain.ProductImage;

public interface ImageDAO {

	public int insertImage(Image image);
	public int insertImageProduct(ProductImage productImage);
	
	public List<Integer> selectImagesByProductId(int id);
	
	public Integer selectMainImageOfProduct(Integer productId);
	
	public Image selectImageByFileId(Integer fileId);
	
	// comment-file(image)
	public List<Integer> selectFilesByCommentId(int commentId);
}
