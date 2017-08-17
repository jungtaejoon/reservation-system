package dunkirk.reservation.sql;

public class ProductPriceSqls {
    public static final String GET_LIST =
            "SELECT * FROM product_price" +
            " WHERE product_id = :productId;";
}
