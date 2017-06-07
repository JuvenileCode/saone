package com.bademo.aoplx;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by:编写切点
 *
 * @author Bin.l
 * @date 2017/6/7 22:01
 */
public class Performance {

    public void catPerform() {
        System.out.println("i am test");
    }

    public void catPerformTerm(int id, String key, String sign) {
        System.out.println(id + " " + key + " " + sign);
    }

    public static void main(String[] args) {
        Performance performance = new Performance();
        performance.catPerform();
    }

}
