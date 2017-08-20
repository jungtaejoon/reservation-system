package dunkirk.reservation.controller;

import dunkirk.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dunkirk.reservation.service.CommentService;

@Controller
public class CommentController {
    private static final int FIRST_PAGE = 0;
    private static final int LIMIT_10 = 10;
    private CommentService commentService;
    private ProductService productService;

    @Autowired
    public CommentController(CommentService commentService, ProductService productService) {
        this.commentService = commentService;
        this.productService = productService;
    }

    @GetMapping("/comment-write")
    public String write(Model model, @RequestParam int reservationId) {
        model.addAttribute("reservationId", reservationId);
        model.addAttribute("productName", commentService.getProductNameByReservationId(reservationId));
        return "reviewWrite";
    }

    @GetMapping("/comment-read")
    public String readHome(@RequestParam int productId, Model model) {
        model.addAttribute("product", productService.getDetail(productId));
        model.addAttribute("comments", commentService.getListByProduct(FIRST_PAGE, LIMIT_10, productId));
        return "review";
    }

}
