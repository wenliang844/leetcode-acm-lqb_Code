package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2022/9/30 13:44
 */
public class day010_面试题0108零矩阵 {

    /*
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 
示例 1：
输入：
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出：
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2：

输入：
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出：
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]``
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        printMatrix(matrix);
        setZeroes(matrix);
        printMatrix(matrix);
    }

    //方法一：常规 暴力解法    优化：标记法-->5|36
    public static void setZeroes(int[][] matrix) {

        int[] matrixI = new int[matrix.length];
        int[] matrixJ = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrixI[i] = 1;
                    matrixJ[j] = 1;
                }
            }
        }
        System.out.println("matrixI-----\n" + Arrays.toString(matrixI));
        System.out.println("matrixJ-----\n" + Arrays.toString(matrixJ));

        for (int i = 0; i < matrixI.length; i++) {
            if (matrixI[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < matrixJ.length; j++) {
            if (matrixJ[j] == 1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("matrix---------------------------------begin----------------------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
