package dunkirk.reservation.dao;

import dunkirk.reservation.domain.ProductPrice;

import java.util.List;

public interface ProductPriceDao {
    List<ProductPrice> getList(int productId);
}
