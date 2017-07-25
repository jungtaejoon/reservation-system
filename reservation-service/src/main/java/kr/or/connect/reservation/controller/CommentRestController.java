package kr.or.connect.reservation.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.config.FileUtils;
import kr.or.connect.reservation.domain.File;
import kr.or.connect.reservation.domain.ReservationUserComment;
import kr.or.connect.reservation.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentRestController {

	@Autowired
	private CommentService service;
	
	@GetMapping("/{id}")
	public Map<String, Object> selectComments(@PathVariable int id){
		List<ReservationUserComment> list = service.selectComments(id);
		
		Map<String, Object> map = service.selectCommentsCount(id);
		
		map.put("commentList", list);
		
		return map;
	}
	
	@GetMapping("/{id}/images")
	public void selectCommentImage(@PathVariable int id, HttpServletResponse response){
		
		File image = service.selectCommentImage(id);

        FileUtils.downLoadSetting(response, image);
	}

}
