package ACM.每日一题leecode.day01;

/*
数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

示例 1:

输入: cost = [10, 15, 20]
输出: 15
解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 示例 2:

输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day21_746使用最小花费爬楼梯 {

    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("这是结果===" + minCostClimbingStairs2(cost1));
        System.out.println("这是结果===" + minCostClimbingStairs2(cost2));
    }

    /*public static int minCostClimbingStairs(int[] cost) {
        int sum = 0;
        int len = cost.length;
        for (int i = len; i >=0 ; i-=2) {
            sum += Math.min(dp(cost, 0, len), dp(cost, 1, len));
        }

        return sum;
    }

    public static int dp(int[] cost, int i, int len) {
        if (i == len - 1 || i == len - 2) {
            return cost[i];

        }

        return Math.min(dp(cost, i + 1, len), dp(cost, i + 2, len));
    }*/


    /*public static int minCostClimbingStairs2(int[] cost) {
        int sum0 = cost[0];
        int sum1 = cost[1];
        int sum = Math.max(dp2(cost,0,sum0),dp2(cost,1,sum1));
        return sum;
    }
    int sum3 = 0;
    public static void dp2(int[] cost, int i,int sum) {


        if (i == cost.length-1 ||i==cost.length-2){
            sum3 += cost[i];

        }

        sum3+=Math.max(dp(cost,0,cost[i]),dp(cost,1,cost[i]));

    }*/

    public static int minCostClimbingStairs(int[] cost) {
        int sum = 0;
        int len = cost.length;
        for (int i = len; i >=0 ; i-=1) {
            sum += Math.min(dp(cost, 0, len), dp(cost, 1, len));
        }

        return sum;
    }
    public static int dp(int[] cost,int i,int sum) {
        if (i==cost.length-1||i==cost.length-2){
            return cost[i];
        }

        return Math.min(dp(cost, i+1, sum), dp(cost, i+2,sum));
    }





    public static int minCostClimbingStairs2(int[] cost) {
        int min1 = cost[0];
        int min2 = cost[1];
        int sum = 0;
        for (int i = 2; i < cost.length; i++) {
            sum = Math.min(min1,min2)+cost[i];
            min1 = min2;
            min2 = sum;
        }
        return Math.min(min1,min2);
    }
}
