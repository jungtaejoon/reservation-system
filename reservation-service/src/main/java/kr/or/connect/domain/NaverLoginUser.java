package kr.or.connect.domain;

public class NaverLoginUser {
	private String email;
	private String nickname;
	private String profileImage;
	private String age;
	private String gender;
	private String id;
	private String birthday;

	public NaverLoginUser() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "NaverLoginUser [email=" + email + ", nickname=" + nickname + ", profileImage=" + profileImage + ", age="
				+ age + ", gender=" + gender + ", id=" + id + ", birthday=" + birthday + "]";
	}

	public User convertToUser() {
		User user = new User();
		user.setAdminFlag(0);
		user.setUsername(this.getEmail().split("@")[0]);
		user.setEmail(this.getEmail());
		user.setNickname(this.getNickname());
		user.setSnsId(this.getId());
		user.setSnsProfile(this.getProfileImage());
		return user;
	}

}
