package com.bademo.jeight.event;

/**
 * @Description
 * @Author Bin.Liu
 * @Date 2018/10/18 15:30
 */
public class DoorListener2 implements DoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        if (event.getStr() != null && event.getStr().equals("open")) {
            System.out.println("门2打开，同时打开走廊的灯");
        } else {
            System.out.println("门2关闭，同时关闭走廊的灯");
        }
    }
}
