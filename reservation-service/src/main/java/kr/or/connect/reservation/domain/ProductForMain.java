package kr.or.connect.reservation.domain;

public class ProductForMain {
	
	private long id;
	private long categoryid;
	private String name;
	private String description;
	private String placeName;
	private String saveFileName;
	private String fileLength;

	public ProductForMain() {}
	
	public ProductForMain(long id, long categoryid, String name, String description, String placeName,
			String saveFileName, String fileLength) {
		super();
		this.id = id;
		this.categoryid = categoryid;
		this.name = name;
		this.description = description;
		this.placeName = placeName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
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

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getFileLength() {
		return fileLength;
	}

	public void setFileLength(String fileLength) {
		this.fileLength = fileLength;
	}

	@Override
	public String toString() {
		return "ProductForMain [id=" + id + ", categoryid=" + categoryid + ", name=" + name + ", description="
				+ description + ", placeName=" + placeName + ", saveFileName=" + saveFileName
				+ ", fileLength=" + fileLength + "]";
	}

	
}
