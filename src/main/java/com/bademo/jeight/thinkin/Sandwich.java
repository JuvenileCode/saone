package com.bademo.jeight.thinkin;

/**
 * Created by：构造器和多态
 *  :构造器的调用顺序
 * @author Bin.l
 * @date 2017/10/15 11:34
 */


public class Sandwich extends Lunch {

    public Sandwich() {
        System.out.println("sandwich");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

/**
 * 按照继承层次逐渐构建，先初始化上层类变量，然后构建构造方法。
 */
class Meal {
    private Cheese cheese = new Cheese();
    public Meal(){
        System.out.println("Meal");
    }
}
class Lunch extends Meal {
    public Lunch(){
        System.out.println("Lunch");
    }
}

class Cheese{
    public Cheese() {
        System.out.println("Cheese");
    }
}