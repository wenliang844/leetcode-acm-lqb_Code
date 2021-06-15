package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb17圆的面积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        double area = Math.PI * r*r;
        System.out.println(area);
        System.out.println(String.format("%.7f",area));
    }
}
