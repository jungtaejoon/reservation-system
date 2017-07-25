package kgw.reservation.dto;

// 메인 리스트에서 사용될 dto
public class ProductInfo {
	// product
	private Integer id;
//	private Integer categoryId;
	private String name;
	private String description;
//	private Date salesStart;
//	private Date salesEnd;
//	private Integer salesFlag;
//	private String event;
//	private Date createDate; 
//	private Date modifyDate;
	
	// productImage
//	private Integer productImageId;
//	private Integer type;
	
	// productDetail
//	private Integer productDetailId;
//	private String content;
//	private Date productDetailCreateDate;
//	private Date productDetailModifyDate;

	// file 
	private Integer fileId;
//	private Integer userId;
//	private String fileName;
	private String saveFileName;
//	private Integer fileLength;
//	private String contentType;
//	private Integer deleteFlag;
//	private Date fileCreateDate;
//	private Date fileModifyDate;
	
	// displayinfo
//	private Integer displayId;
//	private String observationTime;
//	private Date displayStart;
//	private Date displayEnd;
	private String placeName;
//	private String placeStreet;
//	private String tel;
//	private String homepage;
//	private String email;
//	private Date displayInfoCreateDate;
//	private Date displayInfoModifyDate;

	
	//productprice
//	private Integer productPriceId;
//	private Integer priceType;
//	private Integer price;
//	private Double discountRate;
//	private Date productPriceCreateDate;
//	private Date productPriceModifyDate;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	
}
