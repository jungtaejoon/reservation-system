package kr.or.connect.reservation.domain;

import java.sql.Timestamp;

public class Price {
	private Integer id;
	private Integer productId;
	private Integer priceType;
	private Integer price;
	private String discountRate;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	public Price() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getPriceType() {
		return priceType;
	}

	public void setPriceType(Integer priceType) {
		this.priceType = priceType;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
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
		return "Price [id=" + id + ", productId=" + productId + ", priceType=" + priceType + ", price=" + price
				+ ", discountRate=" + discountRate + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}
	
	
}

