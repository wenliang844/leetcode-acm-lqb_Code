package ACM.tag刷题.算法.动态规划;

import java.util.Arrays;

public class dp_300最长递增子序列 {
    /***
     给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

     示例 1：
     输入：nums = [10,9,2,5,3,7,101,18]
     输出：4
     解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     示例 2：
     输入：nums = [0,1,0,3,2,3]
     输出：4
     示例 3：
     输入：nums = [7,7,7,7,7,7,7]
     输出：1
     */

    //动态规划:dp回探法 74 53
    /***
     nums: 0 1 0 3 2 3
     dp:   1 2 1 3 3 4 只要大于前面的,就可以是前面的dp[index]+1 都不大于,就是+1
     */
    public static int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0] = 1;

        //从dp中取最大值
        int resMax = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    tempMax = Math.max(tempMax,dp[j]);
                }
            }
            dp[i] = tempMax+1;
            resMax = Math.max(resMax,dp[i]);
        }

        //System.out.println(Arrays.toString(dp));


        return resMax;
    }

    /***
     Java NlogN

     class Solution {
     public int lengthOfLIS(int[] nums) {
     int[] res = new int[nums.length];
     int len = 0;
     for (int num: nums) {
     int idx = Arrays.binarySearch(res, 0, len, num);
     idx = idx < 0? -idx - 1: idx;
     res[idx] = num;
     if (idx == len) {
     len++;
     }
     }
     return len;
     }
     }
     相当于维护一个结果数组，如果当前元素比结果数组的值都大的的话，就追加在结果数组后面（相当于递增序列长度加了1）；否则的话用当前元素覆盖掉第一个比它大的元素（这样做的话后续递增序列才有可能更长，即使并没有更长，这个覆盖操作也并没有副作用哈，当然这个覆盖操作可能会让最终的结果数组值并不是最终的递增序列值，这无所谓）
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{1,2,3,4,5,4,3,2}));
        System.out.println(lengthOfLIS(new int[]{0}));
        System.out.println(lengthOfLIS(new int[]{0,1}));

    }
}
