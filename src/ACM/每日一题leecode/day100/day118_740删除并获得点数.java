package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day118_740删除并获得点数 {
    /****
     给你一个整数数组 nums ，你可以对它进行一些操作。
     每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
     开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     示例 1：
     输入：nums = [3,4,2]
     输出：6
     解释：
     删除 4 获得 4 个点数，因此 3 也被删除。
     之后，删除 2 获得 2 个点数。总共获得 6 个点数。
     */

    /***
     举个例子：
     nums = [2, 2, 3, 3, 3, 4]
     构造后：
     all=[0, 0, 2, 3, 1];
     就是代表着 22 的个数有两个，33 的个数有 33 个，44 的个数有 11 个。
     其实这样就可以变成打家劫舍的问题了呗。
     我们来看看，打家劫舍的最优子结构的公式：
     dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
     再来看看现在对这个问题的最优子结构公式：
     dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);


     */
    public static void main(String[] args) {
        //System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));//9
        System.out.println(deleteAndEarn(new int[]{1,1,1,2,4,5,5,5,6}));//18
    }

    //动态规划 三个变量max,maxres,tempmax, 一次遍历
    //变量定义成一个数组dp
    public static int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.sort(nums);
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            if (nums[i - 1] == nums[i]) {
                dp[i] += dp[i - 1];
            } else if (nums[i - 1] != nums[i] - 1) {
                dp[i] += max;
            } else {
                //上一个是我这个-1,那么我找一个不等于-1的来
                //在i-2的后面找一个最大值 不如维系两个最大值
                int tempmax = 0;
                for (int j = i - 2; j >= 0; j--) {
                    if (nums[j] != nums[i] - 1 && dp[j]>tempmax) {
                       tempmax = dp[j];
                    }
                }
                dp[i]+=tempmax;
            }

            max = Math.max(dp[i], max);
            //System.out.println(max);
        }

        return max;
    }

    //方法二:去重复方法
    public static int deleteAndEarn2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
//        int[] newnums = new

        Arrays.sort(nums);
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            if (nums[i - 1] == nums[i]) {
                dp[i] += dp[i - 1];
            } else if (nums[i - 1] != nums[i] - 1) {
                dp[i] += max;
            } else {
                //上一个是我这个-1,那么我找一个不等于-1的来
                for (int j = i - 2; j >= 0; j--) {
                    if (nums[j] != nums[i] - 1) {
                        dp[i] += nums[j];
                    }
                }
            }

            max = Math.max(dp[i], max);
            System.out.println(max);
        }

        return max;
    }
}
