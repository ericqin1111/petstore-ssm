package org.csu.petstoredev.service;

public interface AccountService {


    boolean isUserExist(String username, String password);

    boolean isUsernameExist(String username);

    public void insertAccount(String username,String password);
}
