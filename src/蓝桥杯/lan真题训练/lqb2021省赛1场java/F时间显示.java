package 蓝桥杯.lan真题训练.lqb2021省赛1场java;

import java.util.Scanner;

public class F时间显示 {
    /***
     模拟
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        n/=1000;
        int res = (int) (n % (24*60*60)); //最后一天
        int h = res/3600;
        res %= 3600;
        int m = res / 60;
        res%=60;
        System.out.println(h+":"+m+":"+res);//String.Format格式化一下就好

    }
}
