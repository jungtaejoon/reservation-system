package dunkirk.reservation.service;

import java.util.*;

import dunkirk.reservation.dto.*;

public interface ProductService {
    List<ProductForMainDto> getList(int categoryId, int page);

    ProductForDetailDto getDetail(int id);

    ProductForReservationDto getForReservation(int id);
}
