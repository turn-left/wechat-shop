package com.ethen.wechatshop.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本处理工具类
 */
public class TextUtil {
    private static final String CODE = "CODE";
    private static final String MSG = "MSG";
    private static final String DATA = "DATA";



    public static Map<String,Object> success(){
        return buildResult(ResponseEnum.SUCCESS,null);
    }


    public static Map<String,Object> success(Object data){
        return buildResult(ResponseEnum.SUCCESS,data);
    }


    public static Map<String,Object> fail(){
        return buildResult(ResponseEnum.FAIL,null);
    }




    /**
     * 构造响应结果
     * @param responseEnum
     * @param data
     * @return
     */
    public static Map<String,Object> buildResult(ResponseEnum responseEnum,Object data){
        Map<String,Object> result = new HashMap<>();
        result.put(CODE,responseEnum.getCode());
        result.put(MSG,responseEnum.getMessage());
        if (data != null){
            result.put(DATA,data);
        }
        return result;
    }





}
