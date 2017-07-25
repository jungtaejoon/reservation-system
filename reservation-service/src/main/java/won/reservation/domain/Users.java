package won.reservation.domain;

import java.sql.Timestamp;

public class Users {
	private int id;
	private String userName;
	private String email;
	private String tel;
	private String nickName;
	private String snsId;
	private String snsType;
	private String snsProfile;
	private Integer adminFlag;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	public Users() {
		
	}

	public Users(int id, String userName, String email, String tel, String nickName, String snsId, String snsType,
			String snsProfile, Integer adminFlag, Timestamp createDate, Timestamp modifyDate) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.tel = tel;
		this.nickName = nickName;
		this.snsId = snsId;
		this.snsType = snsType;
		this.snsProfile = snsProfile;
		this.adminFlag = adminFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "[USERS] id = "+id+" ,username = " + userName +" ,email = " + email +" ,tel = "+tel
				+" ,nickname = " + nickName +" ,snsId = " + snsId +" ,snsType = " + snsType +" ,snsProfile = " + snsProfile
				+" ,adminFlag = " + adminFlag +" , createDate = "+ createDate + " , modifyDate = "+ modifyDate;
	}
	
}
