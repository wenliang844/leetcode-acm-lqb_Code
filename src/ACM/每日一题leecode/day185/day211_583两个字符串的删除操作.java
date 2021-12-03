package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day211_583两个字符串的删除操作 {
    public static void main(String[] args) {
        System.out.println(minDistance2("sea", "eat"));
        System.out.println(minDistance2("a", "ab"));
        System.out.println(minDistance2("zoologicoarchaeologist", "zoogeologist"));
        System.out.println(minDistance2("pneumonoultramicroscopicsilicovolcanoconiosis", "unmicroscopically"));

    }

    /***
     e a t
     s  0 0 0
     e  1 1 1
     a  1 2 2

       z o o g e o l o g i s t
     z 1
     o 0 2
     o 0 2 3
     l 0 2 3
     o
     g 0 2 3 4
     i
     c
     o
     a
     r
     c
     h
     a
     e 0 2 3 4 5
     o 0 2 3 4 5 6
     l
     o
     g
     i
     s
     t
     */
    //方法一：动态规划 寻找最长公共子序列
    public static int minDistance(String word1, String word2) {

        int row = word1.length();
        int col = word2.length();
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                if (word1.charAt(0) == word2.charAt(i)) {
                    return row + col - 2;
                }
            }
            return row + col;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                if (word1.charAt(i) == word2.charAt(0)) {
                    return row + col - 2;
                }
            }
            return row + col;
        }
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < col; i++) {
            if (word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //当word相等 并且左右两边更大，选更大的
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1,Math.max(dp[i - 1][j], dp[i][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("---"+row+"---"+col);
        for (int[] temp : dp) {
            System.out.println(Arrays.toString(temp));
        }

        return row + col - dp[row - 1][col - 1] * 2;
    }


    public static int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
