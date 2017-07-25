package kr.or.connect.reservation.dto;

public class MainPageProductDto {
	private long id;
	private long fileId;
	private long categoryId;
	private String name;
	private String description;
	private String placeName;

	public MainPageProductDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "MainPageProductDto [id=" + id + ", fileId=" + fileId + ", categoryId=" + categoryId + ", name=" + name
				+ ", description=" + description + ", placeName=" + placeName + "]";
	}

}
