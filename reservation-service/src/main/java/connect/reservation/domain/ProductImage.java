package connect.reservation.domain;

public class ProductImage {
	private int id;
	private int product_id;
	private int file_id;
	private int type;
	
	
	public ProductImage() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", product_id=" + product_id + ", file_id=" + file_id + ", type=" + type
				+ "]";
	}
	
}
