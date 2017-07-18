package kr.or.connect.dto;

public class PromotionDto {

	private Long id;
	private String name;
	private String description;
	private String placeName;
	private String fileURL;

	public PromotionDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	@Override
	public String toString() {
		return "PromotionDto [id=" + id + ", name=" + name + ", description=" + description + ", placeName=" + placeName
				+ ", fileURL=" + fileURL + "]";
	}

}
