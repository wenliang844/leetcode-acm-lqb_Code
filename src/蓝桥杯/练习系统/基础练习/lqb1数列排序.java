package 蓝桥杯.练习系统.基础练习;

import java.util.Arrays;
import java.util.Scanner;

public class lqb1数列排序 {

    /**
     5
     8 3 6 4 9
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        Arrays.sort(a);
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.print(a[a.length-1]);
    }

}
