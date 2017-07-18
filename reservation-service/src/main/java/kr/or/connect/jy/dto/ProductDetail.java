package kr.or.connect.jy.dto;

import java.sql.Timestamp;

public class ProductDetail {
	int id; // primaryKey
	String content;
	Timestamp createDate;
	Timestamp modifyDate;

	int productId; // foreignKey(Product)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", content=" + content + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + ", productId=" + productId + "]";
	}

}
