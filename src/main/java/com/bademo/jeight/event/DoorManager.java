package com.bademo.jeight.event;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 事件源对象，在这里你可以把它想象成一个控制开门关门的遥控器
 * @Author Bin.Liu
 * @Date 2018/10/18 15:34
 */
public class DoorManager {

    Set<DoorListener> set = new HashSet<>();

    /**
     * 添加事件
     * @param listener
     */
    public void addDoorListener(DoorListener listener){
        set.add(listener);
    }

    public void removeDoorListener(DoorListener listener){
        set.remove(listener);
    }

    public void fireWorkspaceOpened(){
        DoorEvent event = new DoorEvent(this,"open");
        this.notifyListeners(event);
    }

    public void fireWorkspaceClosed(){
        DoorEvent event = new DoorEvent(this, "close");
        this.notifyListeners(event);
    }

    public void notifyListeners(DoorEvent event) {
        set.forEach(listener -> {
            listener.doorEvent(event);
        });
    }
}
