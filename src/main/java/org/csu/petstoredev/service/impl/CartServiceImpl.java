package org.csu.petstoredev.service.impl;

import org.csu.petstoredev.service.CartService;
import org.csu.petstoredev.vo.CartVO;
import org.springframework.stereotype.Service;

@Service("CartService")
public class CartServiceImpl implements CartService {

    @Override
    public CartVO getCart() {
        CartVO cart = new CartVO();
        return cart;
    }
}
