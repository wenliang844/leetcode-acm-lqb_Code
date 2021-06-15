package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb10进制转16进制 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = Integer.toString(n, 16);
        System.out.println(s);
    }
}
