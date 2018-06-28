package com.ethen.wechatshop.quartz.web;

import com.ethen.wechatshop.quartz.service.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    QuartzManager quartzManager;


    @RequestMapping("/modifyJob")
    public Object modifyJob(String jobName, String jobGroupName, String triggerName,
                          String triggerGroupName, String cron) {
        quartzManager.modifyJobTime(jobName,jobGroupName,triggerName,triggerGroupName,cron);
        return "/quartz/quartz";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object quartz() {
        return "/quartz/quartz";
    }
}
