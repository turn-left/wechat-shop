package com.ethen.wechatshop.quartz;

import com.ethen.wechatshop.quartz.job.MyQuatzJobBean;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

//@Configuration
public class BeanHolder {

    @Bean
    public SchedulerFactoryBean scheduler(DataSource mysqlDataSource,Trigger trigger) {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setDataSource(mysqlDataSource);
        scheduler.setApplicationContextSchedulerContextKey("applicationContextKey");
        scheduler.setTriggers(trigger);
        Resource resource = new ClassPathResource("quartz.properties");
        scheduler.setConfigLocation(resource);
        return scheduler;
    }


    @Bean(name = "jobDetail")
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setJobClass(MyQuatzJobBean.class);
        jobDetail.setDurability(true);
        jobDetail.setRequestsRecovery(true);
        return jobDetail;
    }

    // fixme jobDetail 此处 jobDetail 以 JobDetailFactoryBean 注入不了
    @Bean
    public CronTriggerFactoryBean trigger(JobDetail jobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetail);
        trigger.setCronExpression("0/10 * * * * ?");
        return trigger;
    }




}
