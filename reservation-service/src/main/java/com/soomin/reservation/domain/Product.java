package com.soomin.reservation.domain;

import java.util.List;

public class Product {
	private Long category_id;
	private String create_date;
	private String description;
	private String event;
	private Long id;
	private String modify_date;
	private String name;
	private String sales_end;
	private boolean sales_flag;
	private String sales_start;

	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSales_end() {
		return sales_end;
	}
	public void setSales_end(String sales_end) {
		this.sales_end = sales_end;
	}
	public boolean isSales_flag() {
		return sales_flag;
	}
	public void setSales_flag(boolean sales_flag) {
		this.sales_flag = sales_flag;
	}
	public String getSales_start() {
		return sales_start;
	}
	public void setSales_start(String sales_start) {
		this.sales_start = sales_start;
	}
	
}
