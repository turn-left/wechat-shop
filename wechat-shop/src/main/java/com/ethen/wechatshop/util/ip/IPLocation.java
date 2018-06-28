package com.ethen.wechatshop.util.ip;

public class IPLocation {

    /**
     * 完全地址:省/市/区
     */
    private String country;

    /**
     * //使用的网络(运营商ISP)
     */
    private String isp;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIsp() {
        if ("CZ88.NET".equals(isp)) {
            isp = "";
        }
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public IPLocation() {
        isp = "";
        country = "";
    }

    public IPLocation getCopy() {
        IPLocation ret = new IPLocation();
        ret.country = country;
        ret.isp = isp;
        return ret;
    }
}