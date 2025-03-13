package org.csu.petstoredev.service.impl;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.vo.UserVO;
import org.csu.petstoredev.persistence.UserMapper;
import org.csu.petstoredev.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isUserExist(HttpSession session, String username, String password) {
        boolean exist=false;
        UserVO user=new UserVO();
        user=userMapper.selectByusrnameAndPsw(username,password);
        if(user!=null){
            exist=true;
            session.setAttribute("user",user);
        }

        return  exist;

    }


}
