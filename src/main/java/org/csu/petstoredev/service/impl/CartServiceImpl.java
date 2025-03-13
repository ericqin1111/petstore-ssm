package org.csu.petstoredev.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.entity.CartStore;
import org.csu.petstoredev.entity.Item;
import org.csu.petstoredev.persistence.CartStoreMapper;
import org.csu.petstoredev.persistence.ItemMapper;
import org.csu.petstoredev.service.CartService;
import org.csu.petstoredev.service.CatalogService;
import org.csu.petstoredev.vo.CartItemVO;
import org.csu.petstoredev.vo.CartVO;
import org.csu.petstoredev.vo.ItemVO;
import org.csu.petstoredev.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("CartService")
public class CartServiceImpl implements CartService {

    @Autowired
    ItemMapper itemMapper;
    @Autowired
    CartStoreMapper cartStoreMapper;



    @Override
    public CartVO getCart() {
        CartVO cart = new CartVO();
        return cart;
    }

    @Override
    public void addItem(String itemId, HttpSession session) {
        CartVO cart = (CartVO) session.getAttribute("cart");
        CartItemVO cartItem = cart.getItemMap().get(itemId);
        UserVO user = (UserVO) session.getAttribute("user");
        if (cartItem == null) {
            ItemVO item = itemMapper.getItemById(itemId);
            cart.addItem(item, true);

            cartStoreMapper.insertCartStore(user.getUsername(), itemId, 1);
        }
        else {
            cartItem.incrementQuantity();
            cartStoreMapper.increaseCartStoreQuantity(user.getUsername(), itemId);
        }
    }

    @Override
    public void deleteItem(String itemId, HttpSession session) {
        CartVO cart = (CartVO) session.getAttribute("cart");
        UserVO user = (UserVO) session.getAttribute("user");
        cart.removeItemById(itemId);
        cartStoreMapper.deleteCartStoreByUsernameAndItemId(user.getUsername(), itemId);
    }

    @Override
    public void updateItem(HttpServletRequest req) {

        HttpSession session = req.getSession();
        CartVO cart = (CartVO) session.getAttribute("cart");
        UserVO user = (UserVO) session.getAttribute("user");
        if (cart != null) {
            Iterator<CartItemVO> cartItems = cart.getAllCartItems();

            while (cartItems.hasNext()) {
                CartItemVO cartItem = (CartItemVO) cartItems.next();
                String itemId = cartItem.getItem().getItemId();
                try {
                    String quantityString = req.getParameter(itemId);
                    int quantity = Integer.parseInt(quantityString);

                    cart.setQuantityByItemId(itemId, quantity);
                    cartItem.calculateTotal();
                    cartStoreMapper.updateCartStoreQuantity(user.getUsername(), itemId, quantity);
                    if (quantity < 1) {
                        cartItems.remove();
                        cartStoreMapper.deleteCartStoreByUsernameAndItemId(user.getUsername(), itemId);

                    }
                } catch (Exception e) {
                    System.out.println("UpdateCartServlet: " + e.getMessage());
                    //ignore parse exceptions on purpose
                }
            }
        }
    }

    @Override
    public void loadCart(HttpServletRequest httpServletRequest) {

        UserVO user = (UserVO) httpServletRequest.getSession().getAttribute("user");
        HttpSession session = httpServletRequest.getSession();
        CartVO cart = (CartVO) session.getAttribute("cart");
        QueryWrapper<CartStore> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        List<CartStore> itemList= cartStoreMapper.selectList(queryWrapper);
        for (CartStore cartStore : itemList) {
            String itemId = cartStore.getItemId();
            ItemVO item = itemMapper.getItemById(itemId);
            cart.addItem(item, true);
        }
    }


}
