package kr.or.connect.domain;

public class ProductImage {

	private Long id;
	private Long productId;
	private Long fileId;
	private int type;

	public ProductImage() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", productId=" + productId + ", fileId=" + fileId + ", type=" + type + "]";
	}

	public void save(Long productId, FileDomain savedFile, int type) {
		this.setFileId(savedFile.getId());
		this.setProductId(productId);
		this.setType(type);
	}

}
