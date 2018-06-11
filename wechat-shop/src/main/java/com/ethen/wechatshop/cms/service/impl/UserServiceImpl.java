package com.ethen.wechatshop.cms.service.impl;

import com.ethen.wechatshop.cms.service.UserService;
import com.ethen.wechatshop.cms.vo.CmsUser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SqlSessionTemplate sqlSession;

    public List<CmsUser> findAll(Object... params) {
       return sqlSession.selectList("cms.findUserList",params);
    }

    @Override
    public int findTotalCount(Object... params) {
         Integer count = sqlSession.selectOne("cms.findTotalCount",params);

        return 0;
    }
}
