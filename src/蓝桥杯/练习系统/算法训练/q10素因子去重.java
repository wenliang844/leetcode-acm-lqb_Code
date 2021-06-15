package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q10素因子去重 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        //第一步 求出n的所有素因子 除2 除3 除5
        boolean flag2 = false;
        long ans = 1;
        while (n%2==0){
            flag2=true;
            n/=2;
        }
        if (flag2){
            ans*=2;
        } boolean flag3= false;
        while (n%3==0){
            flag3=true;
            n/=3;
        }
        if (flag3){
            ans*=3;
        } boolean flag5 = false;
        while (n%5==0){
            flag5=true;
            n/=5;
        }
        if (flag5){
            ans*=5;
        }
        System.out.println(ans*n);

    }
}
