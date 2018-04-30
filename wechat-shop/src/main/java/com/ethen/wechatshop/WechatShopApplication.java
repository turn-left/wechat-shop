package com.ethen.wechatshop;

import com.ethen.wechatshop.common.service.RedisService;
import com.ethen.wechatshop.util.RedisClient;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

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

		List<Map<String,Object>> list = sqlSessionTemplate.selectList("test_select");
		System.out.println("list: " + list);
		redisService.set("test_001","一个redis value.");
		redisService.set("test_002","redis value test_002");
		System.err.println("test_001: " + redisService.get("test_001"));
		System.err.println("test_002: " + redisService.get("test_002"));


		redisClient.set("test-key-0428","hello redis!i am coming!",20);
		String value  = redisClient.get("test-key-0428");
		System.err.println("get redis value: " + value);

	}
}
