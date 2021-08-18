package ACM.leecode周赛.第252场周赛;

import java.util.Map;

public class lee1_5830三除数 {

    /***
     给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
     如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数
     */
    public static void main(String[] args) {

        System.out.println(isThree(2));
        System.out.println(isThree(4));
    }

    public static boolean isThree(int n) {
        //在1-sprt(n) 中取能整除的即可
        int temp = (int)Math.sqrt(n);
        System.out.println(temp);
        int count = 0;
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n%i==0){
                count++;
            }
            System.out.println(i+"---");
        }

        count *=2;
        if (temp*temp==n){
            count++;
        }

        return count==3;
    }
}
