package kr.or.connect.domain;

public class NaverLoginUserResult {
	private String message;
	private NaverLoginUser response;

	public NaverLoginUserResult() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NaverLoginUser getResponse() {
		return response;
	}

	public void setResponse(NaverLoginUser response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "NaverLoginUserResult [message=" + message + ", response=" + response + "]";
	}

}
