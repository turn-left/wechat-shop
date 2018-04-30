package com.ethen.wechatshop.common;

public enum ResponseEnum {

    SUCCESS("00","成功"),
    FAIL("01","网络不给力~");

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
