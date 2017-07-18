package kr.or.connect.reservation.dto;

public class Product {
	int id;
	int category_id;
	String name;
	String description;
	String place_name;
	String sales_start;
	String sales_end;
	int sales_flag;
	String event;
	String create_date;
	String modify_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
	public String getSales_start() {
		return sales_start;
	}
	public void setSales_start(String sales_start) {
		this.sales_start = sales_start;
	}
	public String getSales_end() {
		return sales_end;
	}
	public void setSales_end(String sales_end) {
		this.sales_end = sales_end;
	}
	public int getSales_flag() {
		return sales_flag;
	}
	public void setSales_flag(int sales_flag) {
		this.sales_flag = sales_flag;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", category_id=" + category_id + ", name=" + name + ", description=" + description
				+ ", place_name=" + place_name + ", sales_start=" + sales_start + ", sales_end=" + sales_end
				+ ", sales_flag=" + sales_flag + ", event=" + event + ", create_date=" + create_date + ", modify_date="
				+ modify_date + "]";
	}
	
}
