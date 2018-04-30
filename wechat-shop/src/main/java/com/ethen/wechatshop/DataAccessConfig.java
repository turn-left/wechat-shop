package com.ethen.wechatshop;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 数据访问的配置 todo 待优化 DAO的逻辑
 */
@Configuration
public class DataAccessConfig {

    public static final String SQL_SESSION = "sqlSession";

    @Bean(SQL_SESSION)
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
