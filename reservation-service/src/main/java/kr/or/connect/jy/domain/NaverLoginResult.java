package kr.or.connect.jy.domain;

public class NaverLoginResult {
	String resultcode;
	String message;
	NaverResponse response;

	public void setResponse(NaverResponse response) {
		this.response = response;
	}

	public String getResultcode() {
		return resultcode;
	}

	public NaverResponse getResponse() {
		return response;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
