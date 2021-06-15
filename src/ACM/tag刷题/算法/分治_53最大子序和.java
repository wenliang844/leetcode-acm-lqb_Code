package ACM.tag刷题.算法;

import java.util.Arrays;

public class 分治_53最大子序和 {

    /***
     给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     输出：6
     解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */

    //方法一:特殊贪心:思路:小于0则sum置0 一直加,一直和maxSum比较 100 30
    public static int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        //int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum,nums[i]);
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
                continue;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    //方法二:分治 分成三部分 一个0,med 一个包含med的最大值 一个ned+1,len
    //线段树求解最长公共上升子序列问题」的 pushUp
    public static int maxSubArray2(int[] nums) {


        return 0;
    }

    //方法三 动态规划:拿 不拿    错了,要连续的
    public static int maxSubArray3(int[] nums){
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];//拿下
        dp[1][0] = 0;//不拿

        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1])+nums[i];//拿
            dp[1][i] = Math.max(dp[0][i-1],dp[1][i-1]);//不拿
        }

        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        return Math.max(dp[0][nums.length-1],dp[1][nums.length-1]);
    }

    //方法4,动态规划  f(i)=max{f(i−1)+nums[i],nums[i]}
    public static int maxSubArray4(int[] nums){
       int per = 0;
       int maxSum = nums[0];
        for (int num : nums) {
            per = Math.max(per+num,num);//当前面的数字加上我都小于我,那我只好放弃前面的数字
            maxSum = Math.max(maxSum,per);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray1(new int[]{-1}));
        System.out.println(maxSubArray1(new int[]{-1,-2}));
        System.out.println(maxSubArray1(new int[]{-1,-2,9}));
        System.out.println(maxSubArray1(new int[]{-2,1}));
    }
}
