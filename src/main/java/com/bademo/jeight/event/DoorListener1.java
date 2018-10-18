package com.bademo.jeight.event;

/**
 * @Description 监听接口的实现
 * @Author Bin.Liu
 * @Date 2018/10/18 15:27
 */
public class DoorListener1 implements DoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        if (event.getStr() != null && event.getStr().equals("open")) {
            System.out.println("门1打开");
        } else {
            System.out.println("门1关闭");
        }
    }
}
