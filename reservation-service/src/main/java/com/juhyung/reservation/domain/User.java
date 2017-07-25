package com.juhyung.reservation.domain;

public class User {
	
	private Integer id;
	private String username;
	private String email;
	private String tel;
	private String snsId;
	private int adminFlag;
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
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
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
	public int getAdminFlag() {
		return adminFlag;
	}
	public void setAdminFlag(int adminFlag) {
		this.adminFlag = adminFlag;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", tel=" + tel + ", snsId=" + snsId
				+ ", adminFlag=" + adminFlag + "]";
	}
}
