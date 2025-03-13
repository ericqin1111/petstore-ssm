package org.csu.petstoredev.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("cartForm")
    public String cartForm() {

        return "/cart/cart";
    }


    @RequestMapping("addItemToCart")
    public String addItemToCart(@RequestParam String workingItemId, HttpSession session) {
        cartService.addItem(workingItemId, session);
        return "redirect:cartForm";
    }

    @RequestMapping("removeCartItem")
    public String removeCartItem(@RequestParam String workingItemId, HttpSession session) {
        cartService.deleteItem(workingItemId, session);
        return "redirect:cartForm";
    }

    @PostMapping("updateCart")
    public String updateCart(HttpServletRequest request) {
        cartService.updateItem(request);
        return "redirect:cartForm";
    }

}
