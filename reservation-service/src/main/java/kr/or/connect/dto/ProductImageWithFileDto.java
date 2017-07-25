package kr.or.connect.dto;

public class ProductImageWithFileDto {

	private Long id;
	private int type;
	private Long fileId;

	public ProductImageWithFileDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "ProductImageDto [id=" + id + ", type=" + type + ", fileId=" + fileId + "]";
	}

}
