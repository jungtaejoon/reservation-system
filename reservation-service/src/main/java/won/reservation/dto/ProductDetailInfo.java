package won.reservation.dto;

import java.util.List;

import won.reservation.domain.DisplayInfo;
import won.reservation.domain.File;

//상품 디테일 페이지에서 보이는 상품 정보를 담는 DTO
public class ProductDetailInfo {
	
	private Integer productId;
	private String productName;
	private String description;
	private List<File> productImg;
	private String content;
	private String event;
	private String sales;
	private DisplayInfo displayInfo; // 오시는길에 관련된 정보
	
	public ProductDetailInfo() {}

	public ProductDetailInfo(Integer productId, String productName, String description, List<File> productImg, String content, String event, String sales, DisplayInfo displayInfo) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.productImg = productImg;
		this.content = content;
		this.event = event;
		this.sales = sales;
		this.displayInfo = displayInfo;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public List<File> getProductImg() {
		return productImg;
	}

	public void setProductImg(List<File> productImg) {
		this.productImg = productImg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

}
