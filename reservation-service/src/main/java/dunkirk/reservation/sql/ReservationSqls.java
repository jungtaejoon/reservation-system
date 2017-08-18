package dunkirk.reservation.sql;

public class ReservationSqls {
	public final static String GET_LIST = 
			"SELECT i.id, i.product_id, i.general_ticket_count, i.youth_ticket_count, i.child_ticket_count, i.reservation_date, i.reservation_type, i.total_price, p.name product_name" + 
			" FROM reservation_info i INNER JOIN product p ON i.product_id = p.id" + 
			" WHERE user_id = :user_id" +
			" ORDER BY reservation_type, id DESC";
	
	public final static String GET_RESERVATION_TYPE_COUNT =
			"SELECT reservation_type, COUNT(*) count" + 
			" FROM reservation_info" + 
			" WHERE user_id = :user_id" + 
			" GROUP BY reservation_type";
}
