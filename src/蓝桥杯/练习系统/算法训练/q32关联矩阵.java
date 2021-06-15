package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q32关联矩阵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /***
         1  -1  1  0   0  0  0   0  0
         -1  0  0  1   1  1  -1  0  0
         0  1  0  0   -1  -1  1  -1 0
         0  0  0  0    0  0  0   1  -1
         0  0  -1 -1   0  0  0   0  1

         x[a][j] = 1;
         x[b][j] = -1;
         */
        int point = scanner.nextInt();
        int edge = scanner.nextInt();
        int[][] gragh = new int[point+1][edge+1];
        for (int i = 1; i <= edge; i++) {
            gragh[scanner.nextInt()][i]=1;
            gragh[scanner.nextInt()][i]=-1;
        }

        for (int i = 1; i <= point; i++) {
            for (int j = 1; j <= edge; j++) {
                System.out.print(gragh[i][j]+" ");
            }
            System.out.println();
        }
    }
}
