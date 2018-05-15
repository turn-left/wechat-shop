package com.ethen.wechatshop.cms.service;

import com.ethen.wechatshop.portal.vo.User;

import java.util.List;

public interface UserService {

    List<User> findAll(Object... params);

    int findTotalCount(Object... params);

}
