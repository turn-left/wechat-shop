package com.ethen.wechatshop.access.service;

import com.ethen.wechatshop.access.vo.User;

public interface LoginService {

    public User login(String userName, String password);

    }
