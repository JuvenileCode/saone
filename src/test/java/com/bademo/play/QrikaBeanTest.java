package com.bademo.play;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.Date;

/**
 * Created by:Orika JavaBean映射工具练习
 *
 * @author Bin.l
 * @date 2017/5/8 22:32
 */
public class QrikaBeanTest {

    //Orika映射框架的基础是MapperFactory类,将用于配置任何映射的类,并获取执行实际映射工作的MapperFacade
    private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    public static void main(String[] args) {

        BasicPerson bpOne = new BasicPerson();
        bpOne.setName("Qrika碉堡了");
        bpOne.setAge(18);
        bpOne.setBirthDate(new Date());
        bpOne.setYq(895.5);

        //注册字段映射，转换器，自定义映射器，具体类型等[可以List,map转换]
        mapperFactory.classMap(BasicPerson.class, BasicPersonDto.class)
                .field("name", "fullName")
                .field("age", "currentAge")
                .byDefault()
                .register();
        //使用MapperFacade映射对象
        MapperFacade mapper = mapperFactory.getMapperFacade();
        BasicPersonDto bpDtoOne=mapper.map(bpOne,BasicPersonDto.class);

        System.out.println(bpOne.toString()+" <> "+bpOne.toString());

    }


}

class BasicPerson {
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
class BasicPersonDto {
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
