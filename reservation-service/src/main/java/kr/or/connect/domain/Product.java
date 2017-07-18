package kr.or.connect.domain;

import java.util.*;

public class Product {

	private Long id;
	private Long categoryId;
	private String name;
	private String description;
	private Date salesStart;
	private Date salesEnd;
	private SalesFlag salesFlag;
	private String event;
	private Date createDate;
	private Date modifyDate;

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
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

	public Date getSalesStart() {
		return salesStart;
	}

	public void setSalesStart(Date salesStart) {
		this.salesStart = salesStart;
	}

	public Date getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(Date salesEnd) {
		this.salesEnd = salesEnd;
	}

	public SalesFlag getSalesFlag() {
		return salesFlag;
	}

	public void setSalesFlag(SalesFlag salesFlag) {
		this.salesFlag = salesFlag;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
