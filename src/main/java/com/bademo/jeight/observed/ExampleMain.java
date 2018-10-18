package com.bademo.jeight.observed;

/**
 * @Description
 * @Author Bin.Liu
 * @Date 2018/10/18 09:00
 */
public class ExampleMain {
    public static void main(String[] args) {
        ExampleObservable eos  = new ExampleObservable();
        eos.addObserver(new ExampleObserver());
        eos.addObserver(new ObserverA());
        eos.setData(12);
        //eos.setData(-32);

        ObserverA oa = new ObserverA();
        oa.addObserver(new ExampleObserver());
        oa.addInt();
    }
}
