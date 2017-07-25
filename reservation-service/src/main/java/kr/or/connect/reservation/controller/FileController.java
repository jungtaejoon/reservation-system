package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.reservation.config.FileUtils;
import kr.or.connect.reservation.domain.File;
import kr.or.connect.reservation.service.ProductService;

@Controller
@RequestMapping("/files")
public class FileController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public void selectProductMainImage(@PathVariable int id, HttpServletResponse response) {
				
		File image = productService.selectProductMainImage(id);

		FileUtils.downLoadSetting(response, image);
	}
	
	@GetMapping("/{id}/subImages/{imageId}")
	public void selectProductSubImage(@PathVariable int id, @PathVariable int imageId, HttpServletResponse response) {

		File image = productService.selectProductSubImage(id, imageId);

		FileUtils.downLoadSetting(response, image);		
	}
	
}
