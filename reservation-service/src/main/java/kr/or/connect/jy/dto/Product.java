package kr.or.connect.jy.dto;

import java.sql.Timestamp;

public class Product {
	int id;
	int categoryId;
	String name;
	String description;
	Timestamp sales_start;
	Timestamp sales_end;
	boolean sales_flag;
	String event;
	Timestamp create_date;
	Timestamp modify_date;

	public Product() {
		super();
	}

	public Product(int categoryId) {
		super();
		this.categoryId = categoryId;
	}

	public Product(int id, int categoryId, String name, String description, Timestamp sales_start, Timestamp sales_end,
			boolean sales_flag, String event, Timestamp create_date, Timestamp modify_date) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.sales_start = sales_start;
		this.sales_end = sales_end;
		this.sales_flag = sales_flag;
		this.event = event;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public boolean isSales_flag() {
		return sales_flag;
	}

	public void setSales_flag(boolean sales_flag) {
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
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", description=" + description
				+ ", sales_start=" + sales_start + ", sales_end=" + sales_end + ", sales_flag=" + sales_flag
				+ ", event=" + event + ", create_date=" + create_date + ", modify_date=" + modify_date + "]";
	}

}
