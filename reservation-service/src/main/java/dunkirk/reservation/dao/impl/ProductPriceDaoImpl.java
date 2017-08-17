package dunkirk.reservation.dao.impl;

import dunkirk.reservation.dao.ProductPriceDao;
import dunkirk.reservation.domain.ProductPrice;
import dunkirk.reservation.sql.ProductPriceSqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductPriceDaoImpl implements ProductPriceDao {

    private NamedParameterJdbcOperations jdbc;

    @Autowired
    public ProductPriceDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        super();
        this.jdbc = namedParameterJdbcOperations;
    }

    @Override
    public List<ProductPrice> getList(int productId) {
        RowMapper<ProductPrice> rowMapper = new BeanPropertyRowMapper<>(ProductPrice.class);
        Map<String, Integer> params = new HashMap<>();
        params.put("productId", productId);
        return jdbc.query(ProductPriceSqls.GET_LIST, params, rowMapper);
    }
}
