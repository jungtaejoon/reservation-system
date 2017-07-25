package com.juhyung.reservation.domain;

public class Price {
	
	private Integer priceType;
	private Integer price;
	private Float discountRate;
	
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
	public Float getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Float discountRate) {
		this.discountRate = discountRate;
	}
	@Override
	public String toString() {
		return "Price [priceType=" + priceType + ", price=" + price + ", discountRate=" + discountRate + "]";
	}
}
