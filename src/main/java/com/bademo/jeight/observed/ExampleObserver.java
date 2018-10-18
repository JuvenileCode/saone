package com.bademo.jeight.observed;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description 观察者类
 * @Author Bin.Liu
 * @Date 2018/10/18 08:57
 */
public class ExampleObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ExampleObservable) {
            ExampleObservable example = (ExampleObservable)o;
            System.out.println("example.data changed, the new value of data is " + example.data);
        }
        if (o instanceof ObserverA) {
            System.out.println(o + " " + arg.toString());
        }
    }
}
