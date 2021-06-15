package 蓝桥杯.练习系统.算法提高;

import java.util.Arrays;
import java.util.Scanner;


public class q4拯救Andy {

    //方法一:暴力解法
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int snake = scanner.nextInt();
        int water = scanner.nextInt();
        int[][] matrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < snake; i++) {
            matrix[scanner.nextInt()][scanner.nextInt()]=-1;
        }
        for (int i = 0; i < water; i++) {
            matrix[scanner.nextInt()][scanner.nextInt()]=0;
        }

        //hander
        //对每一个坐标进行上下左右遍历
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j]!=-1&&matrix[i][j]!=0){
                    dfs(i,j);

                }
            }
        }
    }

    private static void dfs(int i, int j) {

    }
}
