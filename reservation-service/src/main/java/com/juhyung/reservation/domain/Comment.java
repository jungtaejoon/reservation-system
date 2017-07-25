package com.juhyung.reservation.domain;

import java.util.Date;

public class Comment {
	private Integer id;
	private Integer productId;
	private Integer userId;
	private Integer score;
	private String comment;
	private Date createDate;
	private Date modifyDate;
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", productId=" + productId + ", userId=" + userId + ", score=" + score
				+ ", comment=" + comment + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", title="
				+ title + "]";
	}
	
	
}