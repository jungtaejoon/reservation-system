package dunkirk.reservation.service;

import java.util.*;

import dunkirk.reservation.dto.*;

public interface CommentService {

	public List<CommentForDetailDto> getListByProduct(int page, int limit, int productId);

}
