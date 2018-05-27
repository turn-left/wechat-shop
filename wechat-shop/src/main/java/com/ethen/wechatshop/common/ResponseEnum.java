package com.ethen.wechatshop.common;

public enum ResponseEnum {

    SUCCESS("00","成功"),
    FAIL("01","网络不给力~"),
    HTTP_OK("200","OK"),
    HTTP_NF("404","Not found"),
    HTTP_BR("400","Bad request"),
    HTTP_FBD("403","Forbidden"),
    HTTP_UA("403","Unauthorized"),
    HTTP_ERR("500","Server internal error"),
    CREDENTAIL_ERROR("02","用户名或密码错误~");

    private String code;
    private String message;



    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
