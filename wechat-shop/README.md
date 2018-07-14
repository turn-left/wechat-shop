 1.v1.0版本的目标主要是从功能出发,逐步设计电商项目的各种业务模块,借鉴淘宝、京东等的设计 主要包括：portal模块,订单模块,购物车,支付模块,CMS模块...
 2.v2.0版本是希望使用spring-cloud进行微服务的改造，引入一些基础组件如: redis缓存,nginx负载均衡,kafka(rabbitMQ)消息,`elasticSearch`（`lucene`、`solr`）搜索, `jenkins`持续集成...

 3.技术选型: `springMVC`、`thymeleaf`、`bootstrap`、`spring-security`、 `mybatis`、`oracle`、`redis`、`MySQL`、`maven`、`git`...<br>
当然随着工程的演进,会主键加入分布式系统的基础组件,服务治理etc.

 4.部署流程： <br>
  * step1--clone工程到本地，推荐使用`IDEA`，数据库是`mysql` <br>
  * step2--推荐安装`redis`   <br>
  * step3--在mysql中创建数据库 morning,执行工程 resources/database/`table_data_mysql.sql`文件   <br>
  * step4--运行WechatShopApplication.java启动spring-boot工程。访问路径localhost(也可以修改WINDOWS的hosts文件改成自己的虚拟域名)  <br>
  



注:目前前端页面大多为网上下载的易买网工程，后期必定改造交互效果增强视觉效果！！
