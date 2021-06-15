package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb8杨辉三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            triangle[i][0]=1;
            triangle[i][i]=1;
        }


        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n-1; j++) {
                triangle[i][j] = triangle[i-1][j]+triangle[i-1][j-1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(triangle[i][j]+" ");
            }
            System.out.print(triangle[i][i]);
            System.out.println();
        }
    }
}
