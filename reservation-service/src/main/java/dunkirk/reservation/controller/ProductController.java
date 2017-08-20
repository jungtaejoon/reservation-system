package dunkirk.reservation.controller;

import dunkirk.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product-detail/{productId:[\\d]+}")
    public String detail(Model model, @PathVariable int productId) {
        model.addAttribute("product", productService.getDetail(productId));
        return "detail";
    }

}
