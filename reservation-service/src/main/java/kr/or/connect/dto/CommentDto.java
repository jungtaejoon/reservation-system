package kr.or.connect.dto;

import java.util.*;

public class CommentDto {

	private Long id;
	private Long userId;
	private Float score;
	private String comment;
	private String username;
	private Date createDate;
	private Long fileId;
	private Integer imageCount;

	public CommentDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Integer getImageCount() {
		return imageCount;
	}

	public void setImageCount(Integer imageCount) {
		this.imageCount = imageCount;
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", userId=" + userId + ", score=" + score + ", comment=" + comment
				+ ", username=" + username + ", createDate=" + createDate + ", fileId=" + fileId + ", imageCount="
				+ imageCount + "]";
	}

}
