package com.ethen.wechatshop.common;

public class PageInfo {
    //总记录数
    private int total;
    //当前页
    private int curPage;
    //总页数
    private int totalPage;
    //每页记录数
    private int pageSize;

    public PageInfo() {
    }

    //默认每页10条
    public PageInfo(int total, int curPage) {
        this.total = total;
        this.curPage = curPage;
        this.pageSize = 10;
        this.totalPage = (total - 1) / 10 + 1;
    }


    public PageInfo(int total, int curPage, int pageSize) {
        this.total = total;
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.totalPage = (total - 1) / pageSize + 1;
    }


    public int getTotal() {

        return total;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
