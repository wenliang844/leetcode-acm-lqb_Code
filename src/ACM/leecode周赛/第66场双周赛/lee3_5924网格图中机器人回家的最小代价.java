package ACM.leecode周赛.第66场双周赛;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lee3_5924网格图中机器人回家的最小代价 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}));
        System.out.println(minCost(new int[]{2, 0}, new int[]{2, 2}, new int[]{8, 5, 6, 12, 10}, new int[]{1, 8, 18, 11, 24, 16}));
        //回家的路可以拐弯的;
        System.out.println(minCost(new int[]{5, 5}, new int[]{5, 2}, new int[]{7, 1, 3, 3, 5, 3, 22, 10, 23}, new int[]{5, 5, 6, 2, 0, 16}));
    }

    //dp
    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        //从start开始,判断home是哪个方位的,用响应的算法
        int row = rowCosts.length;
        int col = colCosts.length;
        int[][] dp = new int[row][col];
        if (homePos[0] >= startPos[0] && homePos[1] >= startPos[1]) {
            System.err.println("execute 1");
            for (int i = startPos[1] + 1; i <= homePos[1]; i++) {
                dp[startPos[0]][i] = dp[startPos[0]][i - 1] + colCosts[i];
            }
            for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
                dp[i][startPos[1]] = dp[i - 1][startPos[1]] + rowCosts[i];
            }
            for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
                for (int j = startPos[1] + 1; j <= homePos[1]; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + rowCosts[i], dp[i][j - 1] + colCosts[j]);
                }
            }
            print(dp);
            return dp[homePos[0]][homePos[1]];
        }
        if (homePos[0] <= startPos[0] && homePos[1] <= startPos[1]) {
            System.err.println("execute 2");
            for (int i = homePos[1] + 1; i <= startPos[1]; i++) {
                dp[homePos[0]][i] = dp[homePos[0]][i - 1] + colCosts[i];
            }
            for (int i = homePos[0] + 1; i <= startPos[0]; i++) {
                dp[i][homePos[1]] = dp[i - 1][homePos[1]] + rowCosts[i];
            }
            for (int i = homePos[0] + 1; i <= startPos[0]; i++) {
                for (int j = homePos[1] + 1; j <= startPos[1]; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + rowCosts[i], dp[i][j - 1] + colCosts[j]);
                }
            }
            print(dp);
            return dp[startPos[0]][startPos[1]];
        }
        if (homePos[0] <= startPos[0] && homePos[1] >= startPos[1]) {
            System.err.println("execute 3");
            for (int i = startPos[1] + 1; i <= homePos[1]; i++) {
                dp[startPos[0]][i] = dp[startPos[0]][i - 1] + colCosts[i];
            }
            for (int i = startPos[0] + 1; i >= homePos[0]; i--) {
                dp[i][startPos[1]] = dp[i + 1][startPos[1]] + rowCosts[i];
            }
            for (int i = startPos[0] + 1; i >= homePos[0]; i--) {
                for (int j = startPos[1] + 1; j <= homePos[1]; j++) {
                    dp[i][j] = Math.max(dp[i + 1][j] + rowCosts[i], dp[i][j - 1] + colCosts[j]);
                }
            }
            print(dp);
            return dp[homePos[0]][homePos[1]];
        }
        if (homePos[0] >= startPos[0] && homePos[1] <= startPos[1]) {
            System.err.println("execute 4");
            for (int i = homePos[1] + 1; i <= startPos[1]; i++) {
                dp[homePos[0]][i] = dp[homePos[0]][i - 1] + homePos[i];
            }
            for (int i = homePos[0] + 1; i >= startPos[0]; i--) {
                dp[i][homePos[1]] = dp[i + 1][homePos[1]] + rowCosts[i];
            }
            for (int i = homePos[0] + 1; i >= startPos[0]; i--) {
                for (int j = homePos[1] + 1; j <= startPos[1]; j++) {
                    dp[i][j] = Math.max(dp[i + 1][j] + rowCosts[i], dp[i][j - 1] + colCosts[j]);
                }
            }
            print(dp);
            return dp[startPos[0]][startPos[1]];
        }

        print(dp);
        return dp[homePos[0]][homePos[1]];
    }

    private static void print(int[][] dp) {
        System.err.println("----start print dp----------------------------");
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
