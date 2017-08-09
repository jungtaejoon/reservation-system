package dunkirk.reservation.service;

import java.util.*;

import durkirk.reservation.dto.*;

public interface ProductService {
	public List<ProductForMainDto> getList(int categoryId, int start);
}
