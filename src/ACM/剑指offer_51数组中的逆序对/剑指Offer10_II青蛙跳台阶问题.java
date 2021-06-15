package ACM.剑指offer_51数组中的逆序对;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
示例 3：

输入：n = 0
输出：1
 */
public class 剑指Offer10_II青蛙跳台阶问题 {

    public static void main(String[] args) {

        System.out.println(numWays(2));//2
        System.out.println(numWays(7));//21
        System.out.println(numWays(8));//21
        System.out.println(numWays(9));//21
        System.out.println(numWays2(10));//21
        System.out.println(numWays(44));//21
        System.out.println(numWays(0));//1
    }

    public static int numWays(int n) {
    /*
    方法一:动态规划:
    dp[n] = dp[n-1]+dp[n-2]
    直接使用地推更高效
    使用递归也可
     */

    if (n==0 || n==1){
        return 1;
    }
        int a0 = 1;//台阶0层有0中方法
        int a1 = 1;//台阶1只有1中方法
        //int a2 = 2;//台阶2层有两种方法
        //int a3 = 3;//3层有3种方法
        int a2 = 2;
        for (int i = 2; i <= n; i++) {
           a2=(a0+a1)%1000000007;
           a0=a1;
           a1=a2;
        }

        return a2;
    }

    public static int numWays2(int n) {//超时
        if (n==0 || n==1){
            return 1;
        }
        return numWays2(n-1)+numWays2(n-2);
    }
}
