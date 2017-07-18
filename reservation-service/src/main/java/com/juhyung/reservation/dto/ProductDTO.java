package com.juhyung.reservation.dto;

public class ProductDTO {
	// product의 추가적인 정보 입력
	private Integer id;
	private String name;
	private String description;
	private String event;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceLot() {
		return placeLot;
	}
	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", event=" + event
				+ ", placeName=" + placeName + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet + "]";
	}
}

/*
	--product
	`id` INT NOT NULL AUTO_INCREMENT,
	`category_id` INT NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`description` VARCHAR(100) NULL,
	`sales_start` DATETIME NOT NULL,
	`sales_end` DATETIME NULL,
	`sales_flag` INT(1) NOT NULL,
	`event` VARCHAR(4000),
	`create_date` DATETIME,
	`modify_date` DATETIME,

	--deatil
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `content` TEXT,
  `create_date` DATETIME,
  `modify_date` DATETIME,

	--price
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `price_type` INT NOT NULL,
  `price` INT NOT NULL,
  `discount_rate` DECIMAL(5,2) NOT NULL,
  `create_date` DATETIME,
  `modify_date` DATETIME,
*/