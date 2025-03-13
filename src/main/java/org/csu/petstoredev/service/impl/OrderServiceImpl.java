package org.csu.petstoredev.service.impl;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.persistence.CartStoreMapper;
import org.csu.petstoredev.service.OrderService;
import org.csu.petstoredev.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    CartStoreMapper cartStoreMapper;

    @Override
    public void submitOrder(HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        session.removeAttribute("cart");
        cartStoreMapper.clearCartStoreByUsername(user.getUsername());
    }
}
