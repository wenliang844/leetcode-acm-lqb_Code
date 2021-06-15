package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb15Fibonacci数列 {
    public static void main(String[] args) {
        /***
         10007
         Fn=Fn-1+Fn-2
         10 55
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<=2){
            System.out.println(1);
            return;
        }
        int f1 = 1;
        int f2 = 1;
        //从3开始
        for (int i = 3; i <= n; i++) {
            int temp = f2;
            f2 = (f1+f2)%10007;
            f1=temp;
        }
        System.out.println(f2%10007);


    }
}
