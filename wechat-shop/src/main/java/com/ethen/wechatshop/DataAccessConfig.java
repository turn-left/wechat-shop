package com.ethen.wechatshop;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import redis.clients.jedis.Transaction;

import javax.sql.DataSource;


/**
 * Description: 数据访问的配置 (多数据源)
 * <p>
 * Note: <p>配置多数据源的第一步工作是禁用SpringBoot自动配置
 * {@link SpringBootApplication#exclude()}
 * {@link DataSourceAutoConfiguration}
 * </p><p>
 * <code>@Primary</code>注解的作用,当同一个类型存在多个Bean的时候,
 * spring会默认注入以@Primary注解的bean
 * </p>
 * todo 待优化 DAO具体细节
 */
@Configuration
public class DataAccessConfig {

    @Autowired
    DatasourceProps props;

    /**
     * spring編程式事務->適用于MySQL數據源
     * @param dataSourceTransactionManager
     * @return
     */
    @Bean
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager dataSourceTransactionManager) {
        return new TransactionTemplate(dataSourceTransactionManager);
    }

    /**
     * spring編程式事務->適用于MySQL數據源
     * @param mysqlDataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource mysqlDataSource) {
        return new DataSourceTransactionManager(mysqlDataSource);
    }


    /***************************************************** mysql ******************************************************/
    /**
     * mysql数据源
     */
//    @Primary
    @Bean(name = "mysqlDataSource", initMethod = "init", destroyMethod = "close")
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

    /**************************************************** oracle ******************************************************/
    /**
     * oracle数据源
     */
    @Bean(name = "orclDataSource", initMethod = "init", destroyMethod = "close")
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


    //*默认值
    @Bean(name = "sqlSession")
    public SqlSessionTemplate sqlSessionTemplateDefault(SqlSessionFactory sqlSessionFactoryOrcl) {
        return new SqlSessionTemplate(sqlSessionFactoryOrcl);
    }

}
