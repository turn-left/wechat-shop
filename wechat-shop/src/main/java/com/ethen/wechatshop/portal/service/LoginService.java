package com.ethen.wechatshop.portal.service;

import com.ethen.wechatshop.cms.vo.CmsUser;

public interface LoginService {

    public CmsUser login(String userName, String password);

    }
