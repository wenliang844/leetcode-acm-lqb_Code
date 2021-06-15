package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class code8_矩阵最长递增路径 {

    /***
     * 迷宫问题;递归函数  可以递归变动态规划
     3. 给定一个matrix, 位置可以上下左右移动,找到齐总最长的递增路径
     9 9 4
     6 6 8
     2 1 1

     4
     1- 2- 6- 9
     */
    public static int dfs(int[][] matrix, int i, int j, /*int len,*/int maxLength) {
        int newMaxLen = maxLength;//两个变量不可以混合使用
        //不递增的时候将maxLength 和 list.size()进行比较,
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {//左边可以增
            newMaxLen = Math.max(dfs(matrix, i - 1, j, maxLength + 1), newMaxLen);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {//左边可以增
            newMaxLen = Math.max(dfs(matrix, i, j - 1, maxLength + 1), newMaxLen);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {//左边可以增
            newMaxLen = Math.max(dfs(matrix, i + 1, j, maxLength + 1), newMaxLen);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {//左边可以增
            newMaxLen = Math.max(dfs(matrix, i, j + 1, maxLength + 1), newMaxLen);
        }


        return newMaxLen;
    }

    public static int maxMatrixLongPath(int[][] matrix) {
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, 1);
                maxLength = Math.max(maxLength, len);
                System.out.print(len + "\t");
            }
            System.out.println();
        }
        return maxLength;
    }


    //为什么用i j呢?   以前的代码量少,易于维护  现在的代码量大需要维护
    //2.比赛变量小,跑的时间少,不好的习惯,,工程要避免
    public static int longst(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                max = Math.max(max, process(matrix, row, col));//process理解成一个黑盒
            }
        }
        return max;
    }

    private static int process(int[][] matrix, int row, int col) {
        //向左走: 1.不越界 2.
        int path = 1;//原地不动的
        if ((col - 1 > 0 && matrix[row][col - 1] > matrix[row][col])) {
            path = Math.max(path, process(matrix, row, col - 1));
        }//如此类推
        //path = (row-1>0 && matrix[row-1][col] > matrix[row][col])?process(matrix,row-1,col)+1:path;//右加1


        return path;
    }


    //方法二:基于动态规划的求解
    //思想,如果一个值算过就直接返回值,没算过才递归,加了一个缓存
    //时机的上下时间不一样,
    //在原函数中加入一个dp,重复计算的值直接取出
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {//matrixatrix长度没有,空
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                max = Math.max(max, maxIncreasing(matrix, dp, row + 1, col, matrix[row][col] + 1) + 1);
                max = Math.max(max, maxIncreasing(matrix, dp, row, col + 1, matrix[row][col] + 1) + 1);
                max = Math.max(max, maxIncreasing(matrix, dp, row - 1, col, matrix[row][col] + 1) + 1);
                max = Math.max(max, maxIncreasing(matrix, dp, row, col - 1, matrix[row][col] + 1) + 1);
            }
        }

        return max;
    }

    private static int maxIncreasing(int[][] matrix, int[][] dp, int i, int j, int p) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= p) {
            return 0;
        }
        if (dp[i][j] == 0) {
            dp[i][j] = maxIncreasing(matrix, dp, i + 1, j, matrix[i][j] + 1);
            dp[i][j] = Math.max(dp[i][j], maxIncreasing(matrix, dp, i, j + 1, matrix[i][j] + 1));
            dp[i][j] = Math.max(dp[i][j], maxIncreasing(matrix, dp, i - 1, j, matrix[i][j] + 1));
            dp[i][j] = Math.max(dp[i][j], maxIncreasing(matrix, dp, i, j - 1, matrix[i][j] + 1));
        }
        return dp[i][j];
    }


    public static void main(String[] args) {
        System.out.println(maxMatrixLongPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
//        System.out.println(longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}


























