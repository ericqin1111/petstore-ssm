package org.csu.petstoredev.service.impl;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.entity.ItemOrder;
import org.csu.petstoredev.persistence.CartStoreMapper;
import org.csu.petstoredev.persistence.ItemMapper;
import org.csu.petstoredev.persistence.ItemOrderMapper;
import org.csu.petstoredev.service.OrderService;
import org.csu.petstoredev.vo.CartItemVO;
import org.csu.petstoredev.vo.CartVO;
import org.csu.petstoredev.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    CartStoreMapper cartStoreMapper;
    @Autowired
    ItemOrderMapper itemOrderMapper;

    @Override
    public void submitOrder(HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        Random random = new Random();
        int code = random.nextInt(900000);
        while(itemOrderMapper.existItemOrder(code)) {
            code = random.nextInt(900000);
        }
        code += 100000;
        Date now = new Date();
        CartVO cart = (CartVO) session.getAttribute("cart");
        for(CartItemVO cartItemVO : cart.getCartItems()) {
            ItemOrder itemOrder = new ItemOrder();
            itemOrder.setCode(Integer.toString(code));
            itemOrder.setUserName(user.getUsername());
            itemOrder.setStatus(0);
            itemOrder.setIsDelete(0);
            itemOrder.setAddTime(now);
            itemOrder.setItemId(cartItemVO.getItem().getItemId());
            itemOrder.setTotal(cartItemVO.getQuantity());

            itemOrderMapper.insert(itemOrder);
        }
        session.removeAttribute("cart");
        cartStoreMapper.clearCartStoreByUsername(user.getUsername());
    }
}
