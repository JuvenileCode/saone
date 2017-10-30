package com.bademo.jeight.review;

/**
 * Created Info:约瑟夫环算法
 * :
 * User: dota.liu.bin@gmail.com
 * Date: 2017/10/24 0024.18:41
 */
public class JosephCircle {

    /**
     * 约瑟夫环算法
     * @param n
     * @param k
     */
    public void josephCircle(int n,int k){
        int flag=0;
        boolean[] kick = new boolean[n];
        //set kick flag to False;
        for(int i=0;i<n-1;i++){
            kick[flag]=false;
        }
        int counter=0;
        int accumulate=0;
        while(true){
            if(!kick[flag]){
                accumulate++;
                if(counter==n-1){
                    System.out.println("kick last person===="+(flag+1));
                    break;
                }
                if(accumulate==k){
                    kick[flag]=true;
                    System.out.println("kick person===="+(flag+1));
                    accumulate=0;
                    counter++;
                }
            }
            flag=(flag+1)%n;
        }

    }

    /**
     * 2角，5角，1角硬币，有多少种组合可得到1块钱
     */
    public void centsCombinations() {
        int i, j, k, total;
        System.out.println("1 角" + "  2 角" + "  5 角");
        for (i = 0; i <= 10; i++)
            for (j = 0; j <= 5; j++)
                for (k = 0; k <= 2; k++) {
                    total = i * 1 + j * 2 + k * 5;
                    if (total > 10)
                        break;
                    if (10 == total)
                        System.out.println("    " + i + ",    " + j + ",    " + k);
                }
    }

    public static void main(String[] args) {
        JosephCircle jCircle = new JosephCircle();
        //jCircle.josephCircle(20, 3);
        jCircle.centsCombinations();
    }
}
