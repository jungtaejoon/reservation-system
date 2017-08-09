package dunkirk.reservation.dao;

import java.util.*;

import dunkirk.reservation.domain.*;

public interface ProductDao {

	public List<Product> getList(int categoryId, int start);
}
