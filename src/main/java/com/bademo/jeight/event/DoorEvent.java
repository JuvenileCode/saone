package com.bademo.jeight.event;

import java.util.EventObject;

/**
 * @Description:定义事件对象，必须继承EventObject
 * @Author Bin.Liu
 * @Date 2018/10/18 15:18
 */
public class DoorEvent extends EventObject {

    String str;

    public DoorEvent(Object source, String str) {
        super(source);
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
