package com.juu.service;

import com.juu.exception.BusinessException;
import com.juu.param.LoginParam;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public Boolean login(LoginParam loginParam){
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        if (username == null || password == null) {
            throw new BusinessException("用户名或密码为空");
        }
        return username.equals("1234") && password.equals("5678");
    }
}
