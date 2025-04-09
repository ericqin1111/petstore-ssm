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

    public boolean containsItemId(String itemId) {
        return itemMap.containsKey(itemId);
    }

    public void addItem(ItemVO item, boolean isInStock) {

            CartItemVO cartItem = new CartItemVO();
            cartItem.setItem(item);
            cartItem.setQuantity(0);
            cartItem.setInStock(isInStock);
            itemMap.put(item.getItemId(), cartItem);
            cartItems.add(cartItem);
            numberOfItems++;
            cartItem.incrementQuantity();


    }

    public void addItem(ItemVO item, int quantity, boolean isInStock) {

        CartItemVO cartItem = new CartItemVO();
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);
        cartItem.setInStock(isInStock);
        itemMap.put(item.getItemId(), cartItem);
        cartItems.add(cartItem);
        numberOfItems++;


    }

    public ItemVO removeItemById(String itemId) {
        CartItemVO cartItem = (CartItemVO) itemMap.remove(itemId);
        if (cartItem == null) {
            return null;
        } else {
            cartItems.remove(cartItem);
            numberOfItems--;
            return cartItem.getItem();
        }
    }

    public void incrementQuantityByItemId(String itemId) {
        CartItemVO cartItem = (CartItemVO) itemMap.get(itemId);
        cartItem.incrementQuantity();
    }

    public void setQuantityByItemId(String itemId, int quantity) {
        CartItemVO cartItem = (CartItemVO) itemMap.get(itemId);
        cartItem.setQuantity(quantity);
    }

    public Iterator<CartItemVO> getAllCartItems() {
        return cartItems.iterator();
    }

    public BigDecimal getSubTotal() {
        BigDecimal subTotal = new BigDecimal("0");
        Iterator<CartItemVO> items = getAllCartItems();
        while (items.hasNext()) {
            CartItemVO cartItem = (CartItemVO) items.next();
            ItemVO item = cartItem.getItem();
            BigDecimal listPrice = item.getListPrice();
            BigDecimal quantity = new BigDecimal(String.valueOf(cartItem.getQuantity()));
            subTotal = subTotal.add(listPrice.multiply(quantity));
        }
        return subTotal;
    }
}
