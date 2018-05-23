package com.ethen.wechatshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration("props")
@PropertySource("classpath:datasource.properties")
public class DatasourceProps {

    /*************************** mysql *************************/
    @Value("${spring.datasource.mysql.url}")
    private String mysqlUrl;
    @Value("${spring.datasource.mysql.username}")
    private String mysqlUser;
    @Value("${spring.datasource.mysql.password}")
    private String mysqlPwd;
    @Value("${spring.datasource.mysql.driver-class-name}")
    private String mysqlDriver;

    /************************** oracle *************************/
    @Value("${spring.datasource.oracle.url}")
    private String oracleUrl;
    @Value("${spring.datasource.oracle.username}")
    private String oracleUser;
    @Value("${spring.datasource.oracle.password}")
    private String oraclePwd;
    @Value("${spring.datasource.oracle.driver-class-name}")
    private String oracleDriver;
    
    /************************** common *************************/
    @Value("${spring.datasource.minIdle}")
    private String minIdle;
    @Value("${spring.datasource.maxActive}")
    private String maxActive;
    @Value("${spring.datasource.maxWait}")
    private String maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private String timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private String minEvictableIdleTimeMillis;

    public String getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(String minIdle) {
        this.minIdle = minIdle;
    }

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

    public String getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(String maxWait) {
        this.maxWait = maxWait;
    }

    public String getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public String getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getMysqlUrl() {
        return mysqlUrl;
    }

    public void setMysqlUrl(String mysqlUrl) {
        this.mysqlUrl = mysqlUrl;
    }

    public String getMysqlUser() {
        return mysqlUser;
    }

    public void setMysqlUser(String mysqlUser) {
        this.mysqlUser = mysqlUser;
    }

    public String getMysqlPwd() {
        return mysqlPwd;
    }

    public void setMysqlPwd(String mysqlPwd) {
        this.mysqlPwd = mysqlPwd;
    }

    public String getMysqlDriver() {
        return mysqlDriver;
    }

    public void setMysqlDriver(String mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public String getOracleUrl() {
        return oracleUrl;
    }

    public void setOracleUrl(String oracleUrl) {
        this.oracleUrl = oracleUrl;
    }

    public String getOracleUser() {
        return oracleUser;
    }

    public void setOracleUser(String oracleUser) {
        this.oracleUser = oracleUser;
    }

    public String getOraclePwd() {
        return oraclePwd;
    }

    public void setOraclePwd(String oraclePwd) {
        this.oraclePwd = oraclePwd;
    }

    public String getOracleDriver() {
        return oracleDriver;
    }

    public void setOracleDriver(String oracleDriver) {
        this.oracleDriver = oracleDriver;
    }
}
