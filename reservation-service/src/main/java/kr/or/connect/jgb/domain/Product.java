package kr.or.connect.jgb.domain;

public class Product {
	private int id;
	private int categoryId;
	private String name;
	private String description;
	private String salesStart;
	private String salesEnd;
	private int salesFlag;
	private String event;
	private String createDate;
	private String modifyDate;
	
	
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
	public String getSalesStart() {
		return salesStart;
	}
	public void setSalesStart(String salesStart) {
		this.salesStart = salesStart;
	}
	public String getSalesEnd() {
		return salesEnd;
	}
	public void setSalesEnd(String salesEnd) {
		this.salesEnd = salesEnd;
	}
	public int getSalesFlag() {
		return salesFlag;
	}
	public void setSalesFlag(int salesFlag) {
		this.salesFlag = salesFlag;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
