package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb14isleap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int yaer = sc.nextInt();
        if (yaer%400==0 || (yaer%4==0&&yaer%100!=0)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
