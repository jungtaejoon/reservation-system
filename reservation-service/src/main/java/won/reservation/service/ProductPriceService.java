package won.reservation.service;

import java.util.List;

import won.reservation.domain.ProductPrice;

public interface ProductPriceService {
	public List<ProductPrice> get(Integer productId);
}
