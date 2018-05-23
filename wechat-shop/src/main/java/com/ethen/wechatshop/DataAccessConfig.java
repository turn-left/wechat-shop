package com.ethen.wechatshop;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * 数据访问的配置 (多数据源)
 *
 *
 *
 * todo 待优化 DAO的逻辑
 */
@Configuration
public class DataAccessConfig {

    @Autowired
    DatasourceProps props;


    //mysql数据源
    @Primary
    @Bean(name = "mysqlDataSource",initMethod = "init", destroyMethod = "close")
    public DataSource mysqlDataSource() {
        //配置数据库的参数
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(props.getMysqlDriver());
        druidDataSource.setUrl(props.getMysqlUrl());
        druidDataSource.setUsername(props.getMysqlUser());
        druidDataSource.setPassword(props.getMysqlPwd());
        druidDataSource.setMinIdle(Integer.parseInt(props.getMinIdle()));
        druidDataSource.setMaxActive(Integer.parseInt(props.getMaxActive()));
        druidDataSource.setMaxWait(Integer.parseInt(props.getMaxWait()));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(props.getTimeBetweenEvictionRunsMillis()));
        druidDataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(props.getMinEvictableIdleTimeMillis()));
        return druidDataSource;
    }

    @Bean(name = "orclDataSource",initMethod = "init",destroyMethod = "close")
    public DataSource oracleDataSource() {
        //配置数据库的参数
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(props.getOracleDriver());
        druidDataSource.setUrl(props.getOracleUrl());
        druidDataSource.setUsername(props.getOracleUser());
        druidDataSource.setPassword(props.getOraclePwd());
        druidDataSource.setMinIdle(Integer.parseInt(props.getMinIdle()));
        druidDataSource.setMaxActive(Integer.parseInt(props.getMaxActive()));
        druidDataSource.setMaxWait(Integer.parseInt(props.getMaxWait()));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(props.getTimeBetweenEvictionRunsMillis()));
        druidDataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(props.getMinEvictableIdleTimeMillis()));
        return druidDataSource;
    }


    @Bean(name = "sqlSessionFactoryMysql")
    public SqlSessionFactory sqlSessionFactoryMysql(DataSource mysqlDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(mysqlDataSource);
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }


    @Bean(name = "mysqlSession")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactoryMysql) {
        SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactoryMysql);
        return sqlSession;
    }



    @Bean(name = "sqlSessionFactoryOrcl")
    public SqlSessionFactory sqlSessionFactoryOrcl(DataSource orclDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(orclDataSource);
        System.out.println();
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }


    @Bean(name = "orclSession")
    public SqlSessionTemplate sqlSessionTemplateOrcl(SqlSessionFactory sqlSessionFactoryOrcl) {
        SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactoryOrcl);
        return sqlSession;
    }

    @Bean(name = "sqlSession")
    public SqlSessionTemplate sqlSessionTemplateDefault(SqlSessionFactory sqlSessionFactoryOrcl) {
        return new SqlSessionTemplate(sqlSessionFactoryOrcl);
    }


}
