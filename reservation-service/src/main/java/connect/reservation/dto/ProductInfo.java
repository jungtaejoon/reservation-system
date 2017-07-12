package connect.reservation.dto;

public class ProductInfo {
	private int productId;
	private int categoryId;
	private String productName;
	private String description;
	private String placeName;
	private String fileName;
	private String saveFileName;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
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
	
	
	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", description=" + description + ", placeName=" + placeName + ", fileName=" + fileName
				+ ", saveFileName=" + saveFileName + "]";
	}
	
}
