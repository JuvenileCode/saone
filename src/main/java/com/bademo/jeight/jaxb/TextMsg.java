package com.bademo.jeight.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 接收普通消息（文本消息）
 * @Author Bin.Liu
 * @Date 2018/10/26 13:54
 */
@XmlRootElement(name="xml")
public class TextMsg {

    private String toUserName;

    private String fromUserName;

    private Long createTime;

    private String msgType;

    private String content;

    private Long msgId;

    public String getToUserName() {
        return toUserName;
    }

    @XmlElement(name ="ToUserName")
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    @XmlElement(name ="FromUserName")
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    @XmlElement(name ="CreateTime")
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    @XmlElement(name ="MsgType")
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    @XmlElement(name ="Content")
    public void setContent(String content) {
        this.content = content;
    }

    public Long getMsgId() {
        return msgId;
    }

    @XmlElement(name ="MsgId")
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "TextMsg{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                ", msgId=" + msgId +
                '}';
    }
}
