package com.ethen.wechatshop.portal.service;

import com.ethen.wechatshop.portal.vo.User;

public interface LoginService {

    public User login(String userName, String password);

    }
