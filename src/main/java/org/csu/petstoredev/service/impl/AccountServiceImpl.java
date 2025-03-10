package org.csu.petstoredev.service.impl;

import org.csu.petstoredev.form.User;
import org.csu.petstoredev.persistence.UserMapper;
import org.csu.petstoredev.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isUserExist(String username, String password) {
        boolean exist=false;
        User user=new User();
        user=userMapper.selectByusrnameAndPsw(username,password);
        if(user!=null){
            exist=true;
        }
        return  exist;

    }


}
