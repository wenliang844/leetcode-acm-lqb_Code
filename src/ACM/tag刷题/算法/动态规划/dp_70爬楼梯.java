package ACM.tag刷题.算法.动态规划;

import java.util.Arrays;

public class dp_70爬楼梯 {

    /***
     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

     注意：给定 n 是一个正整数。

     示例 1：

     输入： 2
     输出： 2
     解释： 有两种方法可以爬到楼顶。
     1.  1 阶 + 1 阶
     2.  2 阶
     示例 2：

     输入： 3
     输出： 3
     解释： 有三种方法可以爬到楼顶。
     1.  1 阶 + 1 阶 + 1 阶
     2.  1 阶 + 2 阶
     3.  2 阶 + 1 阶
     */

    //方法一:动态规划:可以爬一层+两层  100 13
    public static int climbStairs(int n){
        if (n<2){
            return n;
        }
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        //System.out.println("这是dp+"+ Arrays.toString(dp));

        return dp[n];

    }
        //精简变量: 100 62
    public static int climbStairs2(int n) {
        if (n<2){
            return n;
        }
        //int dp[] = new int[n+1];
        int one = 1;
        int two = 1;
        //int three = 0;
        for (int i = 2; i <= n; i++) {
            int three = one + two;
            one = two;
            two = three;
        }

        //System.out.println("这是dp+"+ Arrays.toString(dp));

        return two;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(2));
        System.out.println(climbStairs2(3));
        System.out.println(climbStairs2(4));
    }
}
