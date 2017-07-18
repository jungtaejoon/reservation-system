package kr.or.reservation.domain;

public class Img {
	private int productId;
	private int fileId;
	private String saveFileName;
	private String type;

	public Img() {
		// TODO Auto-generated constructor stub
	}

	public Img(int productId, int fileId, String saveFileName, String type) {
		super();
		this.productId = productId;
		this.fileId = fileId;
		this.saveFileName = saveFileName;
		this.type = type;
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

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "productId : \"" + productId + "\", fileId : \"" + fileId + "\", saveFileName : \"" + saveFileName
				+ "\", type : \"" + type;
	}

}
