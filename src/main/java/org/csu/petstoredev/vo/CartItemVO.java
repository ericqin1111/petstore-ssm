package org.csu.petstoredev.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemVO {
    private ItemVO item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;
}
