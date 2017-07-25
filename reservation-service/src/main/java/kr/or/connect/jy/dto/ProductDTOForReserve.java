package kr.or.connect.jy.dto;

import java.sql.Timestamp;
import java.util.List;

public class ProductDTOForReserve {
	/*
	 * select p.id as productId, p.name as productName, p.description,
	 * p.sales_start, p. sales_end, p.sales_flag, p.event, di.observation_time,
	 * di.display_start, di.display_end, di.place_name, di.place_lot,
	 * di.place_street, pi.type as productImageType, pi.file_id from product p join
	 * display_info di on di.product_id=p.id join product_image pi on
	 * pi.product_id=p.id group by pi.product_id;
	 */

	int productId;
	int productImageId;
	int productPriceId;
	String productName;
	String description;
	Timestamp salesStart;
	Timestamp salesEnd;
	Boolean salesFlag;
	String event;
	List<ProductPrice> productPrices;
	// display_info
	String observationTime;
	Timestamp displayStart;
	Timestamp displayEnd;
	String placeName;
	String placeLot;
	String placeStreet;

	// product_image
	int fileId;
	int productImageType;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
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

	public Timestamp getSalesStart() {
		return salesStart;
	}

	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	public String getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}

	public Timestamp getDisplayStart() {
		return displayStart;
	}

	public void setDisplayStart(Timestamp displayStart) {
		this.displayStart = displayStart;
	}

	public Timestamp getDisplayEnd() {
		return displayEnd;
	}

	public void setDisplayEnd(Timestamp displayEnd) {
		this.displayEnd = displayEnd;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceLot() {
		return placeLot;
	}

	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public void setSalesStart(Timestamp salesStart) {
		this.salesStart = salesStart;
	}

	public Timestamp getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(Timestamp salesEnd) {
		this.salesEnd = salesEnd;
	}

	public Boolean getSalesFlag() {
		return salesFlag;
	}

	public void setSalesFlag(Boolean salesFlag) {
		this.salesFlag = salesFlag;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getProductImageType() {
		return productImageType;
	}

	public void setProductImageType(int productImageType) {
		this.productImageType = productImageType;
	}

}
