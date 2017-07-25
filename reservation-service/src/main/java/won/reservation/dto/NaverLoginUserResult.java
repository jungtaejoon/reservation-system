package won.reservation.dto;

public class NaverLoginUserResult {
	
	private String resultCode;
    private String message;
    private NaverLoginUser response;
    
    public NaverLoginUserResult() {}

	public NaverLoginUserResult(String resultCode, String message, NaverLoginUser response) {
		this.resultCode = resultCode;
		this.message = message;
		this.response = response;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
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
