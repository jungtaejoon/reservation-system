package com.soomin.reservation.dto;

import java.util.List;

import com.soomin.reservation.domain.DisplayInfo;
import com.soomin.reservation.domain.Product;
import com.soomin.reservation.domain.ProductDetail;
import com.soomin.reservation.domain.ProductImage;

public class ProductInfo {
	private Product product;
	private List<ProductImage> images;
	private ProductDetail detail;
	private DisplayInfo display_info;
	private int count_images;
	private CommentScore comment_score;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<ProductImage> getImages() {
		return images;
	}
	public void setImages(List<ProductImage> images) {
		this.images = images;
	}
	public ProductDetail getDetail() {
		return detail;
	}
	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}
	public DisplayInfo getDisplay_info() {
		return display_info;
	}
	public void setDisplay_info(DisplayInfo display_info) {
		this.display_info = display_info;
	}
	public int getCount_images() {
		return count_images;
	}
	public void setCount_images(int count_images) {
		this.count_images = count_images;
	}
	public CommentScore getComment_score() {
		return comment_score;
	}
	public void setComment_score(CommentScore comment_score) {
		this.comment_score = comment_score;
	}
	
}
