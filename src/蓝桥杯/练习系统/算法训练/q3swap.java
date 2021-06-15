package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q3swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[2];//4 7
        a[0] = sc.nextInt();
        a[1] = sc.nextInt();
        swap(a);
        System.out.println(a[0]+" "+a[1]);
    }

    private static void swap(int[] a) {
        int temp = a[0];
        a[0]=a[1];
        a[1]=temp;
    }
}
