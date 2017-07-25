package kr.or.connect.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}

	@GetMapping("/{id:[\\d]+}/images")
	public List<Long> getImages(@PathVariable Long id) {
		return commentService.getImages(id);
	}
	
	@GetMapping("/{id:[\\d]+}/images/counts")
	public int getImageCounts(@PathVariable Long id) {
		return commentService.getImageCounts(id);
	}

}
