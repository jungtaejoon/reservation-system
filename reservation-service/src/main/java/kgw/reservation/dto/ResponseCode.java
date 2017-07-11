package kgw.reservation.dto;

public class ResponseCode {
	// 0이면 오류 발생했을 때, 
	// 1이면 성공 
	private int code;
	public ResponseCode() {
	
	}
	public ResponseCode(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
