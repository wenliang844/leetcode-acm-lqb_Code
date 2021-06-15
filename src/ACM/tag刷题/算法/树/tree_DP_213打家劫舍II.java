package ACM.tag刷题.算法.树;

public class tree_DP_213打家劫舍II {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额
     * <p>
     * 分成两种情况
     * 第一个:偷 最后一个不偷
     * 第一个不偷:全部一样
     */

    //100 34  dp[n+1] = max(dp[n],dp[n-1]+num)
    public static int rob(int[] nums) {
        int rob1 = nums[0];
        int norob1 = 0;
        int rob2 = 0;
        int norob2 = 0;
        //情况一:偷了第一个,那么最后一个不能偷 -1
        for (int i = 1; i < nums.length - 1; i++) {
            int tmp = norob1;
            norob1 = Math.max(rob1, norob1);
            rob1 = tmp + nums[i];
        }

        //情况2:不偷第一个,那么你后面的随便搞
        for (int i = 1; i < nums.length; i++) {
            int tmp = norob2;
            norob2 = Math.max(rob2, norob2);
            rob2 = tmp + nums[i];
        }
        return Math.max(Math.max(rob1, norob1), Math.max(rob2, norob2));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
    }
}