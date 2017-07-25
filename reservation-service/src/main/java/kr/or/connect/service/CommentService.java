package kr.or.connect.service;

import java.util.*;

import kr.or.connect.dto.*;

public interface CommentService {

	List<CommentDto> selectByProduct(Long productId, Integer start, Integer amount);
	List<Long> getImages(Long id);
	int getImageCounts(Long id);

}
