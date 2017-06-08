package com.bademo.annotation;

import java.lang.reflect.Method;

/**
 * Created by:测试定义注解
 *
 * @author Bin.l
 * @date 2017/6/8 22:10
 */

@FruitName(desc = "i am class annotation", author = " class author.. ")
public class ChildTest {
    @FruitName(desc = "i am method annotation", author = " method author.. ")
    public String nameStr() {
        return "test Z";
    }

    //通过反射获取类 、函数或成员上的运行时注解信息，从而实现动态控制程序运行的逻辑
    public static void main(String[] args) {
        try {
            // 使用类加载器加载类
            Class c = Class.forName("com.bademo.annotation.ChildTest");
            // 找到类上面的注解
            boolean isExist = c.isAnnotationPresent(FruitName.class);
            // 上面的这个方法是用这个类来判断这个类是否存在Description这样的一个注解
            if (isExist) {
                // 拿到注解实例，解析类上面的注解
                FruitName d = (FruitName) c.getAnnotation(FruitName.class);
                System.out.println(d.desc()+" "+d.author());
            }
            //获取所有的方法
            Method[] ms = c.getMethods();
            // 遍历所有的方法
            for (Method m : ms) {
                boolean isExist1 = m.isAnnotationPresent(FruitName.class);
                if (isExist1) {
                    FruitName d1=m.getAnnotation(FruitName.class);
                    System.out.println(d1.desc()+" "+d1.author());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
