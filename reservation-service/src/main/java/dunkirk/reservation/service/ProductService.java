package dunkirk.reservation.service;

import java.util.*;

import dunkirk.reservation.domain.*;

public interface ProductService {

	public List<Product> getList(int categoryId, int start);
	
}
