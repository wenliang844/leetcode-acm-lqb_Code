package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB;

import java.util.Arrays;

public class code1穿越雷区 {
    /***
     动态规划:从左到右扫描,从右到左也扫描一遍

     需要改进:AB的位置不一样
     */
    private static void printNums(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        System.out.println("-------分割线---------");
    }

    public static int getNum(char[][] chs) {

        int dp[][] = new int[chs.length][chs.length];
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        printNums(dp);
        for (int i = 2; i < chs.length; i++) {
            if (dp[0][i - 1] != 0 && chs[0][i] != chs[0][i - 1]) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                break;
            }
        }
        for (int i = 2; i < chs.length; i++) {
            if (dp[i - 1][0] != 0 && chs[i][0] != chs[i - 1][0]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                break;
            }
        }

        printNums(dp);

        //进行其他的子问题叠加
        for (int i = 1; i < chs.length; i++) {
            //从左到右
            for (int j = 1; j < chs.length; j++) {
                //在上下两条线路选择一个最小的值进行
                int shang = Integer.MAX_VALUE;
                int zuo = Integer.MAX_VALUE;
                boolean changed = false;
                if (dp[i - 1][j] != 0 && chs[i - 1][j] != chs[i][j]) {
                    shang = dp[i - 1][j];
                    changed = true;
                }
                if (dp[i][j - 1] != 0 && chs[i][j - 1] != chs[i][j]) {
                    zuo = dp[i][j - 1];
                    changed = true;
                }
                if (changed) {
                    dp[i][j] = Math.min(shang, zuo) + 1;
                }

                if (chs[i][j] == 'B') {
                    return dp[i][j];
                }
            }
            //从右到左
            for (int j = chs.length - 2; j >= 0; j--) {
                //在上下两条线路选择一个最小的值进行
                int shang = Integer.MAX_VALUE;
                int you = Integer.MAX_VALUE;
                boolean changed = false;
                if (dp[i - 1][j] != 0 && chs[i - 1][j] != chs[i][j]) {
                    changed = true;
                    shang = dp[i - 1][j];
                }
                if (dp[i][j + 1] != 0 && chs[i][j + 1] != chs[i][j]) {
                    you = dp[i][j + 1];
                    changed = true;
                }

                int self = Integer.MAX_VALUE;

                if (dp[i][j] != 0) self = dp[i][j];
                if (changed) {
                    dp[i][j] = Math.min(Math.min(shang, you) + 1, self);
                }

                if (chs[i][j] == 'B') {
                    return dp[i][j];
                }
            }
        }
        printNums(dp);

        return 0;//动态规划会少走一些点,比如上左
    }

    static int count = 0;

    //用递归,搜索上下左右
    public static void dfs(char[][] chs) {

    }

    public static void main(String[] args) {
        System.out.println(getNum(new char[][]{{'A', '+', '-', '+', '-'}, {'-', '+', '-', '-', '+'}, {'-', '+', '+', '+', '-'}, {'+', '-', '+', '-', '+'}, {'B', '+', '-', '+', '-'}}));
    }
}
