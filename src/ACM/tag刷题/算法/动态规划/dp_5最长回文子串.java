package ACM.tag刷题.算法.动态规划;

public class dp_5最长回文子串 {
    /****
     给你一个字符串 s，找到 s 中最长的回文子串。
     */

    //方法一:暴力解法:倒过来的最长匹配 特殊情况:不在中心的 abb bba
    public static String longestPalindrome(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        //System.out.println(reverseS);
        //转化为最长公共子序列问题 字符串匹配,不过是相等字符串长度的,直接使用暴力法,一个一个匹配,
        String maxLen = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == reverseS.charAt(i)){
                temp += s.charAt(i);
                //System.out.println("这是每次的temp变化"+temp);
            }else {
                if (temp.length() > maxLen.length()){
                    maxLen = temp;
                }
                temp = "";

                //System.out.println("这是交换后的tmep和maxLne"+temp+"---"+maxLen);
            }
        }
        if (temp.length() > maxLen.length()){
            maxLen = temp;
        }
        if (maxLen.length()==0){
            maxLen += s.charAt(0);
        }

        return maxLen;
    }

    //方法二:动态规划 String[][] 一正一reverse 相同的就在数组中填充这个字符和左上对角线的值相加
    public static String longestPalindrome2(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        int len = s.length();
        String[][] dp = new String[len][len];
        String maxLen = "";

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverseS.charAt(j)){
                    if (j-1>=0 && i-1>=0 && dp[i-1][j-1] != null){
                        dp[i][j] = dp[i-1][j-1]+s.charAt(i);
                    }else {
                        dp[i][j] = s.charAt(i)+"";
                    }
                    //判断和maxLength谁大 && dp[i][j]要是回文串
                    if ((dp[i][j].length() > maxLen.length()) && isHuiWen(dp[i][j])){
                        maxLen = dp[i][j];
                    }
                }


            }
        }

        return maxLen;
    }

    //方法二超内存改进:用两个变量 用两个一维数组 5 5
    public static String longestPalindrome3(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        int len = s.length();
        String[][] dp = new String[2][len];
        String maxLen = "";

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverseS.charAt(j)){
                    if (j-1>=0 && i-1>=0 && dp[0][j-1] != null){
                        dp[1][j] = dp[0][j-1]+s.charAt(i);
                    }else {
                        dp[1][j] = s.charAt(i)+"";
                    }
                    //判断和maxLength谁大 && dp[i][j]要是回文串
                    if ((dp[1][j].length() > maxLen.length()) && isHuiWen(dp[1][j])){
                        maxLen = dp[1][j];
                    }
                }
            }
            //将dp[1] 赋值给dp[0]
            for (int j = 0; j < dp[1].length; j++) {
                dp[0][j] = dp[1][j];
                dp[1][j] = "";
            }

        }

        return maxLen;
    }

    //官方的动态规划:P(i,j)=P(i+1,j−1)∧(Si==Sj)
    //一个一个遍历,两边扩展法再
    public static String longestPalindrome4(String s) {
        /**
         这里的「其它情况」包含两种可能性：
         s[i, j]s[i,j] 本身不是一个回文串；
         i > ji>j，此时 s[i, j]s[i,j] 本身不合法。
         那么我们就可以写出动态规划的状态转移方程：
        P(i, j) = P(i+1, j-1) \wedge (S_i == S_j)
         P(i,j)=P(i+1,j−1)∧(S
         i==S
         j)
         也就是说，只有 s[i+1:j-1]s[i+1:j−1] 是回文串，并且 ss 的第 ii 和 jj 个字母相同时，s[i:j]s[i:j] 才会是回文串
         上文的所有讨论是建立在子串长度大于 22 的前提之上的，我们还需要考虑动态规划中的边界条件，即子串的长度为 11 或 22。对于长度为 11 的子串，它显然是个回文串；对于长度为 22 的子串，只要它的两个字母相同，它就是一个回文串。因此我们就可以写出动态规划的边界条件
         \begin{cases} P(i, i) = \text{true} \\ P(i, i+1) = ( S_i == S_{i+1} ) \end{cases}
         {
         P(i,i)=true
         P(i,i+1)=(S
         i==S
         i+1)


         我们仔细观察一下方法一中的状态转移方程：

         \begin{cases} P(i, i) &=\quad \text{true} \\ P(i, i+1) &=\quad ( S_i == S_{i+1} ) \\ P(i, j) &=\quad P(i+1, j-1) \wedge (S_i == S_j) \end{cases}
         ⎩
         ⎪
         ⎪
         ⎨
         ⎪
         ⎪
         ⎧
         ​

         P(i,i)
         P(i,i+1)
         P(i,j)
         ​

         =true
         =(S
         i
         ​
         ==S
         i+1
         ​
         )
         =P(i+1,j−1)∧(S
         i
         ​
         ==S
         j
         ​
         )
         ​


         找出其中的状态转移链：

         P(i, j) \leftarrow P(i+1, j-1) \leftarrow P(i+2, j-2) \leftarrow \cdots \leftarrow \text{某一边界情况}
         P(i,j)←P(i+1,j−1)←P(i+2,j−2)←⋯←某一边界情况

         可以发现，所有的状态在转移的时候的可能性都是唯一的。也就是说，我们可以从每一种边界情况开始「扩展」，也可以得出所有的状态对应的答案。

         边界情况即为子串长度为 11 或 22 的情况。我们枚举每一种边界情况，并从对应的子串开始不断地向两边扩展。如果两边的字母相同，我们就可以继续扩展，例如从 P(i+1,j-1)P(i+1,j−1) 扩展到 P(i,j)P(i,j)；如果两边的字母不同，我们就可以停止扩展，因为在这之后的子串都不能是回文串了。

         聪明的读者此时应该可以发现，「边界情况」对应的子串实际上就是我们「扩展」出的回文串的「回文中心」。方法二的本质即为：我们枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。我们对所有的长度求出最大值，即可得到最终的答案。
         */



        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;

    }

    private static boolean isHuiWen(String s) {
        int i=0;
        int len = s.length();
        while (i<len/2){
            if (s.charAt(i) != s.charAt(len-1-i)){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));//bab
        System.out.println(longestPalindrome2("cbbd"));//bb
        System.out.println(longestPalindrome2("a"));//a
        System.out.println(longestPalindrome2("ac"));//a
        System.out.println(longestPalindrome2("abb"));//bb
        System.out.println(longestPalindrome2("aacabdkacaa"));//bb
        System.out.println(isHuiWen("aaa"));
        System.out.println(isHuiWen("abcba"));
        System.out.println(isHuiWen("ab"));
       // System.out.println(longestPalindrome3("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println("比较"+longestPalindrome2("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(longestPalindrome3("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(longestPalindrome3("illliasdfhahdgfranynar"));
        System.out.println(longestPalindrome3("worldadswfilllittlenoetherthatnaptionoranynartionsocon"));
        System.out.println(longestPalindrome3("itionoranynar"));
        System.out.println(longestPalindrome3("onoranynar"));
        System.out.println(longestPalindrome2("tionoranynartion"));
        //"ranynar" illli
    }
}
