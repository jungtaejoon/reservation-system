package kr.or.connect.jy.dto;

import java.sql.Timestamp;

public class File {
	int id; // pk nn
	int userId; // nn
	String fileName; // nn
	String saveFileName; // nn
	long fileLength; // nn
	String contentType; // nn
	boolean deleteFlag; // nn
	Timestamp create_date;
	Timestamp modify_date;

	public File() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File(int id) {
		super();
		this.id = id;
	}

	public File(int userId, String fileName, String saveFileName, long fileLength, String contentType,
			boolean deleteFlag) {
		super();
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
	}

	public File(int id, int userId, String fileName, String saveFileName, long fileLength, String contentType,
			boolean deleteFlag) {
		super();
		this.id = id;
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
	}

	public File(int id, int userId, String fileName, String saveFileName, long fileLength, String contentType,
			boolean deleteFlag, Timestamp create_date, Timestamp modify_date) {
		super();
		this.id = id;
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}

	public File(int userId, String fileName, String saveFileName, long fileLength, String contentType,
			boolean deleteFlag, Timestamp create_date, Timestamp modify_date) {
		super();
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public long getFileLength() {
		return fileLength;
	}

	public void setFileLength(long fileLength) {
		this.fileLength = fileLength;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getModify_date() {
		return modify_date;
	}

	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", userId=" + userId + ", fileName=" + fileName + ", saveFileName=" + saveFileName
				+ ", fileLength=" + fileLength + ", contentType=" + contentType + ", deleteFlag=" + deleteFlag
				+ ", create_date=" + create_date + ", modify_date=" + modify_date + "]";
	}

}