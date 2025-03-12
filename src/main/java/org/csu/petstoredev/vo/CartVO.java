package org.csu.petstoredev.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Data
public class CartVO {
    private Map<String, CartItemVO> itemMap = Collections.synchronizedMap(new HashMap<String, CartItemVO>());
    private List<CartItemVO> cartItems = new ArrayList<CartItemVO>();
    private int numberOfItems;
    private BigDecimal subTotal;
}
