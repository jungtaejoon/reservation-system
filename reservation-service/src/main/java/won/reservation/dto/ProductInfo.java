package won.reservation.dto;

// 메인페이지에서 보이는 상품 정보를 담는 DTO
public class ProductInfo {
	
	private int productId;
	private String productName;
	private String fileName;
	private int fileId;
	private String placeName;
	private String description;
	
	public ProductInfo() {}
	
	public ProductInfo(int productId, String productName, String fileName, int fileId, String placeName, String description) {
		this.productId = productId;
		this.productName = productName;
		this.fileName = fileName;
		this.fileId = fileId;
		this.placeName = placeName;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getfileId() {
		return fileId;
	}

	public void setfileId(int fileId) {
		this.fileId = fileId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
