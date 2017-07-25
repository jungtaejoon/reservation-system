package kr.or.connect.jy.dto;

public class CommentImageDTO {
	int id;
	int commentImageId;
	int userId;
	int fileId;
	String fileName;

	public int getCommentImageId() {
		return commentImageId;
	}

	public void setCommentImageId(int commentImageId) {
		this.commentImageId = commentImageId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
