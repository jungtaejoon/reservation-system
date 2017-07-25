package com.juhyung.reservation.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.juhyung.reservation.domain.Image;
import com.juhyung.reservation.domain.ProductImage;

public interface ImageService {
	
	public static final String BASE_DIR = File.separator + "Users" + File.separator + "YJH" + File.separator + "Desktop" + File.separator;
	
	public void createImage(String title, MultipartFile[] files, ProductImage productImage);
	public Image getImageByFileId(int fileId);

	//comment- file(image)
	public List<Integer> getFilesByCommentId(int commentId);
}
