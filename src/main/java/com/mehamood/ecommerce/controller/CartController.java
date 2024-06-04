package com.mehamood.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehamood.ecommerce.persistence.model.Product;
import com.mehamood.ecommerce.persistence.repo.ProductRepository;
import com.mehamood.ecommerce.persistence.service.CartService;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cartService.addProduct(product);
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cartService.removeProduct(product);
        }
        return "redirect:/cart";
    }
}
