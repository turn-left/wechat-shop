package com.ethen.wechatshop.cms.vo;

import java.util.Date;

/**
 * 新闻
 */
public class News {
//    EN_ID          NUMBER(10) not null,
//    EN_TITLE       VARCHAR2(40) not null,
//    EN_CONTENT     VARCHAR2(1000) not null,
//    EN_CREATE_TIME DATE not null
    private Integer newsId;
    private String title;
    private String content;
    private Date createTime;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
