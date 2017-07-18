package kr.or.connect.reservation.dto;

public class ImageForDetail {
	
	Integer id; //image id
	String saveFileName;
	Integer fileLength;
	
	public ImageForDetail() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public Integer getFileLength() {
		return fileLength;
	}

	public void setFileLength(Integer fileLength) {
		this.fileLength = fileLength;
	}

	@Override
	public String toString() {
		return "ImageForDetail [id=" + id + ", saveFileName=" + saveFileName + ", fileLength=" + fileLength + "]";
	}
	
	
	

}
