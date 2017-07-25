package won.reservation.service;

import java.util.List;
import java.util.Map;

import won.reservation.domain.Product;
import won.reservation.dto.ProductDetailInfo;

public interface ProductService {
	public List<Product> get();
	public ProductDetailInfo getProduct(Integer productId);
	public int add(Product product);
	public int modify(Product product);
	public int remove(int id);
	public int getCount(Integer categoryId);
	public Map<String, Object> getProductInfo(Integer start);
	public Map<String, Object> getProductInfoCategory(Integer categoryId, Integer start);
}
