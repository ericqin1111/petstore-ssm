package org.csu.petstoredev.controller;


import org.csu.petstoredev.form.User;
import org.csu.petstoredev.persistence.UserMapper;
import org.csu.petstoredev.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;
    @GetMapping("loginForm")
    public String loginForm(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "/account/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute User user){
        System.out.println("我在login里");
        if(accountService.isUserExist(user.getUsername(),user.getPassword())){
            return "/account/test";
        }

        return "demo1";
    }
}
