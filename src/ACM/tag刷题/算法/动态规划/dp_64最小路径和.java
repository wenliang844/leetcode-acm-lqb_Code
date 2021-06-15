package ACM.tag刷题.算法.动态规划;

import java.util.Arrays;

public class dp_64最小路径和 {

    /***
     给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     说明：每次只能向下或者向右移动一步。
     */

    //方法一:哨兵,在i=0,j=0的时候都填充0,从1开始遍历 dp=Math.min(dp[i-1][j],dp[i][j-1])+dp[i][j]
    //哨兵思想不行,这里是min  或把int[0][j]fill最大值 87 52
    public static int minPathSum(int[][] grid) {
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("---------");
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
       /* for (int i = 0; i <= row; i++) {//让最大,避免被选中
            dp[i][0]=Integer.MAX_VALUE;
        }
        for (int i = 0; i <=col; i++) {
            dp[0][i]=Integer.MAX_VALUE;
        }*/
       //两边的只能一条路走到黑
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {//row方向
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < col; i++) {//col方向
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
