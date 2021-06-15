package ACM.每日一题leecode.day66;

import java.util.Arrays;

public class day91_1143最长公共子序列 {

    /****
     ] 当前位置匹配上了: dp[i][j]=dp[i-1][j-1]+1 text1[i-1] ！= text2[j-1] 当前位置没匹配上了 ：dp[i][j]=max(dp[i-1][j],dp[i][j-1]); basecase: 任何一个字符串为0时都是零，初始化时候就完成了basecase是赋值
     做了几个dp的题之后，总结了dp需要注意的几个要素：

     1、 明确dp二维数组表示的含义

     2、base case

     3、状态的转移：对于回文/LCS之类的问题则是考虑当前字串和已经计算过的子串之间的关系

     4、由状态的转移来确定 loop的边界

     5、 由loop的边界打出表格 可得出最后一个dp的状态值，即结果。

     一、最长公共子序列

     1、对于s[1..i] s[1..j] LCS长度为 dp[i][j]

     2、base case 一个字符串和自身没有子序列 dp[0][j] = dp[i][0] = 0

     3、dp[i][j] = dp[i-1][j-1] + 1

     4、for i in range(n + 1):
     for j in range(m + 1):
     5、dp[-1][-1]

     class Solution:
     def longestCommonSubsequence(self, text1: str, text2: str) -> int:
     #dp s[1..i] s[1..j] LCS长度为 dp[i][j]
     n = len(text1) # row
     m = len(text2) # colum
     dp = [[0] * (m + 1) for _ in range(n + 1)]

     for i in range(n + 1):
     for j in range(m + 1):
     dp[0][j] = dp[i][0] = 0
     for i in range(1,n + 1):
     for j in range(1, m + 1):
     if text1[i - 1] == text2[j - 1]:
     dp[i][j] = dp[i-1][j-1] + 1
     else:
     dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     return dp[-1][-1]
     * @param text1
     * @param text2
     * @return
     */
    //方法一:动态规划 二维数组,dp[i][j] = dp[i-1][j]+dp[j-1][i]
    //防止下标越界,多定义一个维度是i多+1,哨兵思想,空间换时间  79 80
    public static int longestCommonSubsequence(String text1, String text2) {
        int leni = text1.length();
        int lenj = text2.length();
        int dp[][] = new int[leni+1][lenj+1];
        for (int i = 1; i <= leni; i++) {
            for (int j = 1; j <= lenj; j++) {

                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    //dp[i][j] = dp[i-1][j] + dp[i][j-1]+1;
                    //dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j-1]);//相等,取左和对角线的最大值
                    //dp[i][j]++;
                    //dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1])+1;

                    dp[i][j] = dp[i-1][j-1]+1; //中了直接等于对角线加1,因为一个单词最大只能加1,在一个梯度中
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);//不相等取左,上最大
                }
            }
        }

        for (int i = 0; i <= leni; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[leni][lenj];
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence("bsbininm","jmjkbkjkv"));//1
        System.out.println(longestCommonSubsequence("abcba","abcbcba"));//6

    }
}
