package kr.or.connect.reservation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.domain.UserComment;
import kr.or.connect.reservation.dto.FileIdDto;
import kr.or.connect.reservation.service.UserCommentService;

@RestController
@RequestMapping("/api/comment")
public class UserCommentController {
	@Autowired
	UserCommentService userCommentService;
	
	@GetMapping
	public Map<String, Object> selectUserCommentByProductId(
			@RequestParam(name="productid") int productId, 
			@RequestParam(name="limit") int limit, 
			@RequestParam(name="offset") int offset){
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<UserComment> userComment = userCommentService.getUserCommentByProductId(productId, limit, offset);
		List<FileIdDto> fileIdDto = userCommentService.getUserCommentFileId(productId, limit, offset);
		
		result.put("userComment", userComment);
		result.put("fileIdDto", fileIdDto);
		
		/*
		 * {
		 * 	userComment:[{
		 * 			productId : 1,
		 * 			userId : 2,
		 * 			...
		 * 			fileIdDto : [
		 * 				{userId : 2, id : 2},
		 * 				{userId : 2, id : 3}
		 * 			]
		 * -------------------------------
		 * 			fileId : [2, 3] //best?
		 * -------------------------------
		 * 		},
		 * 		{}
		 * 	],
		 * }
		 * 이러한 구조로 만들고 싶은데 굳이 그럴 필요가 있을까 라는 생각도 든다.
		*/
		return result;
	}
	
//	@GetMapping
//	public List<UserComment> selectUserCommentByProductId(
//			@RequestParam(name="productid") int productId, 
//			@RequestParam(name="limit") int limit, 
//			@RequestParam(name="offset") int offset){
//		
//		return userCommentService.getUserCommentByProductId(productId, limit, offset);
//	}
	
	@GetMapping("/getall")
	public List<FileIdDto> testMethod(
			@RequestParam(name="productid") int productId,
			@RequestParam(name="limit") int limit,
			@RequestParam(name="offset") int offset){
		
		return userCommentService.getUserCommentFileId(productId, limit, offset);
	}
	
	@GetMapping("/count/{id}")
	public Integer selectUserCommentCount(@PathVariable("id")int id){
		return userCommentService.getUserCommentCount(id);
	}
	
	@GetMapping("/average/{id}")
	public BigDecimal selectUserCommentAvg(@PathVariable("id")int id){
		return userCommentService.getUserCommentAvg(id);
	}
}
