package org.csu.petstoredev.controller;


import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.csu.petstoredev.entity.Product;
import org.csu.petstoredev.form.User;
import org.csu.petstoredev.persistence.CategoryMapper;
import org.csu.petstoredev.persistence.UserMapper;

import org.csu.petstoredev.service.AccountService;

import org.csu.petstoredev.service.CatalogService;

import org.csu.petstoredev.service.impl.AccountServiceImpl;
import org.csu.petstoredev.service.impl.CatalogServiceImpl;
import org.csu.petstoredev.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    AccountService accountService;
    @GetMapping("loginForm")
    public String loginForm(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "/account/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute User user,HttpSession session){
        System.out.println("我在login里");
        if(accountService.isUserExist(user.getUsername(),user.getPassword())){

            return "redirect:/catalog/index";

        }

        return "/account/login";
    }

    @GetMapping("registerForm")
    public String registerForm(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "/account/register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute User user, HttpSession session){
        if(!accountService.isUsernameExist(user.getUsername())){
           accountService.insertAccount(user.getUsername(), user.getPassword());

            session.setAttribute("loginAccount", user.getUsername());
            return "/catalog/main";
        }
        return "/account/test";
    }

    @GetMapping("getDesn")
    @ResponseBody
    public List<Product> getDesn(@RequestParam String categoryId, Model model){
        CategoryVO categoryVO=new CategoryVO();
        categoryVO=catalogService.getCategory(categoryId);
        List<Product> productList=categoryVO.getProductList();

        return productList;
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        // 清空 session
        session.invalidate(); // 使当前会话失效，清除所有的 session 数据
        return "redirect:/catalog/index"; // 重定向到首页或任何你想刷新页面的路径
    }

}
