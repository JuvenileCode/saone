package com.bademo.equator;


import lombok.Data;

import java.util.Date;

@Data
public class WorkVO {

    private String id;

    private String appId;

    private String mpAppId;

    private String agentId;

    private String txtId;

    private String tplName;

    private String msgType;

    private String agentName;

    private String content;

    private String tplStatus;

    private Date createTime;

    private Date lastModify;
}
