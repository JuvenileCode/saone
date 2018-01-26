package com.bademo.aoplx.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created Info:reflection test
 * User: dota.liu.bin@gmail.com
 * Date: 2018/1/25 0025.17:09
 */
public class RelfectT1 {

    public static void main(String[] args) {
        //反射来生成对象主要有两种方式
        try {
            //使用Class对象的newInstance()方法来创建Class对象对应类的实例
            Class<?> c = String.class;
            Object str = c.newInstance();
            //先通过Class对象获取指定的Constructor对象,再调用Constructor对象的newInstance()方法来创建实例
            Class<?> c2 = String.class;
            Constructor constructor = c2.getConstructor(String.class);
            Object ob = constructor.newInstance("STR");
            System.out.println(ob);

            //获取方法
            Class<?> mc = MethodClass.class;
            Object mcobj = mc.newInstance();
            //返回某个类的所有公用（public）方法，包括其继承类的公用方法
            Method[] methods = mc.getMethods();
            //方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法
            Method[] declaredMethods = mc.getDeclaredMethods();
            //获取methodClass类的add方法
            Method zm = mc.getDeclaredMethod("add", int.class, int.class);
            System.out.println(" invoke method: "+zm.invoke(mcobj, 3, 4));

            Arrays.stream(methods).forEach(System.out::println);
            System.out.println("-----------");
            Arrays.stream(declaredMethods).forEach(System.out::println);
            System.out.println("-----------");
            //访问公有的成员变量
            Field[] files = mc.getFields();
            //所有已声明的成员变量。但不能得到其父类的成员变量
            Field[] declaredfilesmc = mc.getDeclaredFields();
            Arrays.stream(files).forEach(System.out::println);
            Arrays.stream(declaredfilesmc).forEach(System.out::println);

            //利用反射创建数组
            Class<?> strs = String.class;
            Object os = Array.newInstance(strs,10);
            Array.set(os,0,"hellow");
            Array.set(os,1,"java");
            System.out.println(Array.get(os, 1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MethodClass {

        public final int fuck = 3;

        public int add(int a, int b) {
            return a + b;
        }

        public int sub(int a, int b) {
            return a + b;
        }
    }
}
