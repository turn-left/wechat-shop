package com.ethen.wechatshop.portal.vo;

import java.util.Date;

/**
 * Description: 商城用户vo
 * Note: 区别后台CMS系统的用户
 */
public class AppUser {
    private long userId;
    private String loginId;//用户的唯一标识(手机号或者邮箱)
    private String nickName;
    private String loginPassword;
    private String salt;
    private String realName;
    private int sex;
    private int age;
    private String picImg;
    private int status;
    private String email;
    private int emailStatus;
    private String telephone;
    private Date regiserTime;
    private String receiveAddress;//收货地址
    private Date updateTime;
    private Date birthday;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(int emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getRegiserTime() {
        return regiserTime;
    }

    public void setRegiserTime(Date regiserTime) {
        this.regiserTime = regiserTime;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
//    CREATE TABLE `os_user` (
//        `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
//        `user_number` bigint(20) unsigned DEFAULT NULL COMMENT '用户编号',
//        `user_name` varchar(30) DEFAULT NULL COMMENT '昵称',
//        `login_password` varchar(32) DEFAULT NULL COMMENT '登录密码',
//        `salt` varchar(20) DEFAULT NULL COMMENT '加密密码的盐',
//        `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
//        `sex` tinyint(1) DEFAULT '0' COMMENT '性别 0=保密/1=男/2=女',
//        `age` tinyint(4) DEFAULT '0' COMMENT '年龄',
//        `pic_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
//        `status` tinyint(1) DEFAULT '1' COMMENT '状态 0=冻结/1=正常',
//        `email_is_active` tinyint(1) DEFAULT '0' COMMENT '邮箱激活 0=未激活/1=已激活',
//        `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
//        `telephone` varchar(11) DEFAULT NULL COMMENT '手机号码',
//        `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
//        `last_login_ip` varchar(20) DEFAULT NULL COMMENT '最后登录IP',
//        `login_number` bigint(20) DEFAULT '0' COMMENT '登录次数',
//        `regeist_time` datetime DEFAULT NULL COMMENT '注册时间',
//        `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
//        `update_time` datetime DEFAULT NULL COMMENT '更新时间',
//        `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
//        `amount` decimal(10,0) DEFAULT '0' COMMENT '消费额',
//        `rank_id` bigint(20) DEFAULT NULL COMMENT '会员等级ID',
//        `score` int(11) DEFAULT '0' COMMENT '会员积分',
//        PRIMARY KEY (`user_id`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='用户表';
//
