package 蓝桥杯.练习系统.算法提高;

import java.util.Scanner;

public class q3组合数 {//45645 43535 30671     10418

    //nm = n,n-m = n-1 m-1 + n-1 m
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int num1 = 1;
        int num2 = 1;
        for (int i = n; i >m; i--) {
            num1 *= i;
            num1 %= p;
        //    System.out.println(i);
        }

        for (int i = 1; i <= n-m; i++) {
            num2 *= i;
            num2 %= p;
        }

        System.out.println(num1+"--"+num2);
        System.out.println((num1>num2?num1%num2:(num1+p)/num2));
    }
}
