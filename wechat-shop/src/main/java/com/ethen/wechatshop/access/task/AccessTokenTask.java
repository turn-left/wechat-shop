package com.ethen.wechatshop.access.task;

import com.ethen.wechatshop.access.vo.AccessToken;
import com.ethen.wechatshop.common.CacheUtil;
import com.ethen.wechatshop.common.CommonConstant;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccessTokenTask {


    /**
     * 用于获取access_token
     * <P>
     * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token
     * 开发者需要妥善保存access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，
     * 需定时刷新，重复获取将导致上次获取的access_token失效。并且每天调用获取access_token接口的上限是2000次。
     *</P>
     * @return
     *
     * test每10min取一次 access_token
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    public void accessToken(){
        System.err.println( "start get access_token...");
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
            String appID = "wxea25ba5a50aed4a5";
            String appsecret = "5be9a0da7fe56fa8307cd736bc1ed252";

            RestTemplate restTemplate = new RestTemplate();
            AccessToken accessToken =
                    restTemplate.getForObject(url.replace("APPID",appID).replace("APPSECRET",appsecret), AccessToken.class);
            //todo 待接入 redis
            System.out.println("accessToken: " + accessToken);
            CacheUtil.put(CommonConstant.ACCESS_TOKEN,accessToken.getAccess_token());
        } catch (Exception e){
            e.printStackTrace();
        }


    }

}
