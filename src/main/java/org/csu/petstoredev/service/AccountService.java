package org.csu.petstoredev.service;

import jakarta.servlet.http.HttpSession;

public interface AccountService {


    boolean isUserExist(HttpSession session, String username, String password);
}
