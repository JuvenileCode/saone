package com.bademo.jeight.observed;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 既是观察者又是被观察者
 * @Author Bin.Liu
 * @Date 2018/10/18 09:17
 */
public class ObserverA extends Observable implements Observer {

    AtomicInteger i = new AtomicInteger(1);

    public void addInt() {
        i.addAndGet(2);
        this.setChanged();
        this.notifyObservers(i.get());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ExampleObservable) {
            ExampleObservable example = (ExampleObservable) o;
            System.out.println("example.data changed, the new value of data is " + example.data);
        }
    }
}
