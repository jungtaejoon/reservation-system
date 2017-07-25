package kr.or.connect.reservation.domain;

import java.util.Date;

public class Users {
	private Long id;
	private String userName;
	private String email;
	private String tel;
	private String nickName;
	private String snsId;
	private String snsType;
	private String snsProfile;
	private int adminFlag;
	private Date createDate;
	private Date modifyDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
	public String getSnsType() {
		return snsType;
	}
	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}
	public String getSnsProfile() {
		return snsProfile;
	}
	public void setSnsProfile(String snsProfile) {
		this.snsProfile = snsProfile;
	}
	public int getAdminFlag() {
		return adminFlag;
	}
	public void setAdminFlag(int adminFlag) {
		this.adminFlag = adminFlag;
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
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", email=" + email + ", tel=" + tel + ", nickName="
				+ nickName + ", snsId=" + snsId + ", snsType=" + snsType + ", snsProfile=" + snsProfile + ", adminFlag="
				+ adminFlag + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
