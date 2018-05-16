package com.ethen.wechatshop.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单类
 * todo 后期须改进 订单号 账户
 */
public class Order implements Serializable {

    private int orderId;
    private String userId;
    private String userName;
    private String address;
    private Date createTime;
    private double cost;
    private int orderStatus;
    private int orderType;

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", cost=" + cost +
                ", orderStatus=" + orderStatus +
                ", orderType=" + orderType +
                '}';
    }
}
