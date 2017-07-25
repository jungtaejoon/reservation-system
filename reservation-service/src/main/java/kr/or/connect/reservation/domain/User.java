package kr.or.connect.reservation.domain;

import java.sql.Timestamp;

public class User {
	private Integer id;
	private String username;
	private String email;
	private String tel;
	private String nickname;
	private String snsId;
	private String snsType;
	private String snsProfile;
	private Integer adminFlag;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private Integer naverId;
	
	

	public User() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public Integer getAdminFlag() {
		return adminFlag;
	}
	public void setAdminFlag(Integer adminFlag) {
		this.adminFlag = adminFlag;
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
	public Integer getNaverId() {
		return naverId;
	}
	public void setNaverId(Integer naverId) {
		this.naverId = naverId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", tel=" + tel + ", nickname="
				+ nickname + ", snsId=" + snsId + ", snsType=" + snsType + ", snsProfile=" + snsProfile + ", adminFlag="
				+ adminFlag + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", naverId=" + naverId
				+ "]";
	}
	
	
	
	
}
