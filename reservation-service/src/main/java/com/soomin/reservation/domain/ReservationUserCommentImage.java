package com.soomin.reservation.domain;

public class ReservationUserCommentImage {
	private long id;
	private long reservation_user_comment_id;
	private long file_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getReservation_user_comment_id() {
		return reservation_user_comment_id;
	}
	public void setReservation_user_comment_id(long reservation_user_comment_id) {
		this.reservation_user_comment_id = reservation_user_comment_id;
	}
	public long getFile_id() {
		return file_id;
	}
	public void setFile_id(long file_id) {
		this.file_id = file_id;
	}
	
}
