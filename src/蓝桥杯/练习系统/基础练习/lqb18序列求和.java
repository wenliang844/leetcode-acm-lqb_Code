package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb18序列求和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int test1 = 1000000000;
        //long test2 = 100000000000L;
        //System.out.println(test2);
        long sum = 0L;
        for (int i = 1; i <=n ; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
