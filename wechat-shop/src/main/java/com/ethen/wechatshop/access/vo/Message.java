//package com.ethen.wechatshop.access.vo;
//
//
//
///**
// * @description 用户被动回复消息,微信公众平台使用XML格式交互数据
// * <p>
// * MsgId            消息id，64位整型
// * ToUserName	是	接收方帐号（收到的OpenID）
// * FromUserName	是	开发者微信号
// * CreateTime	是	消息创建时间 （整型）
// * MsgType	    是	text
// * Content	    是	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
// * </p>
// */
////@JacksonXmlRootElement
//public class Message {
//
//
//    private long msgId;
//
//    private String toUserName;
//
//    private String fromUserName;
//
//    private long createTime;
//
//    private String msgType;
//
//    private String content;
//
//    public Message() {
//    }
//
//    public long getMsgId() {
//        return msgId;
//    }
//
//    @JacksonXmlProperty(localName = "MsgId")
//    public void setMsgId(long msgId) {
//        this.msgId = msgId;
//    }
//
//    @JacksonXmlProperty(localName = "ToUserName")
//    public String getToUserName() {
//        return toUserName;
//    }
//
//    public void setToUserName(String toUserName) {
//        this.toUserName = toUserName;
//    }
//
//    @JacksonXmlProperty(localName = "FromUserName")
//    public String getFromUserName() {
//        return fromUserName;
//    }
//
//    public void setFromUserName(String fromUserName) {
//        this.fromUserName = fromUserName;
//    }
//
//    @JacksonXmlProperty(localName = "CreateTime")
//    public long getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(long createTime) {
//        this.createTime = createTime;
//    }
//
//    @JacksonXmlProperty(localName = "MsgType")
//    public String getMsgType() {
//        return msgType;
//    }
//
//    public void setMsgType(String msgType) {
//        this.msgType = msgType;
//    }
//
//    @JacksonXmlProperty(localName = "Content")
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "Message{" +
//                "toUserName='" + toUserName + '\'' +
//                ", fromUserName='" + fromUserName + '\'' +
//                ", createTime='" + createTime + '\'' +
//                ", msgType='" + msgType + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
//
//
//}
