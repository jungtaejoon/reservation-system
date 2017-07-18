package connect.reservation.domain;

import java.sql.Timestamp;

public class ProductDetail {
	private int id;
	private int product_id;
	private String content;
	private Timestamp create_date;
	private Timestamp modify_date;
	
	
	public ProductDetail() {
		
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getModify_date() {
		return modify_date;
	}
	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}
	
	
	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", product_id=" + product_id + ", content=" + content + ", create_date="
				+ create_date + ", modify_date=" + modify_date + "]";
	}
}
