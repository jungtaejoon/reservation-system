package com.ys.reservation.domain;

public class NaverProfileResponse {
	private String resultcode;
	private String message;
	private NaverProfile response;
	
	public String getResultcode() {
		return resultcode;
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
	public NaverProfile getResponse() {
		return response;
	}
	public void setResponse(NaverProfile response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "NaverProfileResponse [resultcode=" + resultcode + ", message=" + message + ", response=" + response
				+ "]";
	}
}
