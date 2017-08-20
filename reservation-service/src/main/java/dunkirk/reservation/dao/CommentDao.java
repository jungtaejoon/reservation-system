package dunkirk.reservation.dao;

import java.util.*;

import dunkirk.reservation.dto.*;

public interface CommentDao {
    List<CommentForDetailDto> getListByProduct(int page, int limit, int productId);

    List<Integer> getImageIdList(int id);

    String getProductNameByReservationId(int reservationId);
}
