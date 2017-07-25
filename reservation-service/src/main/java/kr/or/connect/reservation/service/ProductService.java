package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDAO;

import kr.or.connect.reservation.domain.File;
import kr.or.connect.reservation.dto.ProductDTO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> selectProductsAll(){
		return dao.selectProductsAll();
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> selectProductByCategoryId(int categoryId) {
		return dao.selectProductByCategoryId(categoryId);
	}

	@Transactional(readOnly = true)
	public File selectProductMainImage(int id) {
		return dao.selectProductMainImage(id);
	}

	@Transactional(readOnly = true)
	public ProductDTO selectProductById(int id) {
		return dao.selectProductById(id);
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> selectProductImageIdByProductId(int id) {
		return dao.selectProductImageIdByProductId(id);
	}

	@Transactional(readOnly = true)
	public File selectProductSubImage(int id, int imageId) {
		return dao.selectProductSubImage(id, imageId);
	}

}
