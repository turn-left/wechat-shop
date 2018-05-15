package com.ethen.wechatshop;

import com.ethen.wechatshop.common.service.RedisService;
import com.ethen.wechatshop.util.RedisClient;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;

@EnableScheduling
@SpringBootApplication
public class WechatShopApplication implements CommandLineRunner {


	@Autowired
	SqlSessionTemplate sqlSession;

	@Autowired
	RedisService redisService;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;


	@Autowired
	RedisClient redisClient;


	public static void main(String[] args) {
		SpringApplication.run(WechatShopApplication.class, args);
	}

	/**
	 *
	 * 这里的实现CommandLineRunner接口，run方法是为了验证我们用了什么数据源，
	 * 比如如果application.properties里没有配置如下信息：
	 * 	spring.datasource.type=com.alibaba.druid.pool.DruidDataSource，
	 * 	那么springboot默认给配置的是tomcat的jdbc，打印如下信息（部分信息）
	 * DATASOURCE = org.apache.tomcat.jdbc.pool.DataSource@839803e{ConnectionPool[defaultAutoCommit=null
	 */
	@Override
	public void run(String... args) throws Exception {
		//获取的是本地的IP地址
		InetAddress address = InetAddress.getLocalHost();
		String hostIp = address.getHostAddress();
		System.err.println("当前服务器ip: " + hostIp);

	}
}
