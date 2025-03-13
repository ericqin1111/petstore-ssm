package org.csu.petstoredev.controller;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;
    @RequestMapping("/newOrderForm")
    public String newOrderForm(HttpSession session){
        return "order/newOrder";
    }

    @PostMapping("/submit")
    public String submit(HttpSession session){
        orderService.submitOrder(session);
        return "redirect:/catalog/index";
    }
}
