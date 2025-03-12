package org.csu.petstoredev.controller;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("cartForm")
    public String cartForm(HttpSession session) {
        if(session.getAttribute("cart") == null) {
            System.out.println("cart is null");
            session.setAttribute("cart", cartService.getCart());
        }
        return "/cart/cart";
    }


    @RequestMapping("addItemToCart")
    public String addItemToCart() {
        return "redirect:cart/cartForm";
    }

}
