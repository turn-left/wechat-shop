package com.ethen.wechatshop.portal.task;

import org.springframework.scheduling.annotation.Scheduled;

//@PropertySource("classpath:task.properties")
//@Component
public class TestTask {

    @Scheduled(cron = "${test.task.cron}")
    public void task(){
        System.err.println("************  定时任务 start **********");
    }

}
