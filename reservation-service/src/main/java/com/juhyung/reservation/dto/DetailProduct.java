package com.juhyung.reservation.dto;

import java.util.Date;

public class DetailProduct {

	private Integer id;
	private Integer categoryId;
	private String name;
	private String description;
	private Date salesStart;
	private Date salesEnd;
	private Integer salesFlag;
	private String event;
	private Date createDate;
	private Date modifyDate;
	private String conetent;
	private String observationTime;
	private Date displayStart;
	private Date displayEnd;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String hompage;
	private String email;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
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
	public Integer getSalesFlag() {
		return salesFlag;
	}
	public void setSalesFlag(Integer salesFlag) {
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
	public String getConetent() {
		return conetent;
	}
	public void setConetent(String conetent) {
		this.conetent = conetent;
	}
	public String getObservationTime() {
		return observationTime;
	}
	public void setObservation_time(String observationTime) {
		this.observationTime = observationTime;
	}
	public Date getDisplayStart() {
		return displayStart;
	}
	public void setDisplayStart(Date displayStart) {
		this.displayStart = displayStart;
	}
	public Date getDisplayEnd() {
		return displayEnd;
	}
	public void setDisplayEnd(Date displayEnd) {
		this.displayEnd = displayEnd;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHompage() {
		return hompage;
	}
	public void setHompage(String hompage) {
		this.hompage = hompage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "DetailProduct [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", description="
				+ description + ", salesStart=" + salesStart + ", salesEnd=" + salesEnd + ", salesFlag=" + salesFlag
				+ ", event=" + event + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", conetent="
				+ conetent + ", observationTime=" + observationTime + ", displayStart=" + displayStart
				+ ", displayEnd=" + displayEnd + ", placeName=" + placeName + ", placeLot=" + placeLot
				+ ", placeStreet=" + placeStreet + ", tel=" + tel + ", hompage=" + hompage + ", email=" + email + "]";
	}
}
