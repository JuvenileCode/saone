package com.bademo.jeight.event;

import java.util.EventListener;

/**
 * @Description:定义监听接口，负责监听DoorEvent事件
 * @Author Bin.Liu
 * @Date 2018/10/18 15:20
 */
public interface DoorListener extends EventListener {
    public void doorEvent(DoorEvent event);
}
