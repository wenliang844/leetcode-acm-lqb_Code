package ACM.tag刷题.算法.动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

public class dp_72编辑距离 {
    /***
     给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     你可以对一个单词进行如下三种操作：
     插入一个字符
     删除一个字符
     替换一个字符

     例 1：
     输入：word1 = "horse", word2 = "ros"
     输出：3
     解释：
     horse -> rorse (将 'h' 替换为 'r')
     rorse -> rose (删除 'r')
     rose -> ros (删除 'e')

     示例 2：
     输入：word1 = "intention", word2 = "execution"
     输出：5
     解释：
     intention -> inention (删除 't')
     inention -> enention (将 'i' 替换为 'e')
     enention -> exention (将 'n' 替换为 'x')
     exention -> exection (将 'n' 替换为 'c')
     exection -> execution (插入 'u')
     */

    //方法一:用最大公子序列,然后,除了子序列,其他的都需要改动 dp--失败
    public static int minDistance0(String word1, String word2) {
        //最大共公子序列dp
        int dp[][] = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {//相同则等于左上(斜上)+1
                    if (j - 1 >= 0 && i - 1 >= 0)
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0);
                }
            }
        }

        /*for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/

        int maxLen = Math.max(word1.length(), word2.length());
        return maxLen - dp[word1.length() - 1][word2.length() - 1];
    }

    /***
     i n t e n t i o n
     e 1 2 3 3 4 5 6 7 8
     x 2 2 3 4 4 5 6 7 8
     e 3 3 3 3
     c
     t
     i
     o
     n
     */
    //方法二:填充图表,找规律: 子状态的规律
    //规律:当相等的时候,直接等于协上角,不等的时候,等于增删改最小的,也就是左,上,斜最小的再加1
    public static int minDistance2(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];
        //初始化i=0,j=0的两种情况:相等则等于前一个,不等则等于前一个+1
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < len1; i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int j = 1; j < len2; j++) {
            if (word1.charAt(0) == word2.charAt(j)) {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = dp[0][j - 1] + 1;
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {//想等的话,就不用变化
                    dp[i][j] = dp[i - 1][j - 1];//注意i,j=0的情况
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        for (int i = 0; i < len1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len1 - 1][len2 - 1];
    }

    //甜胰题解:加哨兵87 52
    public static int minDistance3(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始化i=0,j=0的两种情况:相等则等于前一个,不等则等于前一个+1
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;

        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {//想等的话,就不用变化
                    dp[i][j] = dp[i - 1][j - 1];//注意i,j=0的情况
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        for (int i = 0; i <= len1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance2("horse", "ros"));
        System.out.println(minDistance2("intention", "execution"));
        System.out.println(minDistance2("", ""));
        System.out.println(minDistance3("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }
}
