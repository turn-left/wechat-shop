package com.ethen.wechatshop.access.controller;

import com.ethen.wechatshop.common.CacheUtil;
import com.ethen.wechatshop.common.CommonConstant;
import com.ethen.wechatshop.common.TextUtil;
import com.ethen.wechatshop.util.MessageHandlerUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;


/**
 * @author ethen
 * @since 2018-04-22
 */
@RestController
public class AccessController {

    //token可由开发者可以任意填写，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）
    private static final String TOKEN = "ethen2018";

    /**
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     * @description 微信接入验证签名
     * 接收微信服务器发送请求时传递过来的4个参数
     */
    @RequestMapping(value = "/ethen-shop", method = RequestMethod.GET)
    public Object access(@RequestParam String signature, @RequestParam String timestamp,
                         @RequestParam String nonce, @RequestParam String echostr) {
        System.err.println("start verify signature...");
        //排序
        String sortString = sort(TOKEN, timestamp, nonce);
        //加密
        String mySignature = sha1(sortString);
        //校验签名
        if (mySignature != null && mySignature != "" && mySignature.equals(signature)) {
            System.err.println("verify signature success!");
            //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
            return echostr;
        } else {
            System.err.println("verify signature error ");
            return null;
        }
    }

    /**
     * @return
     * @description 处理用户在公众号端发送消息
     *
     * todo 考虑如何用spring+jackson做xml数据交互
     *
     */
    @RequestMapping(value = "/ethen-shop", method = RequestMethod.POST, produces = "application/xml")
    public void handleMessage(/*@RequestBody Message message*/ HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Message message = new Message();
//        message.setMsgType("text");
//        message.setToUserName("gh_c21ea0b33d2a");
//        message.setFromUserName("o6KVA1vMlbxJo0D39h9yPV3gqkts");
//        System.err.println("start receiving msg: " + message.toString());
//        if ("text".equals(message.getMsgType())) {
//            RspMessage rspMessage = new RspMessage();
//            rspMessage.setFromUserName(message.getFromUserName());
//            rspMessage.setToUserName(message.getToUserName());
//            rspMessage.setCreateTime(System.currentTimeMillis() / 1000);
//            rspMessage.setMsgType(message.getMsgType());
//            rspMessage.setContent()
        String content =    "后皇嘉树，橘徕服兮。受命不迁，生南国兮。\n" +
                            "深固难徙，更壹志兮。缘叶素荣，纷其可喜兮。\n" +
                            "曾枝剡棘，圆果抟兮。青黄杂糅，文章烂兮。\n" +
                            "精色内白，类可任兮。纷緼宜修，姱而不醜兮。\n" +
                            "嗟尔幼志，有以异兮。独立不迁，岂不可喜兮。\n" +
                            "深固难徙，廓其无求兮。苏世独立，横而不流兮。\n" +
                            "闭心自慎，为终失过兮。秉德无私，参天地兮。\n" +
                            "愿岁并谢，与长友兮。淑离不淫，梗其有理兮。\n" +
                            "年岁虽少，可师长兮。行比伯夷，置经为象兮。";
//            System.err.println("rspMessage: " + rspMessage);
//            return rspMessage;
//        }
//        return "success";


        // TODO 接收、处理、响应由微信服务器转发的用户发送给公众帐号的消息
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding(CommonConstant.UTF_8);
        response.setCharacterEncoding(CommonConstant.UTF_8);
        System.err.println("请求进入...");
        String result = "";
        try {
            Map<String, String> map = MessageHandlerUtil.parseXml(request);
            System.err.println("开始构造消息...");
            result = MessageHandlerUtil.buildXml(map,content);
            System.err.println(result);
            if (result.equals(CommonConstant.BLANK_STR)) {
                result = "未正确响应";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("发生异常: " + e.getMessage());
        }
        response.getWriter().println(result);
    }



    /**
     * 一个最简单的响应,返回 access_token
     */
    @RequestMapping("/accessToken")
    public Object accessToken() {
        System.err.println("************************** accessToken ***********************");

        String accessToken = CacheUtil.get(CommonConstant.ACCESS_TOKEN);

        return TextUtil.success(accessToken);
    }


    /**
     * 排序方法
     *
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * 将字符串进行sha1加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的内容
     */
    public String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
