package com.bademo.play.bean;

import java.util.Date;

/**
 * Created Info:orika测试用
 * User: dota.liu.bin@gmail.com
 * Date: 2017/5/9 0009.17:11
 */
public class BasicPerson {
    private String name;
    private int age;
    private Date birthDate;
    private double yq;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getYq() {
        return yq;
    }

    public void setYq(double yq) {
        this.yq = yq;
    }

    @Override
    public String toString() {
        return "BasicPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", yq=" + yq +
                '}';
    }
}
