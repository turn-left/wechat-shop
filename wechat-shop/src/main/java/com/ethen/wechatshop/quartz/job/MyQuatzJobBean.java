package com.ethen.wechatshop.quartz.job;

import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;


@PersistJobDataAfterExecution
//@DisallowConcurrentExecution    //不允许并发执行
public class MyQuatzJobBean extends QuartzJobBean {


    /**
     * Execute the actual job. The job data map will already have been
     * applied as bean property values by execute. The contract is
     * exactly the same as for the standard Quartz execute method.
     *
     * @param context
     * @see #execute
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        MyJob simpleService = getApplicationContext(context).getBean("simpleService",MyJob.class);
        simpleService.doJob();//执行业务逻辑
    }


    private ApplicationContext getApplicationContext(final JobExecutionContext jobExecutioncontext) {
        try {
            return (ApplicationContext) jobExecutioncontext.getScheduler().getContext().get("applicationContextKey");
        } catch (SchedulerException e) {
            System.out.println("jobexecutioncontext.getScheduler().getContext() error!");
            throw new RuntimeException(e);
        }
    }
}
