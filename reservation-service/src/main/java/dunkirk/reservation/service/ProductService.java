package dunkirk.reservation.service;

import java.util.*;

import dunkirk.reservation.dto.*;

public interface ProductService {
	public List<ProductForMainDto> getList(int categoryId, int page);
	public ProductForDetailDto getDetail(int id);
	public ProductForReservationDto getForReservation(int id);
}
