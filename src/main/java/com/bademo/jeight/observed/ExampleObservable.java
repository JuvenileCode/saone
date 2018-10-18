package com.bademo.jeight.observed;

import java.util.Observable;

/**
 * @Description 简单的被观察者类
 * @Author Bin.Liu
 * @Date 2018/10/17 17:21
 */
public class ExampleObservable extends Observable {
    int data = 0;

    public void setData(int data){
            this.data = data;
            this.setChanged(); //标记此 Observable对象为已改变的对象
            this.notifyObservers(); //通知所有的观察者
    }
}
