package dunkirk.reservation.dao;

import java.util.*;

import dunkirk.reservation.dto.*;

public interface ProductDao {
    List<ProductForMainDto> getList(int categoryId, int page);

    ProductForDetailDto getDetail(int id);

    ProductForReservationDto getForReservation(int id);
}
