package com.juhyung.reservation.controller;

import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.juhyung.reservation.domain.Image;
import com.juhyung.reservation.domain.ProductImage;
import com.juhyung.reservation.service.ImageService;

@Controller
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@GetMapping
	public String fileform() {
		return "files";
	}

	// TODO user id도 함께 받아와야한다.
	// ProductImage도 받아와야 한다. (productId)
	@PostMapping
	public String create(@RequestParam("title") String title, @RequestParam("file") MultipartFile[] files,
			@RequestParam("productId") int productId) {
		ProductImage productImage = new ProductImage();
		productImage.setProductId(productId);
		//TODO type설정
		productImage.setType(0);
		imageService.createImage(title, files, productImage);
		return "redirect:/files";
	}

	@GetMapping("/{id}")
	public void getImage(@PathVariable int id, HttpServletResponse response) {
		Image image = imageService.getImageByFileId(id);
		
		response.setHeader("Content-Disposition", "inline; filename=\"" + image.getFileName() + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", image.getContentType());
		response.setHeader("Content-Length", "" + image.getFileLength());
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		java.io.File readFile = new java.io.File(image.getSaveFileName());
		if (!readFile.exists()) { // 파일이 존재하지 않다면
			throw new RuntimeException("file not found");
		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(readFile);
			FileCopyUtils.copy(fis, response.getOutputStream());
			response.getOutputStream().flush();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				fis.close();
			} catch (Exception ex) {
				// 아무것도 하지 않음 (필요한 로그를 남기는 정도의 작업만 함.)
			}
		}
	}
	
}