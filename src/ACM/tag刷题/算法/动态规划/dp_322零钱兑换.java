package ACM.tag刷题.算法.动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

public class dp_322零钱兑换 {
    /****
     给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     你可以认为每种硬币的数量是无限的。

     示例 1：
     输入：coins = [1, 2, 5], amount = 11
     输出：3
     解释：11 = 5 + 5 + 1
     */

    //麻烦1:coin零钱的面值不固定
    //动态规划,dp[1,2,5] = 1; dp[i] = min(dp[5] + dp[i-5],dp[2]+dp[i-2],dp[1]+dp[i-1]) 1.复杂度好,2.需要超大的面值直接崩了

    //方法二:反其道而行之,先遍历coin 在遍历dp数组 89 54
    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
       /* if (amount == 0) return 0;
        if (amount < coins[0]) return -1;*/
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        //dp[1,2,5]=1
       /* for (int i = 0; i < coins.length; i++) {
            dp[coins[i]] = 1;
        }*/
        for (int i = 0; i < coins.length; i++) {//i直接从最小货币开始

            //dp[i] = min(dp[5] + dp[i-5],dp[2]+dp[i-2],dp[1]+dp[i-1])
            //int min = Integer.MAX_VALUE;
            for (int j = coins[i]; j <= amount/* && coins[j] <= i*/; j++) {//应为零钱的数量不固定
                //if (dp[i - coins[j]]!=0){
                //int temp = 1 + dp[i - coins[j]];//dp[coins[j]] = 1
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
                //}
            }
            //dp[i] = min;
        }

        System.out.println(Arrays.toString(dp));
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    /***


     这道题类似于完全背包问题，每个物品都可以无限使用，但是要求背包必须装满，而且要求背包中的物品数目最少， 归纳为数学问题就是，

     v[i]:代表每种硬币的价值
     x[i]:代表每种硬币拿的个数，0<=x[i]<=amount/v[i]
     所求问题可以归纳为：
     在满足：amount=v1x1+v2x2+v3x3+...+vnxn 的条件下
     求： target=min{x1+x2+x3+....xn}
     最简单的一种思路就是把所有{xi}的组合全部拿出来，然后让target最小即可，利用递归就可以解决问题，但是时间复杂度会很高，但是如果有好的剪枝策略，也可以使用
     另外一种方法就是常规的动态规划，利用一个amout+1长度的dp数组，记录每一个状态的最优解，过程见程序和注释
     public int coinChange(int[] coins, int amount) {
     if(coins.length == 0)
     return -1;

     //声明一个amount+1长度的数组dp，代表各个价值的钱包，第0个钱包可以容纳的总价值为0，其它全部初始化为无穷大
     //dp[j]代表当钱包的总价值为j时，所需要的最少硬币的个数
     int[] dp = new int[amount+1];
     Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);

     //i代表可以使用的硬币索引，i=2代表只在第0个，第1个，第2个这三个硬币中选择硬币
     for (int i = 0; i < coins.length; i++) {
     * 	当外层循环执行一次以后，说明在只使用前i-1个硬币的情况下，各个钱包的最少硬币个数已经得到，
     * 		有些钱包的值还是无穷大，说明在仅使用前i-1个硬币的情况下，不能凑出钱包的价值
     * 	现在开始再放入第i个硬币，要想放如w[i]，钱包的价值必须满足j>=w[i]，所以在开始放入第i个硬币时，j从w[i]开始

     for (int j = coins[i]; j <= amount; j++) {
     * 	如果钱包当前的价值j仅能允许放入一个w[i]，那么就要进行权衡，以获得更少的硬币数
     * 		如果放入0个：此时钱包里面硬币的个数保持不变： v0=dp[j]
     * 		如果放入1个：此时钱包里面硬币的个数为：		v1=dp[j-coins[i]]+1
     * 		 【前提是dp[j-coins[i]]必须有值，如果dp[j-coins[i]]是无穷大，说明无法凑出j-coins[i]价值的钱包，
     * 	              那么把w[i]放进去以后，自然也凑不出dp[j]的钱包】
     * 	所以，此时当钱包价值为j时，里面的硬币数目为 dp[j]=min{v0,v1}
     * 	如果钱包当前价值j能够放入2个w[i]，就要再进行一次权衡
     * 		如果不放人第2个w[i]，此时钱包里面硬币数目为，v1=dp[j]=min{v0,v1}
     * 		如果放入第2个w[i],  此时钱包里面硬币数目为，v2=dp[j-coins[i]]+1
     * 	所以，当钱包的价值为j时，里面的硬币数目为dp[j]=min{v1,v2}=min{v0,v1,v2}
     * 	钱包价值j能允许放入3个，4个.........w[i]，不断更新dp[j]，最后得到在仅使用前i个硬币的时候，每个钱包里的最少硬币数目

     if(dp[j-coins[i]] != Integer.MAX_VALUE) {
     dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
     }
     }
     }
     if(dp[amount] != Integer.MAX_VALUE)
     return dp[amount];
     return -1;
     }
     dao-fa-zi-ran-2
     道法自然
     （编辑过）2019-05-23
     dfs+剪枝，比dp效果好。

     class Solution {
     public int coinChange(int[] coins, int amount) {
     Arrays.sort(coins);
     recursion(coins, amount, 0, coins.length - 1);
     return minCount == Integer.MAX_VALUE ? -1 : minCount;
     }
     int minCount = Integer.MAX_VALUE;
     * 1、按金额从大到小，从多到少（排序，用余数一步到位）
     * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
     * 3、能整除即可返回

     void recursion(int[] coins, int amount, int count, int index) {
     if (index < 0 || count + amount / coins[index] >= minCount) return;
     if (amount % coins[index] == 0) {
     minCount = Math.min(minCount, count + amount / coins[index]);
     return;
     }
     for (int i = amount / coins[index]; i >= 0; i--) {
     recursion(coins, amount - i * coins[index], count + i, index - 1);
     }
     }
     }
     **/
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));//0=0 1 2=1 3=
        System.out.println(coinChange(new int[]{1}, 0));
        System.out.println(coinChange(new int[]{2}, 1));
        System.out.println(coinChange(new int[]{1,2147483647}, 2));
        System.out.println(coinChange(new int[]{474,83,404,3}, 264));//8

    }

}
