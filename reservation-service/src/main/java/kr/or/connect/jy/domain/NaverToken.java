package kr.or.connect.jy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaverToken {
	@JsonProperty("access_token")
	String accessToken;

	@JsonProperty("refresh_token")
	String refreshToken;

	@JsonProperty("token_type")
	String tokenType;

	@JsonProperty("expires_in")
	Integer expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
}
