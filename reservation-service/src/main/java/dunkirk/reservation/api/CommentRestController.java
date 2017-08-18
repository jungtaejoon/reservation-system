package dunkirk.reservation.api;

import dunkirk.reservation.dto.CommentForDetailDto;
import dunkirk.reservation.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentRestController {

    private static final int LIMIT_10 = 10;
    private CommentService commentService;

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id:[\\d]+}/images")
    public List<Integer> getImageIdList(@PathVariable int id) {
        return commentService.getImageIdList(id);
    }

    @GetMapping
    public List<CommentForDetailDto> getListByProductId(@RequestParam int productId, @RequestParam int page) {
        return commentService.getListByProduct(page, LIMIT_10, productId);
    }
}
