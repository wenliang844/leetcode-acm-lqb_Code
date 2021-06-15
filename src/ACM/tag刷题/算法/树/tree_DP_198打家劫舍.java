package ACM.tag刷题.算法.树;

import java.util.Map;

/***
 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

 示例 ：
 输入：[1,2,3,1]
 输出：4
 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class tree_DP_198打家劫舍 {

    //方法一:dp do=noDo+nums[i];noDo=Math.max(do,noDo);    100 22
    public static int rob(int[] nums) {
        //int doit = 0;
        //int noDoit = 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0]=nums[0];//做
        dp[0][1]=0;//不做
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }

        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    //方法2:dp do=noDo+nums[i];noDo=Math.max(do,noDo);    100 89
    public static int rob2(int[] nums) {
        int doit = 0;
        int noDoit = 0;
        /*int[][] dp = new int[nums.length][2];
        dp[0][0]=nums[0];//做
        dp[0][1]=0;//不做*/
        for (int i = 0; i < nums.length; i++) {
            int tmp = noDoit;
            noDoit = Math.max(doit,noDoit);
            doit = tmp+nums[i];
        }

        return Math.max(doit,noDoit);
    }
    //方法3:dp dp[i] = max(dp[i-2]+nums[i], dp[i-1])
    public static int rob3(int[] nums) {
       /* int doit = 0;
        int noDoit = 0;*/
        int[] dp = new int[nums.length];
        dp[0]=nums[0];//做
        dp[1]=nums[1];//不做
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max((dp[i-2]+nums[i]),dp[i-1]);
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
//        dp 方程 dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        System.out.println(rob3(new int[]{1,2,3,1}));
        System.out.println(rob3(new int[]{2,7,9,3,1}));
    }
}
