package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;


public class q30Torry的困惑基本型 {
    //50000  枚举2 3 5 7质数  只要2-sqrt(i)都不能整除,就是质数
    //n<=100000
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int sum = 1;
        for (int i = 2;; i++) {
            if (check(i)) {
                count++;
                sum =sum * i %50000;
               // System.out.print(i+"\t");
            }
            if (count==n){
                break;
            }
        }
        //System.out.println();
        System.out.println(sum);
    }

    private static boolean check(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i%j==0){
                return false;
            }
        }
        return true;
    }
}
