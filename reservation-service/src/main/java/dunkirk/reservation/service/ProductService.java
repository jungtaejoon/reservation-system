package dunkirk.reservation.service;

import java.util.List;

import dunkirk.reservation.domain.Product;

public interface ProductService {
	public List<Product> getList(int categoryId, int start);
}
