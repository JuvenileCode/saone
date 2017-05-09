package com.bademo.play.bean;

import java.util.Date;

/**
 * Created Info:orika测试用
 * User: dota.liu.bin@gmail.com
 * Date: 2017/5/9 0009.17:11
 */
public class BasicPersonDto {
    private String fullName;
    private int currentAge;
    private Date birthDate;
    private double yq;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
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
        return "BasicPersonDto{" +
                "fullName='" + fullName + '\'' +
                ", currentAge=" + currentAge +
                ", birthDate=" + birthDate +
                ", yq=" + yq +
                '}';
    }
}
