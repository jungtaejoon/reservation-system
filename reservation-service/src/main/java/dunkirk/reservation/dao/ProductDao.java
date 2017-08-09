package dunkirk.reservation.dao;

import java.util.*;

import durkirk.reservation.dto.*;

public interface ProductDao {

	public List<ProductForMainDto> getList(int categoryId, int start);
}
