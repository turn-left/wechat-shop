package com.ethen.wechatshop.cms.service;

import com.ethen.wechatshop.cms.vo.CmsUser;

import java.util.List;

public interface UserService {

    List<CmsUser> findAll(Object... params);

    int findTotalCount(Object... params);

}
