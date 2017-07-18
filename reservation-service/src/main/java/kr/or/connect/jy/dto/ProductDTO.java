package kr.or.connect.jy.dto;

public class ProductDTO {
	int id;
	String name;
	String placeName;
	String content;
	int categoryId;
	String fileId;

	public ProductDTO(int id, String name, String placeName, String content, int categoryId, String fileId) {
		super();
		this.id = id;
		this.name = name;
		this.placeName = placeName;
		this.content = content;
		this.categoryId = categoryId;
		this.fileId = fileId;
	}

	public ProductDTO(int id) {
		super();
		this.id = id;
	}

	public ProductDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
}
