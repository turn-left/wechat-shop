package com.ethen.wechatshop.access.task;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@PropertySource("classpath:task.properties")
//@Component
public class TestTask {

    @Scheduled(cron = "${test.task.cron}")
    public void task(){
        System.err.println("************  定时任务 start **********");
    }

}
