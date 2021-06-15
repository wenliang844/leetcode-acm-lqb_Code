package ACM.每日一题leecode.自刷;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leeTop_41缺失的第一个正数 {
    /***
     给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     示例 1：
     输入：nums = [1,2,0]
     输出：3
     */
    //方法一:排序,找到第一个>0的位置 判断这个是不是1 有重复:解决 69 91
    public static int firstMissingPositive(int[] nums) {
        if (nums.length < 1) return 1;
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length && nums[index] <= 0) {
            index++;
        }

        int target = 1;
        while (index < nums.length) {
            if (nums[index] == target) {
                while (index < nums.length && nums[index] == target) {
                    index++;
                }
                target++;
            } else {
                return target;
            }

        }

        return target;
    }

    //方法2:把数字放进哈希表 从1开始枚举正整数,看哈希表中有没有,空间换时间
    public static int firstMissingPositive2(int[] nums) {
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums,nums);
        }
        //再从2开始枚举,看有没有出现在map中,没有的话返回这个target

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
        System.out.println(firstMissingPositive(new int[]{}));
        System.out.println(firstMissingPositive(new int[]{0}));
    }
}
