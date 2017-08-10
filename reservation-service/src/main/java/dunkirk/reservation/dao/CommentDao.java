package dunkirk.reservation.dao;

import java.util.*;

import dunkirk.reservation.dto.*;

public interface CommentDao {

	public List<CommentForDetailDto> getListByProduct(int page, int limit, int productId);

}
