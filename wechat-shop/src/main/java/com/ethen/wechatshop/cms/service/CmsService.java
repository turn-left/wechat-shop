package com.ethen.wechatshop.cms.service;

import java.util.Map;

public interface CmsService {


    Map<String, Object> findNewsList(Object... params) ;

    Map<String, Object> findProductList(Object... params);

    Map<String, Object> findCommentList(Object... params);

    Map<String,Object> findProductClassList(Object... params);
}
