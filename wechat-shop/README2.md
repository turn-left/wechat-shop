1.v1.0版本的目标主要是从功能出发,逐步设计电商项目的各种业务模块,借鉴淘宝、京东等的设计 主要包括：portal模块,订单模块,购物车,支付模块,CMS模块...

2.v2.0版本是希望使用spring-cloud进行微服务的改造，引入一些基础组件如: redis缓存,nginx负载均衡,kafka(rabbitMQ)消息,elasticSearch（lucene、solr）搜索, jenkins持续集成...

3.技术选型: springMVC、thymeleaf、bootstrap、spring-security mybatis、oracle、redis、MySQL、maven、git...

4.部署流程：
  step1--clone工程到本地，推荐使用IDEA，数据库是mysql
  step2--推荐安装redis
  step3--在mysql中创建数据库 <i>morning</i>,执行工程 resources/database/table_data_mysql.sql文件
  step4--运行WechatShopApplication.java启动spring-boot工程。访问路径localhost(也可以修改WINDOWS的hosts文件改成自己的虚拟域名)
