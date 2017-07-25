package kr.or.connect.service;

import java.util.*;

import org.springframework.web.multipart.*;

import kr.or.connect.domain.*;

public interface FileService {
	List<ProductImage> insertImages(Long productId, MultipartFile mainImage, MultipartFile[] subImages);
	FileDomain getFile(Long fileId);
}
