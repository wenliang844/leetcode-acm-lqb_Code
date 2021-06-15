package ACM.每日一题leecode.day100;

public class day136_664奇怪的打印机 {
    /****
     有台奇怪的打印机有以下两个特殊要求：
     打印机每次只能打印由 同一个字符 组成的序列。
     每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
     给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。 
     示例 1：
     输入：s = "aaabbb"
     输出：2
     解释：首先打印 "aaa" 然后打印 "bbb"。
     示例 2：
     输入：s = "aba"
     输出：2
     解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
     */
    public static void main(String[] args) {
        System.out.println(strangePrinter3("aba"));
        System.out.println(strangePrinter3("aaabbb"));
        System.out.println(strangePrinter3("abcabc"));
        System.out.println(strangePrinter3("tbgtgb"));
    }

    //方法一:动态规划之-猜想:dp[i] = dp[i-1]+1; if一样的话,不变
    public static int strangePrinter(String s) {
        int len = s.length();
        int dp[] = new int[len];
        int memory1 = 0;
        int memory2 = 0;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i)==s.charAt(memory2)){
                dp[i]=dp[memory2];
            }else if (s.charAt(i)==s.charAt(memory1)){
                dp[i]=dp[memory1]+1;
                memory1=memory2;
                memory2=i;
            }else {
                dp[i]=dp[memory2]+1;
                memory1=memory2;
                memory2=i;
            }
        }
        return dp[len-1];
    }

    //方法一:动态规划之-猜想:dp[i] = dp[i-1]+1; 只要和前面的有相等的,直接不变
    public static int strangePrinter2(String s) {
        int len = s.length();
        int dp[] = new int[len];
        int memory1 = 0;
//        int memory2 = 0;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            boolean flag = false;
            for (int j = i-1; j >=memory1 ; j--) {
                if (s.charAt(i)==s.charAt(j)){
                    memory1=i;//调参数i j
                    flag = true;
                    break;
                }
            }
            if (flag){
                dp[i]=dp[i-1];
            }else {
                dp[i]=dp[i-1]+1;
            }
        }
        return dp[len-1];
    }

    //方法三:区间动态规划,两端相同则不变,不同则j-1 - i min(ik k+1 j)

    /***
      t b g t g b
     t1                (返回这个数)
     b 1 2 ...........
     g  1 2 2 3
     t   1 2 3
     g    1 2
     b      1          (从这里开始)
     * @param s
     * @return
     */
    public static int strangePrinter3(String s) {
       int dp[][] = new int[s.length()][s.length()];
        for (int i = s.length()-1; i >=0 ; i--) {
            dp[i][i]=1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i][j-1];
                }else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min,dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[0][s.length()-1];
    }

}
