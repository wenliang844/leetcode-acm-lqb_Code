package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class q25矩阵乘法 {

    //模拟即可
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row1 = scanner.nextInt();
        int col1row2 = scanner.nextInt();
        int col2 = scanner.nextInt();
        int[][] matrix1 = new int[row1][col1row2];
        int[][] matrix2 = new int[col1row2][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1row2; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < col1row2; i++) {
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        //业务处理
        int[][] ans = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {

                int sum = 0;
                for (int k = 0; k < col1row2; k++) {
                    sum+=matrix1[i][k] * matrix2[k][j];
                }
                ans[i][j] = sum;
            }
        }

        /*for (int i = 0; i < row1; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }*/
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
