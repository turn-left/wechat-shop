package com.ethen.wechatshop.cms.vo;

import java.util.Date;

/**
 * 评论（留言）
 */
public class Comment {
//    EC_ID          NUMBER(10) not null,
//    EC_CONTENT     VARCHAR2(200) not null,
//    EC_CREATE_TIME DATE not null,
//    EC_REPLY       VARCHAR2(200),
//    EC_REPLY_TIME  DATE,
//    EC_NICK_NAME   VARCHAR2(10) not null

    private Integer commentId;
    private String content;
    private Date createTime;
    private String reply;
    private Date replyTime;
    private String nickName;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", reply='" + reply + '\'' +
                ", replyTime=" + replyTime +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
