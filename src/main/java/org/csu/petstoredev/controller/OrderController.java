package org.csu.petstoredev.controller;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.service.OrderService;
import org.csu.petstoredev.vo.MissingItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String submit(Model model, HttpSession session){
        System.out.println("yeeeeeeeeeeeeeeeeeeee");
        MissingItems missingItems = orderService.submitOrder(session);

        if (missingItems.isHas()){
            model.addAttribute("missingItems", missingItems);
            return "order/missing";
        }
        return "redirect:/catalog/index";
    }
}
