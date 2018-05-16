package com.ethen.wechatshop.cms.service.impl;

import com.ethen.wechatshop.cms.service.CmsService;
import com.ethen.wechatshop.cms.vo.News;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CmsServiceImpl implements CmsService {

    @Autowired
    SqlSessionTemplate sqlSession;


    public Map<String, Object> findNewsList(Object... params) {
        List<News> newsList = sqlSession.selectList("cms.findNewsList", params);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("newsList", newsList);
        return retMap;
    }

    public Map<String, Object> findProductList(Object... params) {
        List<News> productList = sqlSession.selectList("cms.findProductList", params);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("productList", productList);
        return retMap;
    }

    public Map<String, Object> findCommentList(Object... params) {
        List<News> commentList = sqlSession.selectList("cms.findCommentList", params);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("commentList", commentList);
        return retMap;
    }


    public Map<String, Object> findProductClassList(Object... params) {
        List<News> productClassList = sqlSession.selectList("cms.findProductClassList", params);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("productClassList", productClassList);
        return retMap;
    }

}
