package com.ethen.wechatshop.quartz.job;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service("simpleService")
public class MyJob {


    public void doJob() {
        //*这里执行真正的定时任务逻辑
//        for (long i = 0L; i < 2_000_000_000L; i++) {
//            String str = "";
//            if (i % 300_000_000 == 0) {
//                str += "_" + i;     //模拟耗时操作
//            }
//        }

        System.err.println("MyJob is running... now: " +
                DateTime.now().toLocalDateTime().toString());
    }

}
