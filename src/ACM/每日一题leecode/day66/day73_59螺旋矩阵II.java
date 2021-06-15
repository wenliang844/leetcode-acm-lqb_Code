package ACM.每日一题leecode.day66;

import java.util.Arrays;

public class day73_59螺旋矩阵II {

    /***
     给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     输入：n = 3
     输出：[[1,2,3],[8,9,4],[7,6,5]]
     */

    public static int[][] generateMatrix(int n) {

        //List<Integer> list = new ArrayList<>();

        int[][] matrix = new int[n][n];
        int[][] matrix2 = new int[n + 2][n + 2];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j] = 10000;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix2[i + 1][j + 1] = matrix[i][j];
            }
        }
        /*for (int i = 0; i < matrix2.length; i++) {//设置外圈一个哨兵 i j从1开始,碰到0结束
            System.out.println(Arrays.toString(matrix2[i]));
        }*/

        int i = 1;
        int j = 1;
        int times1 = matrix.length;
        int times2 = matrix[0].length;
        int times = Math.min(times1, times2);
        times = (times1 + 1) / 2;
        int num = 1;
        while (times > 0) {
            //四个for循环 j++ i++ j-- i--   终止条件是0
            while (matrix2[i][j] == 0) {
                //System.out.println(matrix2[i][j]);
                matrix2[i][j] = num;
                num++;
                //matrix2[i][j]=10000;
                j++;
            }
            j--;
            i++;
            while (matrix2[i][j] == 0) {
                //System.out.println(matrix2[i][j]);
                matrix2[i][j] = num;
                num++;
                i++;
            }
            i--;
            j--;
            while (matrix2[i][j] == 0) {
                //System.out.println(matrix2[i][j]);
                matrix2[i][j] = num;
                num++;
                j--;
            }
            j++;
            i--;
            while (matrix2[i][j] == 0) {
                //System.out.println(matrix2[i][j]);
                matrix2[i][j] = num;
                num++;
                i--;
            }
            i++;
            j++;
            //times--;
            if (matrix2[i][j] != 0) {
                break;
            }
        }

        for (int i1 = 1; i1 < matrix2.length-1; i1++) {
            for (int j1 = 1; j1 < matrix2[i1].length-1; j1++) {
                matrix[i1 - 1 ][j1 - 1] = matrix2[i1][j1];
            }
        }
        return matrix;
    }

    public static void print2(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public static void main(String[] args) {
        print2(generateMatrix(3));
    }
}
