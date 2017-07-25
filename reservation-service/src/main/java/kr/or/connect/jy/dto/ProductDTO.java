package kr.or.connect.jy.dto;

import java.sql.Timestamp;

public class ProductDTO {
	int id; // product
	String name; // product
	String placeName; // display_info
	String event; // product
	String content; // detail
	int categoryId; // product
	int fileId; // file
	Timestamp salesStart;
	Timestamp salesEnd;
	boolean salesFlag;

	public Timestamp getSalesStart() {
		return salesStart;
	}

	public void setSalesStart(Timestamp salesStart) {
		this.salesStart = salesStart;
	}

	public Timestamp getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(Timestamp salesEnd) {
		this.salesEnd = salesEnd;
	}

	public boolean isSalesFlag() {
		return salesFlag;
	}

	public void setSalesFlag(boolean salesFlag) {
		this.salesFlag = salesFlag;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
