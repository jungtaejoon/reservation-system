package kr.or.connect.reservation.domain;

import java.sql.Timestamp;

public class UserComment {
	private Integer id;
	private String score;
	private String comment;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private String name;  			//product name
	private Integer userId;
	private String nickname;
	private Integer imageCount;
	private String firstImageSaveFileName;
	
	public UserComment() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getImageCount() {
		return imageCount;
	}

	public void setImageCount(Integer imageCount) {
		this.imageCount = imageCount;
	}

	public String getFirstImageSaveFileName() {
		return firstImageSaveFileName;
	}

	public void setFirstImageSaveFileName(String firstImageSaveFileName) {
		this.firstImageSaveFileName = firstImageSaveFileName;
	}
	
	
	
	
}
