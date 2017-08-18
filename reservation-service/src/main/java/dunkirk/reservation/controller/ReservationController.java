package dunkirk.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dunkirk.reservation.service.ProductService;

@Controller
public class ReservationController {

    private ProductService productService;

    @Autowired
    public ReservationController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/booking")
    public String reservation(Model model, @RequestParam int productId) {
        model.addAttribute("product", productService.getForReservation(productId));
        return "reserve";
    }
}
