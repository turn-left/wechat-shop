package com.ethen.wechatshop.portal.service.impl;

import com.ethen.wechatshop.cms.vo.CmsUser;
import com.ethen.wechatshop.portal.service.LoginService;
import com.ethen.wechatshop.util.RedisClient;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    RedisClient redisClient;

    @Autowired
    SqlSessionTemplate sqlSession;

    public CmsUser login(String userName, String password) {

        try {
            //先从redis中取
//            String userJson = redisClient.get("login:" + userName);
//            if (!StringUtils.isEmpty(userJson)) {
//                return new ObjectMapper().readValue(userJson, CmsUser.class);
//            } else {
            Map<String, String> params = new HashMap<>();
            params.put("userName", userName);
            params.put("password", password);
            CmsUser userInfo = sqlSession.selectOne("user.selectUserInfo", params);

            //登录成功,将用户信息保存在redis中
//            if (userInfo != null && !StringUtils.isEmpty(userInfo.getUserName())) {
//                String userJsonNew = new ObjectMapper().writeValueAsString(userInfo);
//                //缓存用户信息到redis
//                redisClient.set("login:" + userInfo.getUserName(), userJsonNew, 60 * 60 * 24);
//            }

            return userInfo;
//            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    private String redisKeyGen() {
        return null;
    }
}
