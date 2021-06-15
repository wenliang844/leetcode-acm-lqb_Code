package ACM.leecode周赛.第239场周赛;

public class lee1_5746到目标元素的最小距离 {

    /***
     给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
     返回 abs(i - start) 。
     题目数据保证 target 存在于 nums 中。
     示例 1：
     输入：nums = [1,2,3,4,5], target = 5, start = 3
     输出：1
     解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案
     */

    public static void main(String[] args) {
        System.out.println(getMinDistance(new int[]{1, 2, 3, 4, 5},5,3));
    }

    public static int getMinDistance(int[] nums, int target, int start) {

        //模拟就好了
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                min = Math.min(min,Math.abs(i-start));
            }
        }
        return min;
    }
}
