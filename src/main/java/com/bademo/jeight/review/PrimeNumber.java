package com.bademo.jeight.review;

/**
 * Created Info: 算出质数
 * : 质数即大于1的一个自然数，这个数可以被1和自身整除，如20之内的质数[2，3，5，7，11，13，17，19]
 * User: dota.liu.bin@gmail.com
 * Date: 2017/10/24 0024.16:33
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int n = 20;
        //将数据放入数组
        int[] array = new int[n];
        for (int i = 2; i < n; i++) {
            array[i] = i;
        }

        for (int i = 2; i < n; i++) {
            if (array[i] != 0) {
                int j, temp;
                temp = array[i];
                //筛选算法:把所有的质数的倍数去掉后即留下质数
                for (j = 2 * temp; j < n; j = j + temp) {
                    array[j] = 0;
                }
            }
        }

        for (Integer i : array) {
            if (i > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
