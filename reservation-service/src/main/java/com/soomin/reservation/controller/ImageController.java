package com.soomin.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soomin.reservation.service.ProductImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	@Autowired
	ProductImageService productImageService;
	
	@GetMapping("/count/{id}")
	public int getCount(@PathVariable long id) {
		return productImageService.getCount(id);
	}
}
