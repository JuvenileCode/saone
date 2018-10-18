package com.bademo.jeight.event;

/**
 * @Description 事件测试类
 * @Author Bin.Liu
 * @Date 2018/10/18 15:44
 */
public class DoorMain {

    public static void main(String[] args) {
        DoorManager dm = new DoorManager();
        dm.addDoorListener(new DoorListener1());
        dm.addDoorListener(new DoorListener2());
        dm.fireWorkspaceOpened();
        System.out.println("-----我已经进来了-----");
        dm.fireWorkspaceClosed();

    }
}
