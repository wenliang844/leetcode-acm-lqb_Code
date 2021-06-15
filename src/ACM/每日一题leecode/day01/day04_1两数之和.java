package ACM.每日一题leecode.day01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day04_1两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum2(nums, 9);
        System.out.println(ints[0]+","+ints[1]);

        int[] nums2 = {3,2,4};
        int[] ints2 = twoSum2(nums2, 9);
        System.out.println(ints2[0]+","+ints2[1]);

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    results[0]=i;
                    results[1]=j;
                }
            }
        }

        return results;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] results = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                results[1]=i;
                results[0]=map.get(nums[i]);
            }

            //key 补数        value下表
            map.put(target-nums[i],i);
            //3   0
            //4   1
            //4   --->有   [1,2]
        }

        return results;
    }
}
