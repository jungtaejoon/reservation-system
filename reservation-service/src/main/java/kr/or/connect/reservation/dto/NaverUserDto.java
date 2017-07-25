package kr.or.connect.reservation.dto;

public class NaverUserDto {

	private String id;
	private String profileImage;
	private String age;
	private String email;
	private String gender;
	private String birthday;
	private String nickname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "NaverUserDto [id=" + id + ", profileImage=" + profileImage + ", age=" + age + ", email=" + email
				+ ", gender=" + gender + ", birthday=" + birthday + ", nickname=" + nickname + "]";
	}

}
