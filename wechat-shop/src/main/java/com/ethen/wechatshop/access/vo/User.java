package com.ethen.wechatshop.access.vo;

public class User {

    private Message message;

    public User(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
