package connect.reservation.domain;

import java.sql.Timestamp;

public class Product {
	private int id;
	private int category_id;
	private String name;
	private String descriptrion;
	private Timestamp sales_start;
	private Timestamp sales_end;
	private int sales_flag;
	private String event;
	private Timestamp create_date;
	private Timestamp modify_date;
	
	
	public Product() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDescriptrion() {
		return descriptrion;
	}
	public void setDescriptrion(String descriptrion) {
		this.descriptrion = descriptrion;
	}
	public Timestamp getSales_start() {
		return sales_start;
	}
	public void setSales_start(Timestamp sales_start) {
		this.sales_start = sales_start;
	}
	public Timestamp getSales_end() {
		return sales_end;
	}
	public void setSales_end(Timestamp sales_end) {
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
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getModify_date() {
		return modify_date;
	}
	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", category_id=" + category_id + ", name=" + name + ", descriptrion="
				+ descriptrion + ", sales_start=" + sales_start + ", sales_end=" + sales_end + ", sales_flag="
				+ sales_flag + ", event=" + event + ", create_date=" + create_date + ", modify_date=" + modify_date
				+ "]";
	}
	
}
