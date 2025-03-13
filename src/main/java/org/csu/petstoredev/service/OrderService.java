package org.csu.petstoredev.service;

import jakarta.servlet.http.HttpSession;

public interface OrderService {

    public void submitOrder(HttpSession session);
}
