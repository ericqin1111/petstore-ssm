package org.csu.petstoredev.service;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.vo.MissingItems;

public interface OrderService {

    public MissingItems submitOrder(HttpSession session);
}
