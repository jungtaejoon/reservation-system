package dunkirk.reservation.service;

import java.util.*;

import dunkirk.reservation.dto.*;

public interface CommentService {
    List<CommentForDetailDto> getListByProduct(int page, int limit, int productId);

    List<Integer> getImageIdList(int id);

    String getProductNameByReservationId(int reservationId);
}
