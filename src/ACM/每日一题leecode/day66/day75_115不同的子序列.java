package ACM.每日一题leecode.day66;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class day75_115不同的子序列 {

    /***
     给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     字符串的一个 子序列 是指，通过删除一些（也可以不删除）
     字符且不干扰剩余字符相对位置所组成的新字符串。
     （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     题目数据保证答案符合 32 位带符号整数范围。

     输入：s = "rabbbit", t = "rabbit"
     输出：3
     解释：
     如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
     (上箭头符号 ^ 表示选取的字母)
     rabbbit
     ^^^^ ^^
     rabbbit
     ^^ ^^^^
     rabbbit
     */

    /**
     * 回溯算法:
     * 1.定义一个a[i] 长度为t.len的数组
     * 数组的下标表示t 数组的数值表示t[i]和s[a[i]]匹配上了,继续匹配下一个 i++ a[i] = a[i-1]+1;
     * 如果匹配到了最后一个数  i=t.len 匹配上了就count++; 匹配不上就break;
     */
//    static int count = 0;
    public static int numDistinct(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] match = t.toCharArray();
        int[] index = new int[match.length];
        int ret = merge(s1, match, index, 0, 0);
        //int ret = 0;


        return ret;
    }

    public static int merge(char[] s1, char[] match, int index[], int i, int count) {
        if (index[i] >= s1.length) {//index[i] >= s1.length  index[0] >= s1.length - match.length +1 &&
            /*i--;
            index[i]++;
            return merge(s1,match,index,i,count);*/
            System.out.println(i + "--" + Arrays.toString(index));
            return count;
            //判断 没戏了就return count;   否则执行merge
        } else {
            //判断是否到最后一个了
            //如果是最后一个,那index[i]后面有多少个i 就count+几 然后再从i=0开始匹配
            if (i == match.length - 1) {//最后一个了
                System.out.println("到了最后一个了 i=" + i);
                System.out.println(Arrays.toString(index));
                for (; index[i] < s1.length; index[i]++) {
                    if (s1[index[i]] == match[i]) {
                        count++;
                        System.out.println(count);
                    }
                }

                //return count; //merge(s1,match,index,i--,count); index[x]++;
                i--;
                index[i]++;
                return merge(s1, match, index, i, count);
                //return count;

            } else {
                //不是最后一个,继续匹配
                //匹配
                if (s1[index[i]] == match[i]) {//匹配
                    i++;
                    index[i] = index[i - 1] + 1;
                    return merge(s1, match, index, i, count);
                } else {//不匹配
                    index[i]++;
                    return merge(s1, match, index, i, count);
                }

            }
        }
    }


    /*****
     * 使用二维动态规划;
     * "" b a b g b a g
     * "" 1  1 1 1 1 1 1 1
     * b  0  1 1 2 2 3 3 3
     * a  0  0 1 1 1 1 4 4
     * g  0  0 0 0 1 1 1 4
     * <p>
     * s[j]==t[i] ---> dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
     * s[j]!=t[i] -->  dp[i][j] = dp[i][j-1]
     特殊情况的处理:

     */
    static void printNums(int nums[][]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public static int numDistinct2(String s, String t) {
        int dp[][] = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        //printNums(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        //printNums(dp);
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct2("rabbbit", "rabit"));
        System.out.println(numDistinct2("adbcabc", "abc"));
        System.out.println(numDistinct2("babgbag", "bag"));
    }


}
