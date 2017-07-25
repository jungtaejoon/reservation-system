package kr.or.connect.reservation.domain;

public class Price {
	private long id;
	private long productId;
	private int priceType;
	private String price;
	private float discountRate;
	private String createDate;
	private String modifyDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", productId=" + productId + ", priceType=" + priceType + ", price=" + price
				+ ", discountRate=" + discountRate + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}
}
