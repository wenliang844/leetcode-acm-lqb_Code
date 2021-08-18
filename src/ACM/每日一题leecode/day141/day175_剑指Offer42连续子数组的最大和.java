package ACM.每日一题leecode.day141;

public class day175_剑指Offer42连续子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-1}));
        System.out.println(maxSubArray(new int[]{-2,1}));
    }

    //贪心算法 负则0 正则加 更新max
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum+=nums[i];

            if (sum<0){
                sum=0;
            }
            max = Math.max(sum,max);
        }
        return max;
    }

    //动态规划
    public static int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
