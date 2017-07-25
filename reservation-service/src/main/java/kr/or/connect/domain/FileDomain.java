package kr.or.connect.domain;

import java.sql.*;

import org.springframework.web.multipart.*;

public class FileDomain {

	private Long id;
	private Long userId;
	private String contentType;
	private String fileName;
	private String saveFileName;
	private Long fileLength;
	private int deleteFlag;
	private Timestamp createDate;
	private Timestamp modifyDate;

	public FileDomain() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
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

	public Long getFileLength() {
		return fileLength;
	}

	public void setFileLength(Long fileLength) {
		this.fileLength = fileLength;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "FileDomain [id=" + id + ", userId=" + userId + ", contentType=" + contentType + ", fileName=" + fileName
				+ ", saveFileName=" + saveFileName + ", fileLength=" + fileLength + ", deleteFlag=" + deleteFlag
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

	public void save(MultipartFile file, String saveFileName) {
		this.setUserId(7L); //아직 유저가 직접 이미지를 등록하는 페이지가 구현되지 않아서 userId 7인 유저로 고정하여 파일 등록
		this.setFileName(file.getOriginalFilename());
		this.setFileLength(file.getSize());
		this.setContentType(file.getContentType());
		this.setSaveFileName(saveFileName);
		this.setCreateDate(new Timestamp(System.currentTimeMillis()));
		this.setModifyDate(new Timestamp(System.currentTimeMillis()));
	}

}
