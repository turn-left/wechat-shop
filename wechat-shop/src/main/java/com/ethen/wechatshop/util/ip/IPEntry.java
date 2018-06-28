package com.ethen.wechatshop.util.ip;


public class IPEntry {
    public String beginIp;
    public String endIp;
    public String country;
    public String isp;

    public IPEntry() {
        beginIp = endIp = country = isp = "";
    }

    @Override
    public String toString() {
        return this.isp + " " + this.country + "IP范围:" + this.beginIp + "-" + this.endIp;
    }
}