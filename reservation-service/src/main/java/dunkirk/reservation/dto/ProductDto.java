package dunkirk.reservation.dto;

import java.sql.Timestamp;

import dunkirk.reservation.domain.SalesFlag;

public class ProductDto {
	private int id;
	private int categoryId;
	private String name;
	private String description;
	private Timestamp salesStart;
	private Timestamp salesEnd;
	private SalesFlag salesFlag;
	private String event;

}
