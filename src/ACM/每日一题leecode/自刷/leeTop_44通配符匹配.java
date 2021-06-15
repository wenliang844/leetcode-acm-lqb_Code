package ACM.每日一题leecode.自刷;

import java.util.regex.Pattern;

public class leeTop_44通配符匹配 {
    /***
     给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     '?' 可以匹配任何单个字符。
     '*' 可以匹配任意字符串（包括空字符串）。
     两个字符串完全匹配才算匹配成功。
     说明:
     s 可能为空，且只包含从 a-z 的小写字母。
     p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     示例 1:
     输入:
     s = "aa"
     p = "a"
     输出: false
     解释: "a" 无法匹配 "aa" 整个字符串。
     */
    //方法一:从字符的后面开始匹配,双指针 pass1491/1811
    public static boolean isMatch(String s, String p) {

        int p1 = s.length() - 1;
        int p2 = p.length() - 1;

        boolean flag1 = true;
        boolean flag2 = true;
        while (p1 >= 0 && p2 >= 0) {
            if (p.charAt(p2) == '*') {
                //匹配任意一个
                //找到最近的一个p2-- == p1--的位置
                while (p2 >= 0 && p.charAt(p2) == '*') {
                    p2--;
                }
                if (p2 < 0) return true;
                while (p1 >= 0 && p.charAt(p2) != s.charAt(p1)) {
                    p1--;
                }
            } else if (p.charAt(p2) == '?') {
                p1--;
                p2--;
            } else {
                if (p.charAt(p2) == s.charAt(p1)) {
                    p1--;
                    p2--;
                } else {
                    return false;
                }
            }
        }

        while (p2 >= 0 && p.charAt(p2) == '*') {
            p2--;
        }

        if (p1 < 0 && p2 < 0) {
            return true;
        } else {
            return false;
        }



        //第二轮:再正向进行一下,flag2标记,如果正向可以的话,直接true,否则false
        /*int p3=0;
        int p4=0;

        while (p3 < s.length() && p4 < p.length()) {
            if (p.charAt(p4) == '*') {
                //匹配任意一个
                //找到最近的一个p2-- == p1--的位置
                while (p4 < p.length()&& p.charAt(p4) == '*') {
                    p4++;
                }
                if (p4 >=p.length()) return true;
                while (p3 < s.length() && p.charAt(p4) != s.charAt(p3)) {
                    p3++;
                }
            } else if (p.charAt(p4) == '?') {
                p3++;
                p4++;
            } else {
                if (p.charAt(p4) == s.charAt(p3)) {
                    p3++;
                    p4++;
                } else {
                    return false;
                }
            }
        }

        while (p4 <p.length() && p.charAt(p4) == '*') {
            p4++;
        }

        if (p3 >= p.length() && p4 >=p.length()) {
            return true;
        } else {
            return false;
        }*/


    }

    //方法二:api
    public static boolean isMatch2(String s, String p) {
        //正则 pattrn
        boolean matches = Pattern.matches(s, "*");
        return matches;
    }

    //方法三:动态规划 转移方程
    public boolean isMatch3(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));//false
        System.out.println(isMatch("aa", "*"));//true
        System.out.println(isMatch("cd", "?a"));//false
        System.out.println(isMatch("adceb", "*a*b"));//true
        System.out.println(isMatch("acdcb", "a*c?b"));//false
    }
}
