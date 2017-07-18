package kr.or.connect.jy.dto;

public class ProductImage {
	int id;
	int productId;
	int fileId;
	boolean type; // true 상단에 이미지들 false 상세정보에 이미지들

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImage(int id, int productId, int fileId, boolean type) {
		super();
		this.id = id;
		this.productId = productId;
		this.fileId = fileId;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", productId=" + productId + ", fileId=" + fileId + ", type=" + type + "]";
	}

}
