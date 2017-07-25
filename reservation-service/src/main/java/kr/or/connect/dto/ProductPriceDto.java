package kr.or.connect.dto;

public class ProductPriceDto {

	private PriceType priceType;
	private Integer price;
	private Float discountRate;

	public ProductPriceDto() {
		super();
	}

	public PriceType getPriceType() {
		return priceType;
	}

	public void setPriceType(PriceType priceType) {
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
		return "ProductPriceDto [priceType=" + priceType + ", price=" + price + ", discountRate=" + discountRate + "]";
	}

}
