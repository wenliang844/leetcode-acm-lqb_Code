package ACM.leecode周赛.第52场双周赛;

import java.util.Arrays;

public class lee4_5212向下取整数对和 {
    /***
     给你一个整数数组 nums ，请你返回所有下标对 0 <= i, j < nums.length 的 floor(nums[i] / nums[j]) 结果之和。由于答案可能会很大，请你返回答案对109 + 7 取余 的结果。
     函数 floor() 返回输入数字的整数部分。
     1：
     输入：nums = [2,5,9]
     输出：10
     解释：
     floor(2 / 5) = floor(2 / 9) = floor(5 / 9) = 0
     floor(2 / 2) = floor(5 / 5) = floor(9 / 9) = 1
     floor(5 / 2) = 2
     floor(9 / 2) = 4
     floor(9 / 5) = 1
     我们计算每一个数对商向下取整的结果并求和得到 10 。
     */
    public static void main(String[] args) {
        System.out.println(sumOfFlooredPairs(new int[]{2, 5, 9}));//10
        System.out.println(sumOfFlooredPairs(new int[]{7,7,7,7,7,7,7}));//10
    }

    //排序后:计算 2次循环 再加上数组的长度  //超时
    public static int sumOfFlooredPairs(int[] nums) {

        int mod = 1000000007;
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[j]==nums[i]){
                    sum += 2;
                }else {
                    sum += nums[j]/nums[i];
                }
            }
        }
        return sum+len;
    }
    //对每个两倍,三倍之间的数字进行统handler
    public static int sumOfFlooredPairs2(int[] nums) {

        int mod = 1000000007;
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {


        }

        return 0;
    }
}
