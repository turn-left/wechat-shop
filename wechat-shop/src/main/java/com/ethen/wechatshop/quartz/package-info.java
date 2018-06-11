package com.ethen.wechatshop.quartz;

//Quartz 中集群如何工作 :
//    一个 Quartz 集群中的每个节点是一个独立的 Quartz 应用，它又管理着其他的节点。
//    意思是你必须对每个节点分别启动或停止。不像许多应用服务器的集群，独立的 Quartz
//    节点并不与另一其的节点或是管理节点通信。Quartz 应用是通过数据库表来感知到另一应用的。

//图quartz.jpg：表示了每个节点直接与数据库通信，若离开数据库将对其他节点一无所知



/**
 * Description: fixme 基于Spring的集群配置
 * Note: Quartz的集群部署方案在架构上是分布式的，没有负责集中管理的节点，
 * 而是利用数据库锁的方式来实现集群环境下进行并发控制。BTW，分布式部署时
 * 需要保证各个节点的系统时间一致。(生产时钟问题!)
 */

//<!-- 调度工厂 -->
//<bean id="quartzScheduler"
//class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
//<property name="dataSource" ref="dataSource" />
//<property name="quartzProperties">
//<props>
//<prop key="org.quartz.scheduler.instanceName">CRMscheduler</prop>
//<prop key="org.quartz.scheduler.instanceId">AUTO</prop>
//<!-- 线程池配置 -->
//<prop key="org.quartz.threadPool.class">org.quartz.simpl.SimpleThreadPool</prop>
//<prop key="org.quartz.threadPool.threadCount">20</prop>
//<prop key="org.quartz.threadPool.threadPriority">5</prop>
//<!-- JobStore 配置 -->
//<prop key="org.quartz.jobStore.class">org.quartz.impl.jdbcjobstore.JobStoreTX</prop>

//<!-- 集群配置 -->
//<prop key="org.quartz.jobStore.isClustered">true</prop>
//<prop key="org.quartz.jobStore.clusterCheckinInterval">15000</prop>
//<prop key="org.quartz.jobStore.maxMisfiresToHandleAtATime">1</prop>
//
//<prop key="org.quartz.jobStore.misfireThreshold">120000</prop>
//
//<prop key="org.quartz.jobStore.tablePrefix">QRTZ_</prop>
//</props>
//
//</property>
//
//<property name="schedulerName" value="CRMscheduler" />
//
//<!--必须的，QuartzScheduler 延时启动，应用启动完后 QuartzScheduler 再启动 -->
//<property name="startupDelay" value="30" />
//
//<property name="applicationContextSchedulerContextKey" value="applicationContextKey" />
//
//<!--可选，QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了 -->
//<property name="overwriteExistingJobs" value="true" />
//<!-- 设置自动启动 -->
//<property name="autoStartup" value="true" />
//
//<!-- 注册触发器 -->
//<property name="triggers">
//<list>
//<ref bean="userSyncScannerTrigger" />
//        ......
//</list>
//</property>
//
//<!-- 注册jobDetail -->
//<property name="jobDetails">
//<list>
//</list>
//</property>
//
//<property name="schedulerListeners">
//<list>
//<ref bean="quartzExceptionSchedulerListener" />
//</list>
//</property>
//</bean>




//* Note: quartz是通过 database 来进行分布式管理的

// Quartz集群中的每个节点是一个独立的Quartz应用，它又管理着其他的节点。
// 该集群需要分别对每个节点分别启动或停止，不像应用服务器的集群，独立的
// Quartz节点并不与另一个节点或是管理节点通信。Quartz应用是通过数据库表
// 来感知到另一应用。只有使用持久的JobStore才能完成Quqrtz集群。


// org.quartz.jobStore.class属性为JobStoreTX，将任务持久化到数据中。
// 因为集群中节点依赖于数据库来传播Scheduler实例的状态，你只能在使用JDBC JobStore时应用Quartz集群。
//
// org.quartz.jobStore.isClustered属性为true，通知Scheduler实例要它参与到一个集群当中。
//
// org.quartz.jobStore.clusterCheckinInterval属性定义了Scheduler实例检入到数据库中的频率(单位：毫秒)。
// Scheduler检查是否其他的实例到了它们应当检入的时候未检入；这能指出一个失败的Scheduler实例，且当前
// Scheduler会以此来接管任何执行失败并可恢复的Job。通过检入操作，Scheduler 也会更新自身的状态记录。
// clusterChedkinInterval越小，Scheduler节点检查失败的Scheduler实例就越频繁。默认值是 15000 (即15 秒)。
