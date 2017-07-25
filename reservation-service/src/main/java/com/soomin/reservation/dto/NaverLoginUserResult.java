package com.soomin.reservation.dto;

public class NaverLoginUserResult {
	private String resultcode;
    private String message;
    private NaverLoginUser response;
    
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
	public NaverLoginUser getResponse() {
		return response;
	}
	public void setResponse(NaverLoginUser response) {
		this.response = response;
	}
    
}
