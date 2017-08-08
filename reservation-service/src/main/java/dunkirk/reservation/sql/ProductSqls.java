package dunkirk.reservation.sql;

public class ProductSqls {

	public static final String GET_LIST1 = "SELECT p.*, di.*"
			+ " FROM product p INNER JOIN display_info di ON p.id = di.product_id";
	public static final String GET_LIST = "";


}
