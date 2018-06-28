package com.ethen.wechatshop.quartz.job;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service("simpleService")
public class MyJob {


    public void doJob() throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        String hostAddr = localhost.getHostAddress();
        String hostName = localhost.getHostName();
        System.err.println("MyJob is running... now: " + DateTime.now().toLocalDateTime().toString());
        System.err.println("hostName: " + hostName + ",hostAddr: " + hostAddr);

    }

}
