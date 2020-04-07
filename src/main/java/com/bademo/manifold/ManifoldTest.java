package com.bademo.manifold;

/**
 * @auther: Bin.L
 * @date: 2019/06/21 10:24
 * @Description: Manifold通过类型安全元编程，结构类型化和扩展方法等强大功能为Java重新注入活力
 *               https://github.com/manifold-systems/manifold
 */
public class ManifoldTest {


    public static void main(String[] args) {

        int hour = 15;
        // Simple variable access with '$'
        String result = "The hour is $hour"; // Yes!!!
        System.out.println(result);
        // Use expressions with '${}'
        result = "It is ${hour > 12 ? hour-12 : hour} o'clock";
        System.out.println(result);

    }
}
