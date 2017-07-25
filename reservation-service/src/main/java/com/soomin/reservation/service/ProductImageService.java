package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.domain.ProductImage;

public interface ProductImageService {
	public List<ProductImage> getRepresentitiveImage(long productId);
	public List<ProductImage> getAdditionalImage(long productId);
	public ProductImage getThumbnailImage(long productId);
	public int getCount(long productId);
}
