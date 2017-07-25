package won.reservation.dto;

import java.util.List;

import won.reservation.domain.File;

public class CommentInfo {
	
	private int commentId;
	private String comment;
	private Double score;
	private int userId;
	private String visitedDate;
	private Integer tempFileId;
	private List<File> commentImg;
	
	public CommentInfo() {}

	public CommentInfo(int commentId, String comment, Double score, int userId, String visitedDate, Integer tempFileId, List<File> commentImg) {
		this.commentId = commentId;
		this.comment = comment;
		this.score = score;
		this.userId = userId;
		this.visitedDate = visitedDate;
		this.tempFileId = tempFileId;
		this.commentImg = commentImg;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getVisitedDate() {
		return visitedDate;
	}

	public void setVisitedDate(String visitedDate) {
		this.visitedDate = visitedDate;
	}

	public Integer getTempFileId() {
		return tempFileId;
	}

	public void setTempFileId(Integer tempFileId) {
		this.tempFileId = tempFileId;
	}

	public List<File> getCommentImg() {
		return commentImg;
	}

	public void setCommentImg(List<File> commentImg) {
		this.commentImg = commentImg;
	}
	
}
