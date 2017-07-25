package com.soomin.reservation.domain;

public class Users {
	private long id;
	private String username;
	private String email;
	private String tel;
	private String nickname;
	private String sns_id;
	private String sns_profile;
	private long admin_flag;
	private String create_date;
	private String modify_date;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getSns_id() {
		return sns_id;
	}
	public void setSns_id(String sns_id) {
		this.sns_id = sns_id;
	}
	public String getSns_profile() {
		return sns_profile;
	}
	public void setSns_profile(String sns_profile) {
		this.sns_profile = sns_profile;
	}
	public long getAdmin_flag() {
		return admin_flag;
	}
	public void setAdmin_flag(long admin_flag) {
		this.admin_flag = admin_flag;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	
}
