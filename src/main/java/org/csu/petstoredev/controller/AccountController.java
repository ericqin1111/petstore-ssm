package org.csu.petstoredev.controller;


import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.vo.UserVO;
import org.csu.petstoredev.service.AccountService;
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
    AccountService accountService;
    @GetMapping("loginForm")
    public String loginForm(Model model){
        UserVO user=new UserVO();
        model.addAttribute("user",user);
        return "/account/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute UserVO user, HttpSession session){
        System.out.println("我在login里");
        if(accountService.isUserExist(session, user.getUsername(),user.getPassword())){
            return "redirect:/catalog/index";
        }

        return "demo1";
    }
}
