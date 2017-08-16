package dunkirk.reservation.api;

import dunkirk.reservation.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentRestController {

    private CommentService commentService;

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments/{id:[\\d]+}/images")
    public List<Integer> getImageIdList(@PathVariable int id) {
        return commentService.getImageIdList(id);
    }
}
