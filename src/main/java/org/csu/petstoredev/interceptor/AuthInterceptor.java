package org.csu.petstoredev.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.entity.Item;
import org.csu.petstoredev.service.CartService;
import org.csu.petstoredev.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    CartService cartService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/account/loginForm");
            return false;
        }
        if(session.getAttribute("cart") == null) {
            System.out.println("cart is null");
            session.setAttribute("cart", cartService.getCart());
            cartService.loadCart(request);

        }
        return true;
    }
}
