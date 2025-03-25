package org.csu.petstoredev.service.impl;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.entity.Inventory;
import org.csu.petstoredev.entity.ItemOrder;
import org.csu.petstoredev.persistence.CartStoreMapper;
import org.csu.petstoredev.persistence.InventoryMapper;
import org.csu.petstoredev.persistence.ItemOrderMapper;
import org.csu.petstoredev.service.OrderService;
import org.csu.petstoredev.vo.CartItemVO;
import org.csu.petstoredev.vo.CartVO;
import org.csu.petstoredev.vo.MissingItems;
import org.csu.petstoredev.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    CartStoreMapper cartStoreMapper;
    @Autowired
    ItemOrderMapper itemOrderMapper;
    @Autowired
    InventoryMapper inventoryMapper;

    @Override
    public MissingItems submitOrder(HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        System.out.println("sdascsacasqwadwasc");

        MissingItems missingItems = new MissingItems();
        missingItems.setItemNames(new ArrayList<>());

        Random random = new Random();
        int code = random.nextInt(900000);
        while(itemOrderMapper.existItemOrder(code)) {
            code = random.nextInt(900000);
        }
        code += 100000;
        Date now = new Date();
        CartVO cart = (CartVO) session.getAttribute("cart");
        for(CartItemVO cartItemVO : cart.getCartItems()) {

            Inventory inventory = inventoryMapper.getInventoryByItemId(cartItemVO.getItem().getItemId())[0];

            if (inventory.getQty() >= cartItemVO.getQuantity()) {
            ItemOrder itemOrder = new ItemOrder();
            itemOrder.setCode(Integer.toString(code));
            itemOrder.setUserName(user.getUsername());
            itemOrder.setStatus(0);
            itemOrder.setIsDelete(0);
            itemOrder.setAddTime(now);
            itemOrder.setItemId(cartItemVO.getItem().getItemId());
            itemOrder.setTotal(cartItemVO.getQuantity());

            int rest = inventory.getQty() - cartItemVO.getQuantity();
            System.out.println(rest);
            inventoryMapper.updateQty(inventory.getItemId(), rest);

            itemOrderMapper.insert(itemOrder);
            }
            else {
                missingItems.setHas(true);

                missingItems.getItemNames().add(cartItemVO.getItem().getItemId());
                System.out.println("okkkkkkkkk");
            }

        }
        session.removeAttribute("cart");
        cartStoreMapper.clearCartStoreByUsername(user.getUsername());
        return missingItems;
    }
}
