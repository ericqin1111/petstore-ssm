package org.csu.petstoredev.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.entity.Item;
import org.csu.petstoredev.vo.CartVO;
import org.csu.petstoredev.vo.ItemVO;

public interface CartService {
    CartVO getCart();
    void addItem(String itemId, HttpSession session);
    void deleteItem(String itemId, HttpSession session);
    void updateItem(HttpServletRequest request);
    void loadCart(HttpServletRequest httpServletRequest);

}
